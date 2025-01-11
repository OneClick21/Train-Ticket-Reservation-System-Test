package com.shashi.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Optional;

public class ResponseCodeTest {

    @Test
    public void testGetMessage() {
        assertEquals("OK", ResponseCode.SUCCESS.getMessage());
        assertEquals("Unprocessible Entity, Failed to Process", ResponseCode.FAILURE.getMessage());
        assertEquals("No Items Found", ResponseCode.NO_CONTENT.getMessage());
        assertEquals("The Page You are Searching For is Not available", ResponseCode.PAGE_NOT_FOUND.getMessage());
        assertEquals("Please Login First to continue", ResponseCode.ACCESS_DENIED.getMessage());
        assertEquals("Bad Request, Please Try Again", ResponseCode.BAD_REQUEST.getMessage());
        assertEquals("Invalid Credentials, Try Again", ResponseCode.UNAUTHORIZED.getMessage());
        assertEquals("Session Expired, Login Again to Continue", ResponseCode.SESSION_EXPIRED.getMessage());
        assertEquals("Internal Server Error, Try Again!!", ResponseCode.INTERNAL_SERVER_ERROR.getMessage());
        assertEquals("Unable to Connect to DB, Please Check your db credentials in application.properties", ResponseCode.DATABASE_CONNECTION_FAILURE.getMessage());
        assertEquals("Requested HTTP method is not supported by this URL", ResponseCode.METHOD_NOT_ALLOWED.getMessage());
    }

    @Test
    public void testGetCode() {
        assertEquals(200, ResponseCode.SUCCESS.getCode());
        assertEquals(422, ResponseCode.FAILURE.getCode());
        assertEquals(204, ResponseCode.NO_CONTENT.getCode());
        assertEquals(404, ResponseCode.PAGE_NOT_FOUND.getCode());
        assertEquals(403, ResponseCode.ACCESS_DENIED.getCode());
        assertEquals(400, ResponseCode.BAD_REQUEST.getCode());
        assertEquals(401, ResponseCode.UNAUTHORIZED.getCode());
        assertEquals(401, ResponseCode.SESSION_EXPIRED.getCode());
        assertEquals(500, ResponseCode.INTERNAL_SERVER_ERROR.getCode());
        assertEquals(406, ResponseCode.DATABASE_CONNECTION_FAILURE.getCode());
        assertEquals(405, ResponseCode.METHOD_NOT_ALLOWED.getCode());
    }

    @Test
    public void testGetMessageByStatusCode() {
        Optional<ResponseCode> successCode = ResponseCode.getMessageByStatusCode(200);
        Optional<ResponseCode> failureCode = ResponseCode.getMessageByStatusCode(422);

        assertTrue(successCode.isPresent());
        assertEquals(ResponseCode.SUCCESS, successCode.get());

        assertTrue(failureCode.isPresent());
        assertEquals(ResponseCode.FAILURE, failureCode.get());
    }

    @Test
    public void testGetMessageByInvalidStatusCode() {
        Optional<ResponseCode> invalidCode = ResponseCode.getMessageByStatusCode(999);

        assertTrue(!invalidCode.isPresent());
    }
}
