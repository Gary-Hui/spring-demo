package com.iti.demo;

import org.hamcrest.core.StringStartsWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoControllerTest {

    @Test
    public void index() throws Exception {
        assertThat("demo test", is(StringStartsWith.startsWith("demo")));
    }
}