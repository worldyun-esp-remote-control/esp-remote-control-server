package xyz.worldyun.espcontrol.service;

import xyz.worldyun.espcontrol.dto.DeviceDto;
import xyz.worldyun.espcontrol.entity.Device;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.worldyun.espcontrol.vo.HeartBeatVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-06
 */
public interface DeviceService extends IService<Device> {

    void heartBeat(HeartBeatVo heartBeatVo);

    Device add(Device device);

    boolean delete(Device device);

    Device update(Device device);

    List<DeviceDto> list(Device device);
}
