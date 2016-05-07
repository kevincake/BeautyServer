package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.CourseItemEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
@Component
public class CourseItemRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public CourseItemEntity save(CourseItemEntity itemEntity) {
        if (itemEntity == null) {
            return null;
        }
        entityManager.persist(itemEntity);
        return entityManager.find(CourseItemEntity.class, itemEntity.getId());
    }
}
