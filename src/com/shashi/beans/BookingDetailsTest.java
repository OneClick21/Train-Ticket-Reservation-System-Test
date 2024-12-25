package com.shashi.beans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingDetailsTest {

    private BookingDetails bookingDetails;

    @Before
    public void setUp() {
        bookingDetails = new BookingDetails();
    }

    @Test
    public void testSetAndGetMailId() {
        String mailId = "test@example.com";
        bookingDetails.setMailId(mailId);
        assertEquals(mailId, bookingDetails.getMailId());
    }

    @Test
    public void testSetAndGetTr_no() {
        String tr_no = "TR1234";
        bookingDetails.setTr_no(tr_no);
        assertEquals(tr_no, bookingDetails.getTr_no());
    }

    @Test
    public void testSetAndGetDate() {
        String date = "12-12-2024";
        bookingDetails.setDate(date);
        assertEquals(date, bookingDetails.getDate());
    }

    @Test
    public void testSetAndGetFrom_stn() {
        String from_stn = "StationA";
        bookingDetails.setFrom_stn(from_stn);
        assertEquals(from_stn, bookingDetails.getFrom_stn());
    }

    @Test
    public void testSetAndGetTo_stn() {
        String to_stn = "StationB";
        bookingDetails.setTo_stn(to_stn);
        assertEquals(to_stn, bookingDetails.getTo_stn());
    }

    @Test
    public void testSetAndGetSeats() {
        int seats = 3;
        bookingDetails.setSeats(seats);
        assertEquals(seats, bookingDetails.getSeats());
    }

    @Test
    public void testSetAndGetAmount() {
        Double amount = 150.75;
        bookingDetails.setAmount(amount);
        assertEquals(amount, bookingDetails.getAmount(), 0);
    }
}

