package xyz.worldyun.espcontrol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.worldyun.espcontrol.common.base.R;
import xyz.worldyun.espcontrol.vo.LearnVo;
import xyz.worldyun.espcontrol.service.RawService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/api/raw")
public class RawController {

    @Autowired
    RawService rawService;

}

