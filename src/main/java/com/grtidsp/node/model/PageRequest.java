package com.grtidsp.node.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页码
	 */
	private int pageNum;
	/**
	 * 每页数量
	 */
	private int pageSize;
}
