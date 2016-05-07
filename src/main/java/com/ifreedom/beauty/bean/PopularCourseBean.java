package com.ifreedom.beauty.bean;

import com.ifreedom.beauty.entity.CourseEntity;
import com.ifreedom.beauty.entity.UserEntity;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
public class PopularCourseBean {
    private CourseEntity course;
    private int isFollow;
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public int getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(int isFollow) {
        this.isFollow = isFollow;
    }
}
