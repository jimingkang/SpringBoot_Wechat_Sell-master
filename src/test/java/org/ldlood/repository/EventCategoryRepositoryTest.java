package org.ldlood.repository;

import org.ldlood.dataobject.EventCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventCategoryRepositoryTest {

    @Autowired
    private EventCategoryRepository EventCategoryRepository;

    @Test
    public void findOneTest() {
        EventCategory EventCategory = EventCategoryRepository.findOne(1);
        System.out.println(EventCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest() {
        EventCategory EventCategory = new EventCategory("summer", 10);
        Assert.assertNotNull(EventCategoryRepository.save(EventCategory));
    }

    @Test
    public void updateTest() {
        EventCategory EventCategory = new EventCategory();
        EventCategory.setCategoryId(2);
        EventCategory.setCategoryName("summer like");
        EventCategory.setCategoryType(3);
        EventCategoryRepository.save(EventCategory);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);

        List<EventCategory> EventCategoryList = EventCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, EventCategoryList.size());
    }
}