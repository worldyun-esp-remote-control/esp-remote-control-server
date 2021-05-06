package xyz.worldyun.espcontrol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import xyz.worldyun.espcontrol.common.base.R;
import xyz.worldyun.espcontrol.dto.DeviceDto;
import xyz.worldyun.espcontrol.entity.Device;
import xyz.worldyun.espcontrol.service.DeviceService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-06
 */
@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/add")
    public R add(@RequestBody Device device){
        device = deviceService.add(device);
        return R.ok().data("device", device);
    }

    @DeleteMapping("/delete")
    public R delete(Device device){
        deviceService.delete(device);
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestBody Device device){
        device = deviceService.update(device);
        return R.ok().data("device", device);
    }

    @GetMapping("/list")
    public R list(Device device){
        List<DeviceDto> devices = deviceService.list(device);
        return R.ok().data("devices", devices);
    }
}

