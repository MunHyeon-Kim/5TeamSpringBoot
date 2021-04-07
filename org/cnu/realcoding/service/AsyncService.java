package org.cnu.realcoding.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@EnableAsync
public class AsyncService {
    AtomicLong counter = new AtomicLong();

    @Async
    public void increaseCounter(){
        for (int i = 0; i < 1000000; i++){

        }
    }

}
