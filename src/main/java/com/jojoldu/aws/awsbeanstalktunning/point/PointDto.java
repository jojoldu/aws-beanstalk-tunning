package com.jojoldu.aws.awsbeanstalktunning.point;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jojoldu@gmail.com on 13/07/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Getter
@Setter
@NoArgsConstructor
public class PointDto {

    private long amount;
    private long userId;

    public Point toEntity() {
        return Point.builder()
                .amount(amount)
                .userId(userId)
                .build();
    }
}
