package org.ldlood.controller;

import org.ldlood.VO.EventInfoVO;
import org.ldlood.VO.EventVO;
import org.ldlood.VO.ResultVO;
import org.ldlood.dataobject.EventCategory;
import org.ldlood.dataobject.EventInfo;
import org.ldlood.service.CategoryService;
import org.ldlood.service.EventService;
import org.ldlood.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ldlood on 2017/7/20.
 */
@RestController
@RequestMapping("/buyer/Event")
@CrossOrigin
public class BuyerEventController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private EventService EventService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
   // @Cacheable(cacheNames = "Event", key = "#sellerid", condition = "#sellerid.length()>10", unless = "#result.getCode() !=0")
    public ResultVO list(@RequestParam(value = "sellerid", required = false) String sellerid) {

        //查询上架的商品
        List<EventInfo> EventInfoList = EventService.findUpAll();


        List<Integer> categoryTypeList = EventInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<EventCategory> EventCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        List<EventVO> EventVOList = new ArrayList<>();
        for (EventCategory EventCategory : EventCategoryList) {
            EventVO EventVO = new EventVO();
            EventVO.setCategoryType(EventCategory.getCategoryType());
            EventVO.setCategoryName(EventCategory.getCategoryName());


            List<EventInfoVO> EventInfoVOList = new ArrayList<>();
            for (EventInfo EventInfo : EventInfoList) {
                if (EventInfo.getCategoryType().equals(EventCategory.getCategoryType())) {
                    EventInfoVO EventInfoVO = new EventInfoVO();
                    BeanUtils.copyProperties(EventInfo, EventInfoVO);
                    EventInfoVOList.add(EventInfoVO);
                }
            }
            EventVO.setEventInfoVOList(EventInfoVOList);
            EventVOList.add(EventVO);
        }

        return ResultVOUtil.success(EventVOList);

    }
}
