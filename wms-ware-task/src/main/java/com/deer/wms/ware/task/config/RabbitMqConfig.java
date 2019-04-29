package com.deer.wms.ware.task.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class RabbitMqConfig {

    /*@Bean
    public Queue countPalletBatchQueue(){
        return new Queue("count-pallet-batch-queue");
    };*/
}
