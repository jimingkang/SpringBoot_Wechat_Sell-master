package org.ldlood.controller;

import org.ldlood.dataobject.EventCategory;
import org.ldlood.dataobject.EventInfo;
import org.ldlood.form.EventForm;
import org.ldlood.service.CategoryService;
import org.ldlood.service.EventService;
import org.ldlood.utils.KeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Ldlood on 2017/8/4.
 */
@Controller
@RequestMapping("/seller/Event")
@CrossOrigin
public class SellerEventController {

    @Autowired
    private EventService EventService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     *
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<EventInfo> EventInfoPage = EventService.findAll(request);
        map.put("EventInfoPage", EventInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("event/list", map);
    }

    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("EventId") String EventId,
                               Map<String, Object> map) {
        try {
            EventService.onSale(EventId);
        } catch (Exception ex) {
            map.put("msg", ex.getMessage());
            map.put("url", "/seller/Event/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/Event/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("EventId") String EventId,
                                Map<String, Object> map) {
        try {
            EventService.offSale(EventId);
        } catch (Exception ex) {
            map.put("msg", ex.getMessage());
            map.put("url", "/seller/Event/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/Event/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView Index(@RequestParam(value = "EventId", required = false) String EventId,
                              Map<String, Object> map) {

        if (!StringUtils.isEmpty(EventId)) {
            EventInfo EventInfo = EventService.findOne(EventId);
            map.put("EventInfo", EventInfo);
        }
        List<EventCategory> EventCategoryList = categoryService.findAll();
        map.put("EventCategoryList", EventCategoryList);
        return new ModelAndView("event/index", map);
    }

    @PostMapping("/save")
    @CacheEvict(cacheNames = "Event", key = "123")
    public ModelAndView save(@Valid EventForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/Event/index");
            return new ModelAndView("common/error", map);
        }


        try {
            EventInfo EventInfo = new EventInfo();
            //更新
            if (!StringUtils.isEmpty(form.getEventId())) {
                EventInfo = EventService.findOne(form.getEventId());
            }
            //新增
            else {
                form.setEventId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form, EventInfo);
            EventService.save(EventInfo);

        } catch (Exception ex) {
            map.put("msg", ex.getMessage());
            map.put("url", "/seller/Event/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/Event/list");
        return new ModelAndView("common/success", map);

    }
}
