package com.deer.wms.workflow.constant;

/**
 * luxin.yan
 *  
 *  2018年12月23日
 **/
public class WorkFlowConstant {
	/**
	 * 项目基础包名称，根据公司实际项目修改
	 */
	public static final String BASE_PACKAGE = "com.deer.wms.workflow";

	/**
	 * Model所在包
	 */
	public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";

	/**
	 * Dao所在包
	 */
	public static final String DAO_PACKAGE = BASE_PACKAGE + ".dao";

	/**
	 * MapperLocations
	 */
	public static final String MAPPER_LOCATIONS = "classpath*:com/deer/wms/**/mapper/*.xml";

}
