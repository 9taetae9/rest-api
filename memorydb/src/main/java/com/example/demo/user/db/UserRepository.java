package com.example.demo.user.db;

import com.example.demo.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //select * from user where score >= [??]
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    //select * from user where score >= ?? AND score <= ??
    //쿼리 메소드 사용 권장
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    @Query( //jpql 방식으로 작성
            //"select u from user u where u.score >= ?1 AND u.score <= ?2",
            //native쿼리로 작성한 방식
            value = "select * from user as u where u.score >= :min AND u.score <= :max",
            nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "min") int min, //@param 으로 :min
            @Param(value = "max") int max  //@param 으로 :max 로 각각 매칭 (named parameter)
    );
}
