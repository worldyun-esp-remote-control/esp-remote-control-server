package xyz.worldyun.espcontrol.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
      private LocalDateTime lastHeartbeatTime;

      /**
     * 创建时间
     */
      private LocalDateTime creatTime;

      /**
     * 修改时间
     */
      private LocalDateTime modifyTime;

      /**
     * 逻辑删除：0：未删除，1：已删除
     */
      private Boolean isDelete;


}
