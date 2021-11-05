package com.grtidsp.node.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.grtidsp.node.model.PageRequest;
import org.apache.commons.beanutils.BeanUtils;

public abstract class BaseBean {
	/**
	 * 把Map中的值注入到对应的JavaBean属性中。
	 * 
	 * @param value
	 * @param bean
	 */
	public static <T> T copyParamToBean(Map value, T bean) {
		try {
			System.out.println("注入之前：" + bean);
			/**
			 * 把所有请求的参数都注入到user对象中
			 */
			BeanUtils.populate(bean, value);
			System.out.println("注入之后：" + bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public static void main(String[] args) {
		PageRequest p1 = new PageRequest();
		p1.setPageNum(1);
		p1.setPageSize(10);
		PageRequest p2 = new PageRequest();
		Map<String,Integer> map = new HashMap<>();
		map.put("pageNum", 1);
		map.put("pageSize", 10);
		try {
			//p2 = (PageRequest)BeanUtils.cloneBean(p1);
			//System.out.println(p2.getPageNum());
			//BeanUtils.populate(p2, map);
			BeanUtils.copyProperties(p2, p1);
			System.out.println(p2.getPageNum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}