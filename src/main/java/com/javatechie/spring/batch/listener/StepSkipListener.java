package com.javatechie.spring.batch.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.spring.batch.entity.Customer;
import lombok.SneakyThrows;
import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<Customer, Number> {

    @Override
    public void onSkipInRead(Throwable throwable) {
        System.out.println(" A failure on read " + throwable.getMessage());
    }

    @Override
    public void onSkipInWrite(Number item, Throwable throwable) {
        System.out.println("This item failed on write " + item);
    }

    @SneakyThrows
    @Override
    public void onSkipInProcess(Customer item, Throwable throwable) {
        System.out.println("Item   " + new ObjectMapper().writeValueAsString(item) + " was skipped due to Exception " + throwable.getMessage());

    }
}
