package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.CourseItemEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
public interface ICourseItemService {
    CourseItemEntity save(CourseItemEntity courseItemEntity);
    List<CourseItemEntity> getItemList(long courseId);
}
