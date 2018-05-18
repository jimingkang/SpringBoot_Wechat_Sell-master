package org.ldlood.dataobject.dao;

import org.ldlood.dataobject.mapper.EventCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Ldlood on 2017/8/16.
 */
public class EventCategoryDao {

    @Autowired
    private EventCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}
