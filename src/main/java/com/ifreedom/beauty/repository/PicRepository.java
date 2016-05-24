package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.PicEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @atuhor:eavawu
 * @date:5/25/16
 * @todo:
 */
@Component
public class PicRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public PicEntity deletePic(PicEntity entity) {
        PicEntity picEntity = entityManager.find(PicEntity.class, entity.getId());
        if (picEntity != null) {
            entityManager.remove(picEntity);
        }
        return picEntity;
    }

    @Transactional
    public PicEntity addPic(PicEntity entity) {
        return entityManager.merge(entity);
    }

}
