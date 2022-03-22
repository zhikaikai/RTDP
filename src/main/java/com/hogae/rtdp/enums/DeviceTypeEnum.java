package com.hogae.rtdp.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum DeviceTypeEnum {

    VIDEO_ALARM_MSG("videoAlarmMsg","视频报警"),
    MANHOLE_COVER("manholeCover","井盖"),
    LAMP_POLE("lampPole","灯杆");

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
