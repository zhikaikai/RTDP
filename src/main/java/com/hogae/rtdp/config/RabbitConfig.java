package com.hogae.rtdp.config;
import com.hogae.rtdp.enums.DeviceTypeEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 井盖队列
     *
     * @return
     */
    @Bean("manholeCover")
    public Queue manholeCoverQueue() {
        return new Queue(DeviceTypeEnum.MANHOLE_COVER.getCode());
    }

    /**
     * 视频报警
     *
     * @return
     */
    @Bean("videoAlarmMsg")
    public Queue videoAlarmMsgQueue() {
        return new Queue(DeviceTypeEnum.VIDEO_ALARM_MSG.getCode());
    }

    /**
     * 灯杆队列
     *
     * @return
     */
    @Bean("lampPole")
    public Queue lampPoleQueue() {
        return new Queue(DeviceTypeEnum.LAMP_POLE.getCode());
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("springboot.rtdp");
    }

    @Bean
    Binding manholeCoverBinding(@Qualifier("manholeCover") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("manhole.cover.#");
    }
    @Bean
    Binding lampPoleBinding(@Qualifier("lampPole") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("lamp.pole.#");
    }
    @Bean
    Binding videoAlarmMsgBinding(@Qualifier("videoAlarmMsg") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("video.alarm.msg.#");
    }

}