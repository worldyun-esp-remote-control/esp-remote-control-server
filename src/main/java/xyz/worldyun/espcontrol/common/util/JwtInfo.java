package xyz.worldyun.espcontrol.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author helen
 * @since 2020/4/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtInfo {

    private Integer id;
    private String userName;
    //权限、角色等
    //不要存敏感信息
}
