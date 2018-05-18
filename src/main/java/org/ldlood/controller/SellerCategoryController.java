package org.ldlood.controller;

import org.ldlood.dataobject.EventCategory;
import org.ldlood.exception.SellException;
import org.ldlood.form.CategoryForm;
import org.ldlood.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Ldlood on 2017/8/10.
 */
@Controller
@RequestMapping("/seller/category")
@CrossOrigin
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 类目列表
     *
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<EventCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {

        if (categoryId != null) {
            EventCategory EventCategory = categoryService.findOne(categoryId);
            map.put("EventCategory", EventCategory);
        }

        return new ModelAndView("category/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        EventCategory EventCategory = new EventCategory();
        try {
            if (form.getCategoryId() != null) {
                EventCategory = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, EventCategory);
            categoryService.save(EventCategory);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
