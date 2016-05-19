package com.ifreedom.beauty.service;

import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.CourseItemEntity;
import com.ifreedom.beauty.iservice.ICourseItemService;
import com.ifreedom.beauty.repository.CourseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
@Service
public class CourseItemService implements ICourseItemService {
    @Autowired
    CourseItemRepository courseItemRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CourseItemEntity save(CourseItemEntity courseItemEntity) {
        return courseItemRepository.saveOrUpdate(courseItemEntity);
    }

    @Override
    public List<CourseItemEntity> getItemList(long courseId) {
        String sql = "select * from courseItem where courseId = :courseId";
        Query nativeQuery = entityManager.createNativeQuery(sql, CourseItemEntity.class);
        nativeQuery.setParameter(DataBaseConstants.COURSE_ID, courseId);
        return nativeQuery.getResultList();
    }


}
