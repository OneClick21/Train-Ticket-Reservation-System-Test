package com.shashi.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shashi.constant.ResponseCode;

public class TrainExceptionTest {

    @Test
    public void testTrainExceptionWithResponseCode() {
        ResponseCode errorCode = ResponseCode.SUCCESS; // Using the SUCCESS enum
        TrainException exception = new TrainException(errorCode);

        assertEquals(errorCode.getMessage(), exception.getMessage());
        assertEquals(errorCode.getCode(), exception.getStatusCode());
        assertEquals(errorCode.name(), exception.getErrorCode());
        assertEquals(errorCode.getMessage(), exception.getErrorMessage());
    }

    @Test
    public void testTrainExceptionWithErrorMessage() {
        String errorMessage = "Test Error Message";
        TrainException exception = new TrainException(errorMessage);

        assertEquals("BAD_REQUEST", exception.getErrorCode());
        assertEquals(400, exception.getStatusCode());
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(errorMessage, exception.getErrorMessage());
    }

    @Test
    public void testTrainExceptionWithStatusCodeAndErrorCode() {
        int statusCode = 500;
        String errorCode = "INTERNAL_SERVER_ERROR";
        String errorMessage = "Internal Server Error";
        TrainException exception = new TrainException(statusCode, errorCode, errorMessage);

        assertEquals(statusCode, exception.getStatusCode());
        assertEquals(errorCode, exception.getErrorCode());
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(errorMessage, exception.getErrorMessage());
    }
}
