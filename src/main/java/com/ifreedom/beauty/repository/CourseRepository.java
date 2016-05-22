package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.bean.PopularCourseBean;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.CourseEntity;
import com.ifreedom.beauty.entity.CourseLikeEntity;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.FollowService;
import com.ifreedom.beauty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/4/16
 * @todo:
 */
@Component
public class CourseRepository

{

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    FollowService followService;
    @Autowired
    UserService userService;

    public List<PopularCourseBean> getPopularCourseList(long userId, int isPopular, int pageIndex) {
        String sql = "select * from course where popular = :popular limit :pageIndex,:pageSize";
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, CourseEntity.class);
        nativeQuery.setParameter("popular", isPopular);
        nativeQuery.setParameter(DataBaseConstants.PAGESIZE_KEY, DataBaseConstants.PAGE_SIZE);
        nativeQuery.setParameter(DataBaseConstants.PAGEINDEX_KEY, (pageIndex-1)*DataBaseConstants.PAGE_SIZE);
        List<CourseEntity> courseEntities = nativeQuery.getResultList();
        List<PopularCourseBean> popularCourseList = new ArrayList<>();
        for (CourseEntity courseEntity :
                courseEntities) {
            PopularCourseBean popularCourseBean = new PopularCourseBean();
            popularCourseBean.setCourse(courseEntity);
            popularCourseBean.setIsFollow(followService.isFollow(userId,courseEntity.getUserId()));
            //user
            UserEntity user = userService.getUser(courseEntity.getUserId());
            popularCourseBean.setUser(user);
            popularCourseList.add(popularCourseBean);
        }
        return popularCourseList;
    }

    @Transactional
    public CourseEntity save(CourseEntity courseEntity) {
        if (courseEntity == null) {
            return null;
        }
        entityManager.persist(courseEntity);
        CourseEntity courseEntityResult = entityManager.find(CourseEntity.class, courseEntity.getId());
        return courseEntityResult;
    }

    public List<PopularCourseBean> getLikeCourse(Long userId, int pageIndex) {

        String sql = "select *  from course where  id in (select courseId from courseLike where userId = :userId) limit :pageIndex,:pageSize";

//        String sql = "select * from course where popular = :popular limit :pageIndex,:pageSize";
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, CourseEntity.class);
        nativeQuery.setParameter(DataBaseConstants.USER_ID,userId);
        nativeQuery.setParameter(DataBaseConstants.PAGESIZE_KEY, DataBaseConstants.PAGE_SIZE);
        nativeQuery.setParameter(DataBaseConstants.PAGEINDEX_KEY, (pageIndex-1)*DataBaseConstants.PAGE_SIZE);
        List<CourseEntity> courseEntities = nativeQuery.getResultList();
        List<PopularCourseBean> popularCourseList = new ArrayList<>();
        for (CourseEntity courseEntity :
                courseEntities) {
            PopularCourseBean popularCourseBean = new PopularCourseBean();
            popularCourseBean.setCourse(courseEntity);
            popularCourseBean.setIsFollow(followService.isFollow(userId,courseEntity.getUserId()));
            //user
            UserEntity user = userService.getUser(courseEntity.getUserId());
            popularCourseBean.setUser(user);
            popularCourseList.add(popularCourseBean);
        }
        return popularCourseList;
    }


    @Transactional
    public void addCourseLike(CourseLikeEntity courseLikeEntity) {
        entityManager.merge(courseLikeEntity);
    }

    ;


}
