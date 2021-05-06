package xyz.worldyun.espcontrol.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
//        this.setFieldValByName("creatTime", new Date(), metaObject);
//        this.setFieldValByName("modifyTime", new Date(), metaObject);
        this.strictInsertFill(metaObject, "creatTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "modifyTime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("modifyTime", new Date(), metaObject);
        this.strictUpdateFill(metaObject, "modifyTime", Date.class, new Date());
    }
}
