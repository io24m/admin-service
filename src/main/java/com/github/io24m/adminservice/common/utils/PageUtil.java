package com.github.io24m.adminservice.common.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 14:54
 */
public class PageUtil {
    public static <E> Page<E> startPage() {
        HttpServletRequest request = RequestUtil.getRequest();
        int pageNum = Integer.valueOf(request.getParameter("pageNum"));
        int pageSize = Integer.valueOf(request.getParameter("pageSize"));
        return PageHelper.startPage(pageNum, pageSize);
    }
}
