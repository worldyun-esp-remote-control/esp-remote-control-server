package xyz.worldyun.espcontrol.service.impl;

import cn.xyliang.mqtt.utils.MqttUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.worldyun.espcontrol.common.base.ResultCodeEnum;
import xyz.worldyun.espcontrol.common.exception.MyException;
import xyz.worldyun.espcontrol.common.util.MyAssert;
import xyz.worldyun.espcontrol.common.util.UserDetail;
import xyz.worldyun.espcontrol.entity.Button;
import xyz.worldyun.espcontrol.entity.Device;
import xyz.worldyun.espcontrol.entity.Raw;
import xyz.worldyun.espcontrol.entity.User;
import xyz.worldyun.espcontrol.mapper.ButtonMapper;
import xyz.worldyun.espcontrol.mapper.DeviceMapper;
import xyz.worldyun.espcontrol.mapper.RawMapper;
import xyz.worldyun.espcontrol.service.ButtonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.worldyun.espcontrol.vo.LearnVo;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
@Slf4j
@Service
public class ButtonServiceImpl extends ServiceImpl<ButtonMapper, Button> implements ButtonService {

    @Autowired
    ButtonMapper buttonMapper;

    @Autowired
    RawMapper rawMapper;

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public void learn(Button button) {
        MyAssert.notNull(button, ResultCodeEnum.PARAM_ERROR);
        MyAssert.notNull(button.getId(), ResultCodeEnum.PARAM_ERROR);

        Button button1 = buttonMapper.selectById(button.getId());
        MyAssert.notNull(button1, ResultCodeEnum.PARAM_ERROR);
        User userDetail = UserDetail.getUserDetail();
        if (!userDetail.getId().equals(button1.getUserId())){
            throw new MyException(ResultCodeEnum.NO_PERMISSION);
        }

        Device device = deviceMapper.selectById(button1.getDeviceId());

        Raw raw = rawMapper.selectByBottonId(button);
        if (raw == null) {
            raw = new Raw();
            raw.setButtonId(button.getId());
            rawMapper.insert(raw);
        }
        LearnVo learnVo = new LearnVo();
        learnVo.setRawID(raw.getId());

        JSONObject msg = new JSONObject();
        msg.put("id", 1);
        msg.put("codeType", 2);
        msg.put("data", learnVo);
        log.info("Learn Json ----------- {}",msg.toJSONString());
        String topic = "/device/" + device.getMqttId();
        MqttUtils.sendMessage(topic, msg.toJSONString(), 2);
    }

    @Override
    public void press(Button button) {

    }
}
