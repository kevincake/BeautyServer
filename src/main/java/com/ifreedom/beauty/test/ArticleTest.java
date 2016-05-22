package com.ifreedom.beauty.test;

import com.ifreedom.beauty.BeautyApplication;
import com.ifreedom.beauty.entity.ArticleEntity;
import com.ifreedom.beauty.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @atuhor:eavawu
 * @date:5/19/16
 * @todo:
 */
@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes = BeautyApplication.class)
public class ArticleTest {
    @Autowired
    ArticleService articleService;

    @Test
    public void addTestData() {
        for (int i = 0; i < 10; i++) {
            ArticleEntity entity = new ArticleEntity();
            entity.setCommentCount(10L + i);
            entity.setContent("上辈子我好像在哪见过");
            entity.setDeployTime(System.currentTimeMillis());
            entity.setIsPopular(1);
            entity.setReadCount(10L);
            entity.setReplyCount(10L + i);
            entity.setUserId(1L);
            entity.setTitle("这是Title");
            articleService.addArticle(entity);

        }
    }
}
