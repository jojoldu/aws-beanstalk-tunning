package com.jojoldu.aws.awsbeanstalktunning.point;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jojoldu@gmail.com on 09/07/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class PointController {

    private final PointService pointService;

    @GetMapping("/availablePoint/{userId}")
    public Long getAvailablePoint(@PathVariable Long userId){
        return pointService.getAvailablePoint(userId);
    }
}
