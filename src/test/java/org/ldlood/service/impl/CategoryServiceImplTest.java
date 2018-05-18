package org.ldlood.service.impl;

import org.ldlood.dataobject.EventCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;


    @Test
    public void findOne() throws Exception {
        EventCategory EventCategory = categoryService.findOne(1);
        Assert.assertNotNull(EventCategory);

    }

    @Test
    public void findAll() throws Exception {

        List<EventCategory> EventCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0, EventCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> lists = Arrays.asList(1, 2, 2);
        List<EventCategory> EventCategoryList = categoryService.findByCategoryTypeIn(lists);
        Assert.assertNotEquals(0, EventCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        EventCategory EventCategory = new EventCategory("summer-hot", 12);
        Assert.assertNotNull(categoryService.save(EventCategory));
    }

}