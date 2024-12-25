package com.shashi.beans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrainBeanTest {

    private TrainBean trainBean;

    @Before
    public void setUp() {
        trainBean = new TrainBean();
    }

    @Test
    public void testSetAndGetTr_no() {
        Long tr_no = 12345L;
        trainBean.setTr_no(tr_no);
        assertEquals(tr_no, trainBean.getTr_no());
    }

    @Test
    public void testSetAndGetTr_name() {
        String tr_name = "Express Train";
        trainBean.setTr_name(tr_name);
        assertEquals(tr_name, trainBean.getTr_name());
    }

    @Test
    public void testSetAndGetFrom_stn() {
        String from_stn = "Station A";
        trainBean.setFrom_stn(from_stn);
        assertEquals(from_stn, trainBean.getFrom_stn());
    }

    @Test
    public void testSetAndGetTo_stn() {
        String to_stn = "Station B";
        trainBean.setTo_stn(to_stn);
        assertEquals(to_stn, trainBean.getTo_stn());
    }

    @Test
    public void testSetAndGetSeats() {
        Integer seats = 100;
        trainBean.setSeats(seats);
        assertEquals(seats, trainBean.getSeats());
    }

    @Test
    public void testSetAndGetFare() {
        Double fare = 75.50;
        trainBean.setFare(fare);
        assertEquals(fare, trainBean.getFare(), 0.0);
    }
}
