package org.ldlood.repository;

import org.ldlood.dataobject.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ldlood on 2017/7/20.
 */
public interface EventInfoRepository extends JpaRepository<EventInfo, String> {

    /**
     * 通过产品状态查找产品
     * @param EventStatus
     * @return
     */
    List<EventInfo> findByEventStatus(Integer EventStatus);
}
