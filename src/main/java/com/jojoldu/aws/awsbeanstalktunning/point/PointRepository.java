package com.jojoldu.aws.awsbeanstalktunning.point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jojoldu@gmail.com on 09/07/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface PointRepository extends JpaRepository<Point, Long> {

    @Query("SELECT sum(p.amount) " +
            "FROM Point p " +
            "WHERE p.userId =:userId")
    Long getAvailablePoint(@Param("userId") Long userId);
}
