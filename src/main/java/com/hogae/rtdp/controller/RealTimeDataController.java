package com.hogae.rtdp.controller;

import com.hogae.rtdp.entity.DahuaICC;
import com.hogae.rtdp.entity.ManholeCover;
import com.hogae.rtdp.entity.RealTimeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@Slf4j
public class RealTimeDataController {

    final static String manholeCoverName = "manholeCover";


    final static String videoAlarmMsg = "videoAlarmMsg";

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping("/manholeCover")
    public String manholeCover(@RequestBody ManholeCover manholeCover){
        String msg = "fail";
        try {
            amqpTemplate.convertAndSend(manholeCoverName,manholeCover);
            msg = "success";
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return msg;
    }

    @PostMapping("/lampPole")
    public String lampPole(@RequestBody RealTimeData realTimeData){
        String msg = "fail";
        try {
            amqpTemplate.convertAndSend(realTimeData.getDeviceType().getCode(),realTimeData);
            msg = "success";
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "success";
    }

    /**
     * 大华视频报警订阅数据
     * @param realTimeData
     * @return
     */
    @PostMapping("/icc")
    public String icc(@RequestBody DahuaICC realTimeData){
        String msg = "false";
        try {
            if(realTimeData.getCategory().equals("alarm") &&
                    realTimeData.getMethod().equals("alarm.msg") ){
                amqpTemplate.convertAndSend(videoAlarmMsg,realTimeData);
            }
            msg = "true";
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "true";
    }
}
