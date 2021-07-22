package com.elk.Dao;

import com.elk.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {App.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class IndexTest {

    @Autowired
    Index index;

    @Test
    public void testCreate() throws Exception {
        System.out.println(index.create("tian1"));
    }

    @Test
    public void testExist() throws Exception {
        System.out.println(index.exist("tian1"));
    }
} 
