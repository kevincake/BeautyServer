package com.ifreedom.beauty.entity;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:5/18/16
 * @todo:
 */
@Entity
@Table(name = "courseLike")
public class CourseLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long courseId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
