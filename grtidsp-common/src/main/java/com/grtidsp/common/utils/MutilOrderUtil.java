package com.grtidsp.common.utils;

import java.lang.reflect.Method;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 对象多字符串，排序类
 * 
 * @author daiqingsong
 * @date 2021-10
 * 
 * 
 */
public class MutilOrderUtil implements Comparator<Object> {
	String[] fields = null;
	String[] orders = null;
	boolean isValue;
	Collator cmp = Collator.getInstance(java.util.Locale.CHINA);

	public MutilOrderUtil() {
		super();
	}

	public MutilOrderUtil(String[] fields, String[] orders) {
		super();
		this.fields = fields;
		this.orders = orders;
	}

	public String[] getFields_user() {
		return fields;
	}

	public void setFields(String[] fields_user) {
		this.fields = fields_user;
	}

	public String[] getOrders() {
		return orders;
	}

	public void setOrders(String[] orders) {
		this.orders = orders;
	}

	/**
	 * 
	 * compare
	 * 
	 */
	@Override
	public int compare(Object obj1, Object obj2) {
		// 没有属性，则不排序
		if (fields == null || fields.length <= 0) {
			return 2;// 不比较
		}
		for (int i = 0; i < fields.length; i++) {
			int ret = compareField(obj1, obj2, fields[i]);
			if (ret == 0) {
				continue;
			} else {
				if ("asc".equalsIgnoreCase(orders[i])) {
					return ret;
				} else if ("desc".equalsIgnoreCase(orders[i])) {
					return ret * -1;
				}
			}
		}
		return 0;
	}

	private int compareField(Object o1, Object o2, String fieldName) {
		Object value1 = getFieldValueByName(fieldName, o1);
		Object value2 = getFieldValueByName(fieldName, o2);
		if (value1 == null || value2 == null) {
			if (value1 != null) {
				return 1;
			}
			if (value2 != null) {
				return -1;
			} else {
				return 0;
			}
		}
		if (isValue) {
			double v1 = ((Number) value1).doubleValue();
			double v2 = ((Number) value2).doubleValue();
			if (v1 - v2 > 0) {
				return 1;
			} else if (v1 == v2) {
				return 0;
			}
			return -1;
		} else {
			String v1 = value1.toString();
			String v2 = value2.toString();
			int i = cmp.compare(v1, v2);
			if (i > 0) {
				return 1;
			} else if (i == 0) {
				return 0;
			}
			return -1;
		}
	}

	private Object getFieldValueByName(String fieldName, Object obj) {
		try {
			Class<? extends Object> objClass = obj.getClass();
			String Letter = fieldName.substring(0, 1).toUpperCase();
			String methodStr = "get" + Letter + fieldName.substring(1);

			Method method = objClass.getMethod(methodStr, new Class[] {});
			Object value = method.invoke(obj, new Object[] {});

			if (value instanceof Number) {
				this.setValue(true);
			} else {
				this.setValue(false);
			}

			return value;
		} catch (Exception e) {
			System.err.println("FieldName:" + fieldName + " is not exsited.");
			return null;
		}
	}

	public boolean isValue() {
		return isValue;
	}

	public void setValue(boolean isValue) {
		this.isValue = isValue;
	}

	public static void main(String[] args) {
		List<JavaBean> list = new ArrayList<JavaBean>();
		JavaBean bean = new JavaBean(4, "张三0.01", "a");
		list.add(bean);
		bean = new JavaBean(3, "张三0.001", "a");
		list.add(bean);
		bean = new JavaBean(2, "王五", "b");
		list.add(bean);
		bean = new JavaBean(1, "钱七", "b");
		list.add(bean);
		MutilOrderUtil comparator = new MutilOrderUtil();
		comparator.setFields(new String[] { "address", "name", "id" });
		comparator.setOrders(new String[] { "asc", "desc", "asc" });
		Collections.sort(list, comparator);
		for (JavaBean obj : list) {
			System.out.println(obj.getId() + ":" + obj.getName() + ":" + obj.getAddress());
		}
	}
}

class JavaBean {
	private String name;
	private String address;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JavaBean(int id, String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.id = id;
	}
}
