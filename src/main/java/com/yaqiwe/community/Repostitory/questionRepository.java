package com.yaqiwe.community.Repostitory;

import com.yaqiwe.community.entity.question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 9:32
 * @description：发布问题表的Jpa持久层
 */
public interface questionRepository extends JpaRepository<question,Integer> {

    Optional<question> findById(Integer id);
}
