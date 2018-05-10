package org.ldlood.service.impl;

import org.ldlood.dto.OrderDTO;
import org.ldlood.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Ldlood on 2017/8/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1502688815255325628");
        for (int i = 0; i < 1000; i++) {
            pushMessageService.orderStatus(orderDTO);
        }

    }

}