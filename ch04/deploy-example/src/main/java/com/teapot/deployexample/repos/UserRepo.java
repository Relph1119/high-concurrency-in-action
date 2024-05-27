package com.teapot.deployexample.repos;

import com.teapot.deployexample.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: HuRuiFeng
 * @File: UserRepo.java
 * @Time: 2024/5/27 20:08
 * @Project: high-concurrency-in-action
 * @Desc:
 **/
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserById(Long id);

    User findUserByEmail(String email);

    User findUserByPhoneNumber(String phoneNumber);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.email = :email, u.confirmedAndActive = true where u.id = :id")
    @Transactional
    int updateEmailAndActivateById(@Param("email") String email, @Param("id") Long id);
}
