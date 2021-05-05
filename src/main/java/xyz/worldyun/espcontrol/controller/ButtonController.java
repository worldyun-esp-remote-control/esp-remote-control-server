package xyz.worldyun.espcontrol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.worldyun.espcontrol.common.base.R;
import xyz.worldyun.espcontrol.entity.Button;
import xyz.worldyun.espcontrol.service.ButtonService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/api/button")
public class ButtonController {

    @Autowired
    ButtonService buttonService;

    @PostMapping("/learn")
    public R learn(@RequestBody Button button){

        buttonService.learn(button);
        return R.ok();
    }

    @PostMapping("/press")
    public R press(@RequestBody Button button){
        buttonService.press(button);
        return R.ok();
    }
}

