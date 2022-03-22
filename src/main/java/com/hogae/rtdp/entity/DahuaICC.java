package com.hogae.rtdp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 大华摄像头报警
 */
@Data
public class DahuaICC  implements Serializable {
    //id序号
    private int id;
    //固定
    private String category;
    //固定
    private String method;
    private Info info;
    private String domainId;
    //子系统名称
    private String subsystem;

    @Data
    static class Info  implements Serializable{
        private String linkIds;
        //设备号
        private String deviceCode;
        //设备名称
        private String deviceName;
        //通道号
        private int channelSeq;
        //单元类型
        private int unitType;
        //单元号
        private int unitSeq;
        //通道名称
        private String channelName;
        //报警编号UUID
        private String alarmCode;
        //报警状态: 1：报警产生，2：报警消失
        private int alarmStat;
        //报警类型
        private int alarmType;
        //报警等级
        private int alarmGrade;
        //报警时间
        private String alarmDate;
        //报警图片路径
        private String alarmPicture;
        //报警图片大小
        private int alarmPictureSize;
        private String memo;
        //备注
        private int nodeType;
        private String nodeCode;
        private Object extend;
    }

}
