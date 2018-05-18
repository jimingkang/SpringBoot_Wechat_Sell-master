package org.ldlood.repository;

import org.ldlood.dataobject.EventInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventInfoRepositoryTest {
    @Autowired
    private EventInfoRepository EventInfoRepository;


    @Test
    public void saveTest() {
        EventInfo EventInfo = new EventInfo();

        EventInfo.setEventId("123123456456");
        EventInfo.setEventName("milk");
        EventInfo.setEventPrice(new BigDecimal(5.5));
        EventInfo.setEventStock(100);
        EventInfo.setEventDescription("good milk");
        EventInfo.setEventIcon("http://aa.jpg");
        EventInfo.setEventStatus(0);
        EventInfo.setCategoryType(2);

        EventInfo result = EventInfoRepository.save(EventInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByEventStatus() throws Exception {

        List<EventInfo> EventInfoList = EventInfoRepository.findByEventStatus(0);
        Assert.assertNotEquals(0, EventInfoList.size());
    }

}