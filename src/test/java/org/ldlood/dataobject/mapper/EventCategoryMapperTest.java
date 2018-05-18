package org.ldlood.dataobject.mapper;

import org.ldlood.dataobject.EventCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Ldlood on 2017/8/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EventCategoryMapperTest {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private EventCategoryMapper mapper;



    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "关心加班的你");
        map.put("category_type", 101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        EventCategory EventCategory = new EventCategory();
        EventCategory.setCategoryName("秋意浓");
        EventCategory.setCategoryType(102);
        int result = mapper.insertByObject(EventCategory);
        Assert.assertEquals(1, result);
    }


    @Test
    public void findByCategoryType() {
        EventCategory result = mapper.findByCategoryType(102);
        log.info(result.getCategoryName());
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() {
        List<EventCategory> result = mapper.findByCategoryName("秋意浓");
        for(EventCategory EventCategory:result){
            log.info(EventCategory.getCategoryName()+"/"+EventCategory.getCategoryId());
        }
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("凛冬已至", 102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        EventCategory EventCategory = new EventCategory();
        EventCategory.setCategoryName("秋意浓");
        EventCategory.setCategoryType(102);
        int result = mapper.updateByObject(EventCategory);
        Assert.assertEquals(1, result);
    }


    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(103);
        Assert.assertEquals(1, result);
    }


    @Test
    public void selectByCategoryType() {
        EventCategory EventCategory = mapper.selectByCategoryType(101);
        log.info(EventCategory.getCategoryName());
        Assert.assertNotNull(EventCategory);
    }
}