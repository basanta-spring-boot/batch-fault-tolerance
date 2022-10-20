package com.javatechie.spring.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

public class CustomSkipPolicy implements SkipPolicy {

    private static final Logger logger = LoggerFactory.getLogger(CustomSkipPolicy.class);

    @Override
    public boolean shouldSkip(Throwable exception, int skipCount) throws SkipLimitExceededException {

        if (exception instanceof NumberFormatException) {
            return true;
        }

        return false;
    }
}
