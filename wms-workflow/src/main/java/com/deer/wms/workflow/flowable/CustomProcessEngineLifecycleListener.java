package com.deer.wms.workflow.flowable;

import org.apache.ibatis.session.SqlSessionFactory;
import org.flowable.engine.ProcessEngine;

/**
 * MyProcessEngineLifecycleListener
 *
 * @author luxin.yan
 * @date 2019/2/14
 **/
public interface CustomProcessEngineLifecycleListener {
    default void onProcessEngineBuilt(ProcessEngine processEngine, SqlSessionFactory sqlSessionFactory) {

    }
    default void onProcessEngineClosed(ProcessEngine processEngine, SqlSessionFactory sqlSessionFactory) {

    }
}
