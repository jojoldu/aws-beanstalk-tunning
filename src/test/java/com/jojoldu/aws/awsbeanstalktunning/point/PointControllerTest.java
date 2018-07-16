package com.jojoldu.aws.awsbeanstalktunning.point;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jojoldu@gmail.com on 16/07/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PointControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loadClassLock테스트() {
        //given
        restTemplate.getForEntity("/availablePoint/1", String.class);

        //when

        //then

    }
}
