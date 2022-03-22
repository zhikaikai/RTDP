package com.hogae.rtdp.entity;

import com.hogae.rtdp.enums.DeviceTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 实时数据
 */
@Data
public class RealTimeData implements Serializable {


    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 设备类型
     */
    private DeviceTypeEnum deviceType;

    /**
     * 国际移动设备识别码
     */
    private String IMEI;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 采集数据，JSON
     */
    private String payload;

    /**
     * 注释
     */
    private String notes;



}
