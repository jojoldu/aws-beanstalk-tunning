package com.jojoldu.aws.awsbeanstalktunning.point;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/point")
    public boolean savePoint(@RequestBody PointDto pointDto){
        pointService.savePoint(pointDto);
        return true;
    }
}
