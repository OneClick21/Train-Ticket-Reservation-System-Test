package com.shashi.beans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HistoryBeanTest {

    private HistoryBean historyBean;

    @Before
    public void setUp() {
        historyBean = new HistoryBean();
    }

    @Test
    public void testSetAndGetTransId() {
        String transId = "TRANS123456";
        historyBean.setTransId(transId);
        assertEquals(transId, historyBean.getTransId());
    }

    @Test
    public void testSetAndGetMailId() {
        String mailId = "test@example.com";
        historyBean.setMailId(mailId);
        assertEquals(mailId, historyBean.getMailId());
    }

    @Test
    public void testSetAndGetTr_no() {
        String tr_no = "TR1234";
        historyBean.setTr_no(tr_no);
        assertEquals(tr_no, historyBean.getTr_no());
    }

    @Test
    public void testSetAndGetDate() {
        String date = "12-12-2024";
        historyBean.setDate(date);
        assertEquals(date, historyBean.getDate());
    }

    @Test
    public void testSetAndGetFrom_stn() {
        String from_stn = "StationA";
        historyBean.setFrom_stn(from_stn);
        assertEquals(from_stn, historyBean.getFrom_stn());
    }

    @Test
    public void testSetAndGetTo_stn() {
        String to_stn = "StationB";
        historyBean.setTo_stn(to_stn);
        assertEquals(to_stn, historyBean.getTo_stn());
    }

    @Test
    public void testSetAndGetSeats() {
        int seats = 3;
        historyBean.setSeats(seats);
        assertEquals(seats, historyBean.getSeats());
    }

    @Test
    public void testSetAndGetAmount() {
        Double amount = 150.75;
        historyBean.setAmount(amount);
        assertEquals(amount, historyBean.getAmount(), 0);
    }
}
