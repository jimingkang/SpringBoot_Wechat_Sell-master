package org.ldlood.service.impl;

import org.ldlood.enums.EventStatusEnum;
import org.ldlood.dataobject.EventInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceImplTest {

    @Autowired
    private EventServiceImpl EventService;


    @Test
    public void findOne() throws Exception {
        EventInfo EventInfo = EventService.findOne("123123456456");
        Assert.assertEquals("123123456456", EventInfo.getEventId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<EventInfo> EventInfoList = EventService.findUpAll();
        Assert.assertNotEquals(0, EventInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<EventInfo> EventInfoPage = EventService.findAll(request);
        System.out.println(EventInfoPage.getTotalElements());
        Assert.assertNotEquals(0, EventInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        EventInfo EventInfo = new EventInfo();
        EventInfo.setEventId("1234573");
        EventInfo.setEventName("food");
        EventInfo.setEventPrice(new BigDecimal(3.2));
        EventInfo.setEventStock(100);
        EventInfo.setEventDescription("good food");
        EventInfo.setEventIcon("http://xxxxx.jpg");
        EventInfo.setEventStatus(EventStatusEnum.DOWN.getCode());
        EventInfo.setCategoryType(2);

        EventInfo result = EventService.save(EventInfo);
        Assert.assertNotNull(result);
    }


}