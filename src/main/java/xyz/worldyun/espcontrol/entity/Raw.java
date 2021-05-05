package xyz.worldyun.espcontrol.entity;

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
    public class Raw implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * raw id
     */
        private Integer id;

      /**
     * 按钮id
     */
      private Integer bottonId;

      /**
     * 序列化存储raw数据
     */
      private String rawString;

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
      private Integer isDelete;


}
