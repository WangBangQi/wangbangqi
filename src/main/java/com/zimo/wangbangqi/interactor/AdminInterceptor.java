package com.zimo.wangbangqi.interactor;

import com.alibaba.fastjson.JSON;
import com.zimo.wangbangqi.model.Admin;
import com.zimo.wangbangqi.model.Result;
import com.zimo.wangbangqi.service.adminService.AdminService;
import com.zimo.wangbangqi.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

@Component
public class AdminInterceptor implements HandlerInterceptor{
    private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
    /**
     * 返回为true才验证通过
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("=========== request before ============");
        AdminService adminService = SpringUtil.getBean(AdminService.class);
        Admin admin = new Admin();
//        Map<String,String[]> map = request.getParameterMap();
//        Enumeration<String> enumeration = request.getParameterNames();
        admin.setAccNum(request.getParameter("accNum"));
        admin.setPassword(request.getParameter("password"));
        logger.info("admin accNum : {}" ,admin.getAccNum());
        logger.info("admin password : {}","******");
        return adminService.judgeAdmin(admin);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("==============  request  ==============");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("==============  request completion  ==============");
    }
    private void writeBack(HttpServletResponse response,Result dataResult){
//      preHandler要抛出异常时，response进行响应，返回数据。
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(dataResult));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

