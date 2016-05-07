package com.ifreedom.beauty.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @atuhor:eavawu
 * @date:5/3/16
 * @todo:
 */
@Entity
@Table(name = "courseItem")
public class CourseItemEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int chapterIndex;
    private String url;
    private String chapterName;

    public int getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    private Long courseId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
