package xyz.worldyun.espcontrol.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author WorldYun
 * @date 2021/05/06
 */
@Data
public class DeviceDto {
    private Integer id;
    private String deviceName;
    private Date lastHeartbeatTime;
    private Boolean onLine;
}
