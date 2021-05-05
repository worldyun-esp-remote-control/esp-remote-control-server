package xyz.worldyun.espcontrol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.worldyun.espcontrol.common.base.R;
import xyz.worldyun.espcontrol.common.util.UserDetail;
import xyz.worldyun.espcontrol.entity.User;
import xyz.worldyun.espcontrol.service.UserService;
import xyz.worldyun.espcontrol.vo.UserVo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return token
     */
    @PostMapping("/signIn")
    public R login(@RequestBody User user){
        String token = userService.signIn(user);
        return R.ok().data("token",token);
    }

    /**
     * 获取用户信息
     * @param
     * @return user
     */
    @GetMapping("/info")
    public R info(){
        User user = UserDetail.getUserDetail();
        return R.ok().data("user", user);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/signUp")
    public R signUp(@RequestBody User user){

        userService.signUp(user);
        return R.ok();
    }

    /**
     * 更新密码
     * @param userVo
     * @return
     */
    @PostMapping("/updatePassword")
    public R updatePassword(@RequestBody UserVo userVo){

        User user = userService.updatePassword(userVo);
        return R.ok();
    }


    /**
     * 删除账户
     * @param
     * @return
     */
    @DeleteMapping("/delete")
    public R deleteUser(){
        userService.delete();
        return R.ok().message("删除成功");
    }

    @PostMapping("/logout")
    public R logout() {
        return R.ok();
    }

}

