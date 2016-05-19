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

}
