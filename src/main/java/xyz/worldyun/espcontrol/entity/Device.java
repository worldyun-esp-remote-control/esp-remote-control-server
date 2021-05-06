package xyz.worldyun.espcontrol.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author WorldYun
 * @since 2021-05-06
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Device implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 设备id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 设备名
     */
      private String deviceName;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 设备mqtt
     */
      private String mqttId;

      /**
     * 上一次心跳时间
     */
      private Date lastHeartbeatTime;

      /**
     * 创建时间
     */
      @TableField(value = "creat_time", fill = FieldFill.INSERT)
      private Date creatTime;

      /**
     * 修改时间
     */
      @TableField(value = "modify_time" ,fill = FieldFill.INSERT_UPDATE)
      private Date modifyTime;

      /**
     * 逻辑删除：0：未删除，1：已删除
     */
      private Boolean isDelete;


}
