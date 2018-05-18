package org.ldlood.controller;

import org.ldlood.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ldlood on 2017/8/20.
 */
@RestController
@RequestMapping("/skill")
@CrossOrigin
@Slf4j
public class SecKillController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private SecKillService secKillService;



    /**
     * 查询秒杀活动特价商品的信息
     * @param EventId
     * @return
     */
    @GetMapping("/query/{EventId}")
    public String query(@PathVariable String EventId)throws Exception
    {
        return secKillService.querySecKillEventInfo(EventId);
    }


    /**
     * 秒杀，没有抢到获得"哎呦喂,xxxxx",抢到了会返回剩余的库存量
     * @param EventId
     * @return
     * @throws Exception
     */
    @GetMapping("/order/{EventId}")
    public String skill(@PathVariable String EventId)throws Exception
    {
        log.info("@skill request, EventId:" + EventId);
        secKillService.orderEventMockDiffUser(EventId);
        return secKillService.querySecKillEventInfo(EventId);
    }
}
