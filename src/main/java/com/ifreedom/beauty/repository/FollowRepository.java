package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.constants.DataBaseConstants;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

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
}
