package org.ldlood.service;

import org.ldlood.dataobject.EventInfo;
import org.ldlood.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
public interface EventService {

    EventInfo findOne(String EventId);

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<EventInfo> findUpAll();

    Page<EventInfo> findAll(Pageable pageable);

    EventInfo save(EventInfo EventInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    EventInfo onSale(String EventId);

    //下架
    EventInfo offSale(String EventId);

}
