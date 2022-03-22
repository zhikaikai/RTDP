package com.hogae.rtdp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 井盖信息
 */
@Data
public class ManholeCover implements Serializable {
    private int upPacketSN;
    private String deviceType;
    private String productId;
    private String IMEI;
    private String deviceId;
    private String protocol;
    private String messageType;
    private Payload payload;
    private String assocAssetId;
    private String tenantId;
    private String IMSI;
    private String topic;
    private int upDataSN;
    private int serviceId;
    private long timestamp;

    @Data
    static class Payload implements Serializable {
        /**
         * 信号强度
         */
        private int CSQ;
        /**
         * 电量(mv)
         */
        private int battery_level;
        /**
         * 纬度
         */
        private int latitude;
        /**
         * 温度
         */
        private int temperature;
        /**
         * 是否溢出 0 未溢出 1 溢出
         */
        private int liquid_level_over;
        /**
         * 倾斜角度
         */
        private int lean_angle;
        /**
         * 经度
         */
        private int longitude;
    }
}
