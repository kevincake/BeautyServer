package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.FollowEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
@Component
public class FollowRepository {
    @PersistenceContext
    EntityManager entityManager;
    public int isFollow(long  followerId, long beFollowId) {
        String sql = "select count(*) from follow where followerId = :followerId and beFollowerId = :beFollowerId";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.setParameter("followerId", followerId);
        nativeQuery.setParameter("beFollowerId", beFollowId);
        BigInteger count = (BigInteger) nativeQuery.getSingleResult();
        if (count.longValue() > 0) {
            return DataBaseConstants.FOLLOWED;
        }
        return DataBaseConstants.UNFOLLOWED;
    }
    @Transactional
    public boolean save(FollowEntity followEntity) {
        FollowEntity follow = getFollow(followEntity.getFollowerId(), followEntity.getBeFollowerId());
        if (follow!=null){
            follow.setBeFollowerId(followEntity.getBeFollowerId());
            follow.setFollowerId(followEntity.getFollowerId());
        }
        entityManager.merge(followEntity);
        entityManager.flush();
        return true;
    }


    public FollowEntity getFollow(long userId,long beFollowId){
        String sql = "select * from follow where followerId = :followerId and beFollowerId = :beFollowerId";
        Query nativeQuery = entityManager.createNativeQuery(sql,FollowEntity.class);
        nativeQuery.setParameter("followerId", userId);
        nativeQuery.setParameter("beFollowerId", beFollowId);
        List<FollowEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()){
            return null;
        }
        return resultList.get(0);
    }
    @Transactional
    public void delete(Long id) {

        FollowEntity followEntity = entityManager.find(FollowEntity.class, id);
        if (followEntity!=null){
            entityManager.remove(followEntity);
        }

    }


//    public boolean delete(long userId, long beFollowId) {
//
//        return false;
//    }
}
