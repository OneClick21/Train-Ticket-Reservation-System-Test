package com.shashi.beans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserBeanTest {

    private UserBean userBean;

    @Before
    public void setUp() {
        userBean = new UserBean();
    }

    @Test
    public void testSetAndGetFName() {
        String fName = "John";
        userBean.setFName(fName);
        assertEquals(fName, userBean.getFName());
    }

    @Test
    public void testSetAndGetLName() {
        String lName = "Doe";
        userBean.setLName(lName);
        assertEquals(lName, userBean.getLName());
    }

    @Test
    public void testSetAndGetPWord() {
        String pWord = "password123";
        userBean.setPWord(pWord);
        assertEquals(pWord, userBean.getPWord());
    }

    @Test
    public void testSetAndGetAddr() {
        String addR = "123 Main St";
        userBean.setAddr(addR);
        assertEquals(addR, userBean.getAddr());
    }

    @Test
    public void testSetAndGetMailId() {
        String mailId = "john.doe@example.com";
        userBean.setMailId(mailId);
        assertEquals(mailId, userBean.getMailId());
    }

    @Test
    public void testSetAndGetPhNo() {
        long phNo = 1234567890L;
        userBean.setPhNo(phNo);
        assertEquals(phNo, userBean.getPhNo());
    }
}
