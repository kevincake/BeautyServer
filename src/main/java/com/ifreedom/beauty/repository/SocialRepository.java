package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.bean.SocialDetailBean;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.CommentEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.entity.SocialEntity;
import com.ifreedom.beauty.service.CommentService;
import com.ifreedom.beauty.service.FollowService;
import com.ifreedom.beauty.service.LikeService;
import com.ifreedom.beauty.service.UserService;
import com.ifreedom.beauty.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
@Component
public class SocialRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    FollowService followService;
    @Autowired
    LikeService likeService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    public List<SocialDetailBean> getSocialDetails(Long userid) {

        List<Long> followIds = followService.getFollowIds(userid);
        if (followIds==null||followIds.isEmpty()){
            return null;
        }
        String inParamByIds = StringUtils.getInParamByIds(followIds);
//        String sql = "select * from social where userId in (:ids)";
        String sql = "select * from social";
        Query nativeQuery = entityManager.createNativeQuery(sql, SocialEntity.class);
//        nativeQuery.setParameter("ids",inParamByIds);
        List<SocialEntity> resultList = nativeQuery.getResultList();
        List<SocialDetailBean> socialDetailBeans = new ArrayList<>();
        for (SocialEntity socialEntity:
             resultList) {
            SocialDetailBean socialDetailBean = new SocialDetailBean();
            socialDetailBean.setSocialEntity(socialEntity);
            List<LikeEntity> likes = likeService.getLikes(socialEntity.getId());
            socialDetailBean.setLikeEntities(likes);
            List<CommentEntity> comments = commentService.getComments(socialEntity.getId());
            socialDetailBean.setCommentsEntities(comments);
            socialDetailBean.setUser(userService.getUser(socialEntity.getUserId()));
            socialDetailBeans.add(socialDetailBean);




        }
        return socialDetailBeans;
    }

    public LikeEntity likeSocial(Long userId, Long socialId) {
        return null;
    }

    public SocialDetailBean getSocialDetail(Long socialId) {
        return null;
    }

    public SocialEntity getSocial(Long socialId) {
        return null;
    }

    public SocialEntity updateSocialDetail(SocialEntity socialEntity) {
        return null;
    }

    public SocialDetailBean deleteSocialDetail(Long detailId) {
        return null;
    }

    @Transactional
    public SocialEntity addSocial(SocialEntity socialEntity) {
        return entityManager.merge(socialEntity);
    }

    public List<SocialDetailBean> getMineSocial(Long userId) {


        String sql = "select * from social where userId = :userId";
        Query nativeQuery = entityManager.createNativeQuery(sql, SocialEntity.class);
        nativeQuery.setParameter(DataBaseConstants.USER_ID,userId);
        List<SocialEntity> resultList = nativeQuery.getResultList();
        List<SocialDetailBean> socialDetailBeans = new ArrayList<>();
        for (SocialEntity socialEntity:
                resultList) {
            SocialDetailBean socialDetailBean = new SocialDetailBean();
            socialDetailBean.setSocialEntity(socialEntity);
            List<LikeEntity> likes = likeService.getLikes(socialEntity.getId());
            socialDetailBean.setLikeEntities(likes);
            List<CommentEntity> comments = commentService.getComments(socialEntity.getId());
            socialDetailBean.setCommentsEntities(comments);
            socialDetailBean.setUser(userService.getUser(socialEntity.getUserId()));
            socialDetailBeans.add(socialDetailBean);

        }
        return socialDetailBeans;
    }
}
