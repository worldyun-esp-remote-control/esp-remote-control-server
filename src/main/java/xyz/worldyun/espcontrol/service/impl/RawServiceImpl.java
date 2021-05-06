package xyz.worldyun.espcontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.worldyun.espcontrol.vo.LearnVo;
import xyz.worldyun.espcontrol.entity.Raw;
import xyz.worldyun.espcontrol.mapper.RawMapper;
import xyz.worldyun.espcontrol.service.RawService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

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
public class RawServiceImpl extends ServiceImpl<RawMapper, Raw> implements RawService {

    @Autowired
    RawMapper rawMapper;

    @Override
    public void deviceLearn(LearnVo learn) {
        if (learn == null || learn.getRawID() == null || learn.getRaw() == null || learn.getRaw().isEmpty()){
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("raw", learn.getRaw());

        Raw raw = rawMapper.selectById(learn.getRawID());
        raw.setRawString(jsonObject.toJSONString());
        raw.setModifyTime(new Date());
        rawMapper.updateById(raw);
    }
}
