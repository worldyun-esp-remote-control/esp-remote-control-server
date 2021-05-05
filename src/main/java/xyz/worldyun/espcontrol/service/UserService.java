package xyz.worldyun.espcontrol.service;

import xyz.worldyun.espcontrol.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.worldyun.espcontrol.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param user
     * @return token
     */
    String signIn(User user);

    /**
     * 注册
     * @param user
     * @return user
     */
    User signUp(User user);

    /**
     * 修改密码
     * @param userVo
     * @return user
     */
    User updatePassword(UserVo userVo);

    /**
     * 删除账户
     */
    void delete();
}
