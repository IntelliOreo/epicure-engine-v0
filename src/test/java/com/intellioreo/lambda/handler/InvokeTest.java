package com.intellioreo.lambda.handler;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


class InvokeTest {
    private static final Logger logger = LoggerFactory.getLogger(InvokeTest.class);

    @Test
    void testHandler() {
        logger.info("Invoke TEST - Handler");
        var event = 10;
        Context context = new TestContext();
        Handler handler = new Handler();
        assertNull(handler.handleRequest(List.of(event), context));
    }

}