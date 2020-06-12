package io.github.lamprose.bookshell.interceptor;

import com.alibaba.fastjson.JSONObject;
import io.github.lamprose.bookshell.utils.CommonConfig;
import io.github.lamprose.bookshell.utils.NetUtils;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LogInterceptor implements HandlerInterceptor {

    private final static Logger logger= LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long startTime = System.currentTimeMillis();
        JSONObject json = new JSONObject();
        //用户ip
        json.put(CommonConfig.IP, NetUtils.getClientIpAddress(request));
        //请求路径
        json.put(CommonConfig.REQ_PATH,request.getRequestURI());
        //请求参数
        Map<String,String[]> map = request.getParameterMap();
        map.forEach((key,value) -> {
            json.put(key,request.getParameter(key));
        });
        request.getParameterMap().forEach(json::put);
        //记录请求开始时间
        request.setAttribute(CommonConfig.START_TIME,startTime);
        //traceId
        json.put(CommonConfig.TRACE_ID, MDC.get(CommonConfig.TRACE_ID));

        json.put(CommonConfig.LOG_TYPE,CommonConfig.START);

        json.put(CommonConfig.RES_TYPE,request.getMethod());

        logger.info(CommonConfig.LOG_PREFIX + json.toJSONString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        JSONObject json = new JSONObject();
        Long startTime = (Long) request.getAttribute(CommonConfig.START_TIME);
        //请求耗时
        json.put(CommonConfig.CONSUME_TIME,System.currentTimeMillis() - startTime);
        //traceId
        json.put(CommonConfig.TRACE_ID,MDC.get(CommonConfig.TRACE_ID));
        //响应Data
        json.put(CommonConfig.RES_BODY,request.getAttribute(CommonConfig.RES_BODY));
        //状态码
        json.put(CommonConfig.STATUS_CODE,response.getStatus());
        //日志类型
        json.put(CommonConfig.LOG_TYPE,CommonConfig.END);

        logger.info(CommonConfig.LOG_PREFIX + json.toJSONString());
    }
}
