package com.ifreedom.beauty.test;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ifreedom.beauty.BeautyApplication;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.CourseEntity;
import com.ifreedom.beauty.entity.CourseItemEntity;
import com.ifreedom.beauty.service.CourseItemService;
import com.ifreedom.beauty.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @atuhor:eavawu
 * @date:5/4/16
 * @todo:
 */
@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes = BeautyApplication.class)


public class CourseTest {
    private RestTemplate template = new TestRestTemplate();
    @Autowired
    CourseService courseService;
    @Autowired
    CourseItemService courseItemService;
    @Test
    public void testGetCourse(){
        String url = TestConstants.BASE_URL+HttpConstants.COURSE_CONTROL_PATH;
        HttpResult forObject = template.getForObject(url, HttpResult.class, new Object());
        System.out.println(forObject);
//        template.
    }

    @Test
    public void addCourse(){
        for (int i=0;i<10;i++){
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setCourseName("course"+i);
            courseEntity.setUserId(10L);
            courseEntity.setType(1);
            courseEntity.setPic(new String[]{"http://beautybucket.oss-cn-shenzhen.aliyuncs.com/0a97a05bcbe921ffc412e7f061e16d00.jpg"});
            courseEntity.setPopular(DataBaseConstants.POPULAR);
            CourseEntity courseEntityResult = courseService.addCourse(courseEntity);
            CourseItemEntity courseItemEntity = new CourseItemEntity();
            courseItemEntity.setChapterIndex(1);
            courseItemEntity.setCourseId(courseEntityResult.getId());
            courseItemEntity.setChapterName("第一节");
            courseItemService.save(courseItemEntity);
        }

    }
}
