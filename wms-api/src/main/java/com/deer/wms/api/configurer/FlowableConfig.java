package com.deer.wms.api.configurer;

import com.deer.wms.workflow.flowable.image.MyProcessDiagramGenerator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * DelegatingWebMvcConfiguration
 * flowable配置重新设置
 * 防止生成的流程图中中文乱码
 *
 * @author luxin.yan
 * @date 2019/1/8
 **/
@Configuration
public class FlowableConfig implements EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void configure(SpringProcessEngineConfiguration engineConfiguration) {
        engineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                //属性asyncExecutorActivate定义为true，工作流引擎在启动时就建立启动async executor线程池
                .setAsyncExecutorActivate(false)
                //流程发布的时候是否生成流程图
                .setCreateDiagramOnDeploy(true)
                //生成流程图参数
                .setProcessDiagramGenerator(new MyProcessDiagramGenerator());
        //显示流程连线名称
        engineConfiguration.setDrawSequenceFlowNameWithNoLabelDI(true);
        engineConfiguration.setActivityFontName("宋体");
        engineConfiguration.setLabelFontName("宋体");
        engineConfiguration.setAnnotationFontName("宋体");
        //禁用组织机构管理
        engineConfiguration.setDisableIdmEngine(true);
        //配置监听
//        engineConfiguration.setTypedEventListeners(getGlobalFlowableEventListener());
        //使用spring进行事务管理
        engineConfiguration.setTransactionsExternallyManaged(true);
//        engineConfiguration.setIdGenerator(new MyStrongUuidGenerator());
//        engineConfiguration.setProcessEngineLifecycleListener(new MyProcessEngineLifecycleListener());
        System.out.println(engineConfiguration.getSqlSessionFactory());
    }

//    /**
//     * 设置系统级别监听器
//     */
//    private Map<String, List<FlowableEventListener>> getGlobalFlowableEventListener() {
//        Map<String, List<FlowableEventListener>> typedListeners = new HashMap<>();
//        List<FlowableEventListener> processCompleteList = new ArrayList<>();
//        processCompleteList.add(new ProcessEndListener());
//        typedListeners.put("PROCESS_COMPLETED", processCompleteList);
//        return typedListeners;
//
//    }
//
//    private class MyProcessEngineLifecycleListener implements ProcessEngineLifecycleListener {
//        private Logger logger = LoggerFactory.getLogger(MyProcessEngineLifecycleListener.class);
//        private List<CustomProcessEngineLifecycleListener> processEngineLifecycleListeners = new ArrayList<>();
//
//        public MyProcessEngineLifecycleListener() {
//            regist();
//        }
//
//        private void regist() {
//            processEngineLifecycleListeners.add(new DynamicTaskInitLifecycleListener());
//        }
//
//        @Override
//        public void onProcessEngineBuilt(ProcessEngine processEngine) {
//            logger.info("流程引擎已经构完毕：" + processEngine);
//            //当流程引擎启动时可以初始化一些必要的东西
//            processEngineLifecycleListeners.forEach(processEngineLifecycleListener -> processEngineLifecycleListener.onProcessEngineBuilt(processEngine, sqlSessionFactory));
//        }
//
//        @Override
//        public void onProcessEngineClosed(ProcessEngine processEngine) {
//            logger.info("流程引擎已经关闭了" + processEngine);
//        }
//    }
}

