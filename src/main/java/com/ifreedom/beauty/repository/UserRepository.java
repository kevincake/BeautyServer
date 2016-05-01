package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eavawu on 4/28/16.
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer>{
    UserEntity findUserByPhone(String phone);

    UserEntity findByPhoneAndPassword(String phone, String password);
}
