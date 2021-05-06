package xyz.worldyun.espcontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.worldyun.espcontrol.common.base.ResultCodeEnum;
import xyz.worldyun.espcontrol.common.exception.MyException;
import xyz.worldyun.espcontrol.common.util.MyAssert;
import xyz.worldyun.espcontrol.common.util.UserDetail;
import xyz.worldyun.espcontrol.dto.DeviceDto;
import xyz.worldyun.espcontrol.entity.Device;
import xyz.worldyun.espcontrol.entity.User;
import xyz.worldyun.espcontrol.vo.HeartBeatVo;
import xyz.worldyun.espcontrol.mapper.DeviceMapper;
import xyz.worldyun.espcontrol.service.DeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-06
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public void heartBeat(HeartBeatVo heartBeatVo) {
        if (heartBeatVo == null  || heartBeatVo.getMqttId() == null || heartBeatVo.getMqttId().length() == 0) {
            return;
        }

        Device tmp = new Device();
        tmp.setMqttId(heartBeatVo.getMqttId());

        Device device = deviceMapper.selectByMqttId(tmp);
        if (device == null) {
            device = new Device();
            device.setMqttId(heartBeatVo.getMqttId());
            deviceMapper.insert(device);
        }
        device.setLastHeartbeatTime(new Date());
        device.setModifyTime(new Date());
        deviceMapper.updateById(device);
    }

    @Override
    public Device add(Device device) {
        MyAssert.notNull(device, ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(device.getDeviceName(), ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(device.getMqttId(), ResultCodeEnum.PARAM_ERROR);
        User userDetail = UserDetail.getUserDetail();

        Device device1 = deviceMapper.selectByMqttId(device);
        if (device1 != null) {      //设备存在
             if(device1.getUserId() == null){       //设备未绑定，绑定设备
                 device1.setUserId(userDetail.getId());
                 device1.setDeviceName(device.getDeviceName());
                 device1.setModifyTime(new Date());
                 deviceMapper.updateById(device1);
             }else {        //设备已绑定 报错
                throw new MyException(ResultCodeEnum.DEVICE_ALREADY_EXISTS);
             }
             return device1;
        }

        //设备不存在，添加设备
        device.setUserId(userDetail.getId());
        deviceMapper.insert(device);
        return device;
    }

    @Override
    public boolean delete(Device device) {
        MyAssert.notNull(device, ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(device.getMqttId(), ResultCodeEnum.PARAM_ERROR);

        Device device1 = deviceMapper.selectByMqttId(device);
        MyAssert.notNull(device1, ResultCodeEnum.NO_DEVICE);

        User userDetail = UserDetail.getUserDetail();
        if ( !userDetail.getId().equals(device1.getUserId())){
            throw new MyException(ResultCodeEnum.NO_PERMISSION);
        }

        deviceMapper.deleteById(device1.getId());
        return true;
    }

    @Override
    public Device update(Device device) {
        MyAssert.notNull(device, ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(device.getMqttId(), ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(device.getDeviceName(), ResultCodeEnum.PARAM_ERROR);

        Device device1 = deviceMapper.selectByMqttId(device);
        MyAssert.notNull(device1, ResultCodeEnum.NO_DEVICE);

        device1.setDeviceName(device.getDeviceName());
        device1.setModifyTime(new Date());
        deviceMapper.updateById(device1);
        return device;
    }

    @Override
    public List<DeviceDto> list(Device device) {
        List<DeviceDto> deviceDtos = deviceMapper.list(device);
        return deviceDtos;
    }
}
