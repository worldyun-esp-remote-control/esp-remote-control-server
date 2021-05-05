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
 * @since 2021-05-05
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Botton implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * botton id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 按钮名称
     */
      private String name;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 设备id
     */
      private Integer deviceId;

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
