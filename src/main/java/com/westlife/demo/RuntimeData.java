package com.westlife.demo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.westlife.demo.model.IDCard;

/**
 * 
 * @ClassName: RuntimeData
 * @Description: 程序运行时数据
 * @author westlife
 * 
 *
 */
public class RuntimeData {

	private RuntimeData() {

	}

	/**
	 * 初始化各省市县信息
	 */
	private static Map<String, List<IDCard>> iDCardMap = new ConcurrentHashMap<>();

	public static Map<String, List<IDCard>> getIDCardMap() {
		return iDCardMap;
	}

}
