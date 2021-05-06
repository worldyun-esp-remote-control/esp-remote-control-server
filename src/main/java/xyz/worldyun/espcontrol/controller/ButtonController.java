package xyz.worldyun.espcontrol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.worldyun.espcontrol.common.base.R;
import xyz.worldyun.espcontrol.entity.Button;
import xyz.worldyun.espcontrol.service.ButtonService;

import java.util.List;

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

    @PostMapping("/add")
    public R add(@RequestBody Button button){
        button = buttonService.add(button);
        return R.ok().data("button", button);
    }

    @DeleteMapping("/delete")
    public R delete(Button button){
        buttonService.delete(button);
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestBody Button button){
        button = buttonService.update(button);
        return R.ok().data("button", button);
    }

    @GetMapping("/list")
    public R list(Button button){
        List<Button> buttons = buttonService.list(button);
        return R.ok().data("list", buttons);
    }
}

