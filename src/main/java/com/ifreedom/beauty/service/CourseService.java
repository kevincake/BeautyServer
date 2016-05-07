package com.ifreedom.beauty.service;

import com.ifreedom.beauty.bean.PopularCourseBean;
import com.ifreedom.beauty.entity.CourseEntity;
import com.ifreedom.beauty.iservice.ICourseService;
import com.ifreedom.beauty.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/4/16
 * @todo:
 */
@Service
public class CourseService implements   ICourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<PopularCourseBean> getPopularCourseList(long userid, int popular, int pageIndex) {
        return courseRepository.getPopularCourseList(userid,popular,pageIndex);
    }

    @Override
    public CourseEntity addCourse(CourseEntity courseEntity) {
        CourseEntity save = courseRepository.save(courseEntity);
        return save;
    }

    @Override
    public List<CourseEntity> getCourseList(Long userId) {
        return null;
    }


}
