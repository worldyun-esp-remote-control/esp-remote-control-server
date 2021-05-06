package xyz.worldyun.espcontrol.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.worldyun.espcontrol.dto.DeviceDto;
import xyz.worldyun.espcontrol.entity.Device;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.worldyun.espcontrol.vo.HeartBeatVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-06
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

    Device selectByMqttId(Device device);

    List<DeviceDto> list(Device device);
}
