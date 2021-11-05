package com.grtidsp.node.parent.model;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest 
     * @param
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = PageResult.builder().pageNum(pageInfo.getPageNum()).pageSize(pageInfo.getPageSize()).totalPages(pageInfo.getPages()).content(pageInfo.getList()).build();
        return pageResult;
    }
}
