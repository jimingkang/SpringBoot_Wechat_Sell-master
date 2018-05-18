package org.ldlood.service.impl;

import org.ldlood.dataobject.EventCategory;
import org.ldlood.repository.EventCategoryRepository;
import org.ldlood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private EventCategoryRepository EventCategoryRepository;

    @Override
    public EventCategory findOne(Integer categoryId) {
        return EventCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<EventCategory> findAll() {
        return EventCategoryRepository.findAll();
    }

    @Override
    public List<EventCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
       return EventCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public EventCategory save(EventCategory EventCategory) {
        return  EventCategoryRepository.save(EventCategory);
    }
}
