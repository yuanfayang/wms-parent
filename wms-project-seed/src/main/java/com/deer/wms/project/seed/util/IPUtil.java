package com.deer.wms.project.seed.util;

/**  
* Description:
*  
* @author gtt
* @date 2019年2月15日  
* @version 1.0  
*/
import java.io.File;
import java.lang.reflect.Method;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import com.deer.wms.project.seed.ip2region.DataBlock;
import com.deer.wms.project.seed.ip2region.DbConfig;
import com.deer.wms.project.seed.ip2region.DbSearcher;
import com.deer.wms.project.seed.ip2region.Util;

public class IPUtil {

	public static String getCityInfo(String ip) {
		try {
			// db
			// String dbPath = IPUtil.class.getResource("ip2region.db").getPath();
//			Resource resource = new ClassPathResource("ip2region.db");
//			File file = resource.getFile();
			 File file = new File("C:\\ipdb\\ip2region.db");
			if (file.exists() == false) {
				System.out.println("Error: Invalid ip2region.db file");
				return "ip2region.db找不到";  
			}
			System.out.println(file.getPath());
			// 查询算法
			int algorithm = DbSearcher.BTREE_ALGORITHM; // B-tree
			// DbSearcher.BINARY_ALGORITHM //Binary
			// DbSearcher.MEMORY_ALGORITYM //Memory

			DbConfig config = new DbConfig();
			DbSearcher searcher = new DbSearcher(config, file.getPath());

			// define the method
			Method method = null;
			switch (algorithm) {
			case DbSearcher.BTREE_ALGORITHM:
				method = searcher.getClass().getMethod("btreeSearch", String.class);
				break;
			case DbSearcher.BINARY_ALGORITHM:
				method = searcher.getClass().getMethod("binarySearch", String.class);
				break;
			case DbSearcher.MEMORY_ALGORITYM:
				method = searcher.getClass().getMethod("memorySearch", String.class);
				break;
			}

			DataBlock dataBlock = null;
			if (Util.isIpAddress(ip) == false) {
				System.out.println("Error: Invalid ip address");
				return "无效IP";
			}

			dataBlock = (DataBlock) method.invoke(searcher, ip);

			return dataBlock.getRegion();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) throws Exception {
		 System.out.println(getCityInfo("220.248.12.158"));
		System.out.println(getCityInfo("172.19.24.40"));
	}
}