package com.yaqiwe.community.Repostitory;

import com.yaqiwe.community.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/15 19:56
 * @description：用户表的数据库操作
 */
@Repository
public interface userRepository  extends JpaRepository<user,Integer> {
    Optional<user> findById(Integer id);

    /*根据github的Id查找用户*/
    user findByAccountId(Integer id);

    /*根据token获取用户信息*/
    user findByToken(String token);
}
