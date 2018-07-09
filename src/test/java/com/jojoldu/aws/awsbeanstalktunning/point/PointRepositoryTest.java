package com.jojoldu.aws.awsbeanstalktunning.point;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jojoldu@gmail.com on 09/07/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class PointRepositoryTest {

    @Autowired
    private PointRepository pointRepository;

    @Test
    public void 사용자의_가용포인트_조회된다() {
        //given
        Long userId = 1L;
        pointRepository.save(new Point(1000L, userId));
        pointRepository.save(new Point(200L, userId));

        //when
        Long availablePoint = pointRepository.getAvailablePoint(userId);

        //then
        Assert.assertThat(availablePoint, Is.is(1200L));
    }
}
