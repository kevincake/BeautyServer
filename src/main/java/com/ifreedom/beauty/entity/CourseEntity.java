package com.ifreedom.beauty.entity;

import com.ifreedom.beauty.constants.DataBaseConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/3/16
 * @todo:课程的entity
 */
@Entity
@Table(name = "course")
public class CourseEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courseName;
    private Long userId;
    private int type;
    private String pic[];
    private Integer popular;
    private Long deployTime;
    private Long courseTime;
    private String courseDes;
    private Long joinMan;

    public Long getCourseTime() {

        return courseTime;
    }

    public void setCourseTime(Long courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(String courseDes) {
        this.courseDes = courseDes;
    }

    public Long getJoinMan() {
        return joinMan;
    }

    public void setJoinMan(Long joinMan) {
        this.joinMan = joinMan;
    }

    public Long getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Long deployTime) {
        this.deployTime = deployTime;
    }


    public Integer getPopular() {
        return popular;
    }

    public void setPopular(Integer popular) {
        this.popular = popular;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getPic() {
        return pic;
    }

    public void setPic(String[] pic) {
        this.pic = pic;
    }




    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
