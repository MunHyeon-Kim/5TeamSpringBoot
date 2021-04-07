package org.cnu.realcoding.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Slf4j
public class MyBatchService {

    @Scheduled(fixedDelay = 1000L)
    public void count() {

    }

}
