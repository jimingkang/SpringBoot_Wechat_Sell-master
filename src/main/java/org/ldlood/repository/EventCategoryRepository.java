package org.ldlood.repository;

import org.ldlood.dataobject.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {


    /**
     * 通过类目id查找类目
     * @param categoryTypeList
     * @return
     */
    List<EventCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
