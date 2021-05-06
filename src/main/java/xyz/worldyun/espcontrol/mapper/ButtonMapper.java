package xyz.worldyun.espcontrol.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.worldyun.espcontrol.entity.Button;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
@Mapper
public interface ButtonMapper extends BaseMapper<Button> {

    List<Button> list(Button button);
}
