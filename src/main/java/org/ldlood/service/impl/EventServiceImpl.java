package org.ldlood.service.impl;

import org.ldlood.dto.CartDTO;
import org.ldlood.enums.EventStatusEnum;
import org.ldlood.dataobject.EventInfo;
import org.ldlood.enums.ResultEnum;
import org.ldlood.exception.SellException;
import org.ldlood.repository.EventInfoRepository;
import org.ldlood.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventInfoRepository EventInfoRepository;


    @Override
    public EventInfo findOne(String EventId) {
        return EventInfoRepository.findOne(EventId);
    }

    @Override
    public List<EventInfo> findUpAll() {

        return EventInfoRepository.findByEventStatus(EventStatusEnum.UP.getCode());
    }

    @Override
    public Page<EventInfo> findAll(Pageable pageable) {
        return EventInfoRepository.findAll(pageable);
    }

    @Override
    public EventInfo save(EventInfo EventInfo) {
        return EventInfoRepository.save(EventInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            EventInfo EventInfo = EventInfoRepository.findOne(cartDTO.getEventId());
            if (EventInfo == null) {
                throw new SellException(ResultEnum.Event_NOT_EXI);
            }
            Integer resultNum = EventInfo.getEventStock() + cartDTO.getEventQuantity();
            EventInfo.setEventStock(resultNum);
            EventInfoRepository.save(EventInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            EventInfo EventInfo = EventInfoRepository.findOne(cartDTO.getEventId());
            if (EventInfo == null) {
                throw new SellException(ResultEnum.Event_NOT_EXI);
            }
            Integer num = EventInfo.getEventStock() - cartDTO.getEventQuantity();
            if (num < 0) {
                throw new SellException(ResultEnum.PRODUC_STOCK_ERROR);
            }

            EventInfo.setEventStock(num);
            EventInfoRepository.save(EventInfo);
        }
    }

    @Override
    public EventInfo onSale(String EventId) {
        EventInfo EventInfo = EventInfoRepository.findOne(EventId);
        if (EventInfo == null) {
            throw new SellException(ResultEnum.Event_NOT_EXI);
        }
        if (EventInfo.getEventStatusEnum() == EventStatusEnum.UP) {
            throw new SellException(ResultEnum.Event_STATUS_ERROR);
        }

        //更新
        EventInfo.setEventStatus(EventStatusEnum.UP.getCode());
        return EventInfoRepository.save(EventInfo);
    }

    @Override
    public EventInfo offSale(String EventId) {
        EventInfo EventInfo = EventInfoRepository.findOne(EventId);
        if (EventInfo == null) {
            throw new SellException(ResultEnum.Event_NOT_EXI);
        }
        if (EventInfo.getEventStatusEnum() == EventStatusEnum.DOWN) {
            throw new SellException(ResultEnum.Event_STATUS_ERROR);
        }

        //更新
        EventInfo.setEventStatus(EventStatusEnum.DOWN.getCode());
        return EventInfoRepository.save(EventInfo);
    }
}
