package org.ldlood.service;

import org.ldlood.dataobject.EventCategory;

import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
public interface CategoryService {
    EventCategory findOne(Integer categoryId);

    List<EventCategory> findAll();

    List<EventCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    EventCategory save(EventCategory EventCategory);

}
