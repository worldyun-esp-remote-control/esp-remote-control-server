package xyz.worldyun.espcontrol.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    public class Switch implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * switch id
     */
      @TableId(value = "id", type = IdType.AUTO)
        private Integer id;

      /**
     * 开关名称
     */
      private String switchName;

      /**
     * 用户id
     */
      private Integer userId;


}
