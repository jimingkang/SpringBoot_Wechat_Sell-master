package org.ldlood.dataobject.mapper;

import org.ldlood.dataobject.EventCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Ldlood on 2017/8/15.
 */
public interface EventCategoryMapper {


    @Insert("insert into event_category(category_name, category_type) values (#{categoryName, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);


    @Insert("insert into event_category(category_name, category_type) values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(EventCategory EventCategory);

    @Select("select * from event_category where category_type=#{categoryType} ")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    EventCategory findByCategoryType(Integer categoryType);


    @Select("select * from event_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<EventCategory> findByCategoryName(String categoryName);

    @Update("update event_category set category_name=#{categoryName} where category_type=#{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    @Update("update event_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(EventCategory EventCategory);

    @Delete("delete from event_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);



    //    xml方式
    EventCategory selectByCategoryType(Integer categoryType);
}
