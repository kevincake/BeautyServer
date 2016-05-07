package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.FollowEntity;
import com.ifreedom.beauty.iservice.IFollowService;
import com.ifreedom.beauty.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
@Service
public class FollowService implements IFollowService {

    @Autowired
    FollowRepository followRepository;
    @Override
    public int isFollow(long userId, long beFollowId) {
        return followRepository.isFollow(userId,beFollowId);
    }

    public boolean addFollow(long userId,long beFollowId){
        FollowEntity followEntity = new FollowEntity();
        followEntity.setFollowerId(userId);
        followEntity.setBeFollowerId(beFollowId);
        return followRepository.save(followEntity);
    }

    @Override
    public boolean deleteFollow(long userId, long beFollowId) {
        FollowEntity follow = followRepository.getFollow(userId, beFollowId);
        if (follow==null){
            return false;
        }else{
            followRepository.delete(follow.getId());
        }
        return true;

    }
}
