package xyz.worldyun.espcontrol.mqtt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.*;
import org.springframework.stereotype.Component;
import xyz.worldyun.espcontrol.vo.HeartBeatVo;
import xyz.worldyun.espcontrol.service.DeviceService;
import xyz.worldyun.espcontrol.vo.LearnVo;
import xyz.worldyun.espcontrol.service.RawService;

/**
 * @author WorldYun
 * @date 2021/05/05
 */
@Slf4j
@Component
public class MqttMessageHandler implements MessageHandler {

    @Autowired
    RawService rawService;

    @Autowired
    DeviceService deviceService;

    @ServiceActivator(inputChannel = "channel1")
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        MessageHeaders headers = message.getHeaders();
        String payload = (String) message.getPayload();
        String mqttReceivedTopic = (String) headers.get("mqtt_receivedTopic");
        if ("/upload".equals(mqttReceivedTopic)){
            try {
                HeartBeatVo heartBeatVo = JSON.parseObject(payload, new TypeReference<HeartBeatVo>(){});
                deviceService.heartBeat(heartBeatVo);
            }catch (JSONException e){
                log.error("Upload Json parse error ---- {}", payload);
            }


        }
        if ("/learn".equals(mqttReceivedTopic)){
            try {
                LearnVo learnVo = JSON.parseObject(payload, new TypeReference<LearnVo>(){});
                rawService.deviceLearn(learnVo);
            }catch (JSONException e){
                log.error("Learn Json parse error ---- {}", payload);
            }

        }
    }

}

