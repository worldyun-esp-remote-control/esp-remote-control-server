package xyz.worldyun.espcontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.worldyun.espcontrol.common.base.ResultCodeEnum;
import xyz.worldyun.espcontrol.common.exception.MyException;
import xyz.worldyun.espcontrol.common.util.JwtInfo;
import xyz.worldyun.espcontrol.common.util.JwtUtils;
import xyz.worldyun.espcontrol.common.util.MyAssert;
import xyz.worldyun.espcontrol.common.util.UserDetail;
import xyz.worldyun.espcontrol.entity.User;
import xyz.worldyun.espcontrol.mapper.UserMapper;
import xyz.worldyun.espcontrol.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.worldyun.espcontrol.vo.UserVo;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String signIn(User user) {
        valid(user);
        User user1 = userMapper.selectByUserName(user);
        MyAssert.notNull(user1, ResultCodeEnum.LOGIN_USERNAME_OR_PASSWORD_ERROR);
        if ( !user1.getPassword().equals(user.getPassword()) ){
            throw new MyException(ResultCodeEnum.LOGIN_USERNAME_OR_PASSWORD_ERROR);
        }
        JwtInfo jwtInfo = new JwtInfo(user1.getId(), user1.getUserName());
        return JwtUtils.getJwtToken(jwtInfo, 60*60*24*30);
    }

    @Override
    public User signUp(User user) {
        valid(user);
        MyAssert.isNull(userMapper.selectByUserName(user), ResultCodeEnum.SIGN_UP_USERNAME_USED);
        if (userMapper.insert(user) != 1) {
            throw new MyException(ResultCodeEnum.SIGN_UP_ERROR);
        }
        return user;
    }

    @Override
    public User updatePassword(UserVo userVo) {
        MyAssert.notNull(userVo, ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(userVo.getPassword(), ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(userVo.getNewPassword(), ResultCodeEnum.PARAM_ERROR);

        User userDetail = UserDetail.getUserDetail();
        User user = userMapper.selectById(userDetail);
        if (!userDetail.getPassword().equals(user.getPassword())){
            throw new MyException(ResultCodeEnum.PASSWORD_ERROR);
        }
        user.setPassword(userVo.getNewPassword());
        user.setModifyTime(new Date());
        userMapper.updateById(user);
        return user;
    }

    @Override
    public void delete() {
        User userDetail = UserDetail.getUserDetail();
        userMapper.deleteById(userDetail);
    }

    @Override
    public String refresh() {
        User userDetail = UserDetail.getUserDetail();
        JwtInfo jwtInfo = new JwtInfo(userDetail.getId(), userDetail.getUserName());
        return JwtUtils.getJwtToken(jwtInfo, 60*60*24*30);
    }

    public void valid(User user){
        MyAssert.notNull(user, ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(user.getUserName(), ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(user.getPassword(), ResultCodeEnum.PARAM_ERROR);
    }
}
