package com.jojoldu.aws.awsbeanstalktunning.point;

/**
 * Created by jojoldu@gmail.com on 09/07/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
    indexes = {
        @Index(name = "IDX_POINT_USER_ID", columnList = "userId")
    }
)
@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;
    private Long userId;

    @Builder
    public Point(Long amount, Long userId) {
        this.amount = amount;
        this.userId = userId;
    }
}
