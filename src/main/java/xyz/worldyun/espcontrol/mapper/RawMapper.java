package xyz.worldyun.espcontrol.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.worldyun.espcontrol.entity.Button;
import xyz.worldyun.espcontrol.entity.Raw;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
@Mapper
public interface RawMapper extends BaseMapper<Raw> {

    Raw selectByBottonId(Button button);
}
