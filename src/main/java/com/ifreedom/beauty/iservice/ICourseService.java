package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.bean.PopularCourseBean;
import com.ifreedom.beauty.entity.CourseEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/4/16
 * @todo:
 */
public interface ICourseService {
    List<CourseEntity> getCourseList(Long userId);
    public List<PopularCourseBean> getPopularCourseList(long userid, int popular, int pageIndex);

    CourseEntity addCourse(CourseEntity courseEntity);

    List<PopularCourseBean> getLikeCourse(Long id,  int pageIndex);
}
