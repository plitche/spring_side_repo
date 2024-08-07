package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class HttpInterceptor implements HandlerInterceptor {

    @Value("${plitche.hub.check}")
    protected boolean check;

    private final Logger LOGGER = LoggerFactory.getLogger(HttpInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (check) {
            LOGGER.info("실행되지 말아야할 기능");
        }

        LOGGER.info("[preHandler] preHandler is performed");
//        LOGGER.info("[preHandler] request : {}", request);
//        LOGGER.info("[preHandler] request path info : {}", request.getPathInfo());
//        LOGGER.info("[preHandler] request header names : {}", request.getHeaderNames());
//        LOGGER.info("[preHandler] request request URL : {}", request.getRequestURL());
//        LOGGER.info("[preHandler] request request URI : {}", request.getRequestURI());
//        LOGGER.info("[preHandler] request Requested Session ID : {}", request.getRequestedSessionId());

        // TODO HttpServletRequestWrapper 구현하여 Body 값 확인할 수 있게 코드 추가

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("[postHandle] postHandle is performed");
//        LOGGER.info("[postHandle] request : {}", request);
//        LOGGER.info("[postHandle] response : {}", response);
//        LOGGER.info("[postHandle] response : {}", response.getHeaderNames());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("[afterCompletion] afterCompletion is performed");
    }
}
