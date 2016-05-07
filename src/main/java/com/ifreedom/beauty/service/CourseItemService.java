package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.CourseItemEntity;
import com.ifreedom.beauty.iservice.ICourseItemService;
import com.ifreedom.beauty.repository.CourseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
@Service
public class CourseItemService implements ICourseItemService{
    @Autowired
    CourseItemRepository courseItemRepository;
    @Override
    public CourseItemEntity save(CourseItemEntity courseItemEntity) {
        return courseItemRepository.save(courseItemEntity);
    }
}
