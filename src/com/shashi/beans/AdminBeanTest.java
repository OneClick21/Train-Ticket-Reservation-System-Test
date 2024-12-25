package com.shashi.beans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdminBeanTest {

    private AdminBean adminBean;

    @Before
    public void setUp() {
        adminBean = new AdminBean();
    }

    @Test
    public void testSetAndGetFName() {
        String fName = "John";
        adminBean.setFName(fName);
        assertEquals(fName, adminBean.getFName());
    }

    @Test
    public void testSetAndGetLName() {
        String lName = "Doe";
        adminBean.setLName(lName);
        assertEquals(lName, adminBean.getLName());
    }

    @Test
    public void testSetAndGetPWord() {
        String pWord = "password123";
        adminBean.setPWord(pWord);
        assertEquals(pWord, adminBean.getPWord());
    }

    @Test
    public void testSetAndGetAddr() {
        String addr = "123 Main St";
        adminBean.setAddr(addr);
        assertEquals(addr, adminBean.getAddr());
    }

    @Test
    public void testSetAndGetMailId() {
        String mailId = "john.doe@example.com";
        adminBean.setMailId(mailId);
        assertEquals(mailId, adminBean.getMailId());
    }

    @Test
    public void testSetAndGetPhNo() {
        long phNo = 1234567890L;
        adminBean.setPhNo(phNo);
        assertEquals(phNo, adminBean.getPhNo());
    }
}
