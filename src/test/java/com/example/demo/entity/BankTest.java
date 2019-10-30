package com.example.demo.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.Assert.*;

public class BankTest
{

    private Bank bankTest = new Bank();
    private String name;
    private String bik;

    @Before
    public void setUp() throws Exception
    {
        bankTest.setName(name);
        bankTest.setBik(bik);
    }
    @After
    public void tearDown() throws Exception {}

    @Test
    public void getId()
    {
        UUID id = bankTest.getId();
    }
    @Test
    public void getName()
    {
        String nameTest = bankTest.getName();
        assertEquals(name, nameTest);
    }
    @Test
    public void getBik()
    {
        String bikTest = bankTest.getBik();
        assertEquals(bik, bikTest);
    }
}