package xyz.worldyun.espcontrol.service;

import xyz.worldyun.espcontrol.entity.Button;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-05
 */
public interface ButtonService extends IService<Button> {

    void learn(Button button);

    void press(Button button);

    Button add(Button button);

    boolean delete(Button button);

    Button update(Button button);

    List<Button> list(Button button);
}
