package com.shashi.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shashi.beans.HistoryBean;
import com.shashi.beans.TrainException;
import com.shashi.constant.ResponseCode;
import com.shashi.utility.DBUtil;

public class BookingServiceImplTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(DBUtil.getConnection()).thenReturn(mockConnection);
    }

    @Test
    public void testGetAllBookingsByCustomerId() throws Exception {
        String email = "test@example.com";
        String query = "SELECT * FROM HISTORY WHERE MAILID=?";
        
        when(mockConnection.prepareStatement(query)).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        System.out.println(mockPreparedStatement.executeQuery());
        
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("transid")).thenReturn("transid");
        when(mockResultSet.getString("from_stn")).thenReturn("from_stn");
        when(mockResultSet.getString("to_stn")).thenReturn("to_stn");
        when(mockResultSet.getString("date")).thenReturn("date");
        when(mockResultSet.getString("mailid")).thenReturn("mailid");
        when(mockResultSet.getInt("seats")).thenReturn(2);
        when(mockResultSet.getDouble("amount")).thenReturn(100.0);
        when(mockResultSet.getString("tr_no")).thenReturn("tr_no");

        List<HistoryBean> bookings = bookingService.getAllBookingsByCustomerId(email);

        assertEquals(1, bookings.size());
        HistoryBean booking = bookings.get(0);
        assertEquals("transid", booking.getTransId());
        assertEquals("from_stn", booking.getFrom_stn());
        assertEquals("to_stn", booking.getTo_stn());
        assertEquals("date", booking.getDate());
        assertEquals("mailid", booking.getMailId());
        assertEquals(2, booking.getSeats());
        assertEquals(100.0, booking.getAmount(), 0.01);
        assertEquals("tr_no", booking.getTr_no());
    }

    @Test
    public void testCreateHistory() throws Exception {
        HistoryBean details = new HistoryBean();
        details.setMailId("mailid");
        details.setTr_no("tr_no");
        details.setDate("date");
        details.setFrom_stn("from_stn");
        details.setTo_stn("to_stn");
        details.setSeats(2);
        details.setAmount(100.0);

        String query = "INSERT INTO HISTORY VALUES(?,?,?,?,?,?,?,?)";
        String transactionId = UUID.randomUUID().toString();

        when(mockConnection.prepareStatement(query)).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        HistoryBean history = bookingService.createHistory(details);

        assertEquals(transactionId, history.getTransId());
        assertEquals(details.getMailId(), history.getMailId());
        assertEquals(details.getTr_no(), history.getTr_no());
        assertEquals(details.getDate(), history.getDate());
        assertEquals(details.getFrom_stn(), history.getFrom_stn());
        assertEquals(details.getTo_stn(), history.getTo_stn());
        assertEquals(details.getSeats(), history.getSeats());
        assertEquals(details.getAmount(), history.getAmount());
    }

    @Test(expected = TrainException.class)
    public void testCreateHistoryThrowsException() throws Exception {
        HistoryBean details = new HistoryBean();
        details.setMailId("mailid");
        details.setTr_no("tr_no");
        details.setDate("date");
        details.setFrom_stn("from_stn");
        details.setTo_stn("to_stn");
        details.setSeats(2);
        details.setAmount(100.0);

        String query = "INSERT INTO HISTORY VALUES(?,?,?,?,?,?,?,?)";

        when(mockConnection.prepareStatement(query)).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(0);

        bookingService.createHistory(details);
    }
}
