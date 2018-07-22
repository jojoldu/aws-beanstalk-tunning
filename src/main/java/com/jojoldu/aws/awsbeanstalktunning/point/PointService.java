package com.jojoldu.aws.awsbeanstalktunning.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jojoldu@gmail.com on 09/07/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@RequiredArgsConstructor
@Service
public class PointService {

    private final PointRepository pointRepository;

    public Long getAvailablePoint(Long userId){
        return pointRepository.getAvailablePoint(userId);
    }

    @Transactional
    public void savePoint(PointDto pointDto){
        pointRepository.save(pointDto.toEntity());
    }
}
