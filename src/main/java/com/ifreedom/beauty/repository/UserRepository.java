package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by eavawu on 4/28/16.
 */
@Component
public class UserRepository {
    @PersistenceContext
    EntityManager entityManager;
    public  UserEntity findUserByPhone(String phone){
        String sql = "select * from user where phone = :phone";
        Query nativeQuery = entityManager.createNativeQuery(sql, UserEntity.class);
        nativeQuery.setParameter("phone",phone);
        UserEntity userEntity = (UserEntity) nativeQuery.getSingleResult();
        return userEntity;
    };

    public UserEntity findByPhoneAndPassword(String phone, String password){
        String sql = "select * from user where phone = :phone and password = :password";
        Query nativeQuery = entityManager.createNativeQuery(sql, UserEntity.class);
        nativeQuery.setParameter("phone",phone);
        nativeQuery.setParameter("password",password);
        List<UserEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()){
            return null;
        }else{
            return resultList.get(0);
        }
//        return singleResult;
    };

    public UserEntity getUser(Long userId) {
        return entityManager.find(UserEntity.class,userId);
    }

    public UserEntity save(UserEntity userEntity){
        if (userEntity==null){
            return null;
        }
        entityManager.getTransaction().begin();;
        entityManager.persist(userEntity);
        entityManager.getTransaction().commit();
        return findUserByPhone(userEntity.getPhone());
    }



}
