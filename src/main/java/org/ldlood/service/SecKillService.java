package org.ldlood.service;

/**
 * Created by Ldlood on 2017/8/20.
 */
public interface SecKillService {

    /**
     * 查询秒杀活动特价商品的信息
     *
     * @param EventId
     * @return
     */
    String querySecKillEventInfo(String EventId);

    /**
     * 模拟不同用户秒杀同一商品的请求
     *
     * @param EventId
     * @return
     */
    void orderEventMockDiffUser(String EventId);
}
