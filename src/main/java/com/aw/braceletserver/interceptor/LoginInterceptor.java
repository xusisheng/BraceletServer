package com.aw.braceletserver.interceptor;

import com.aw.braceletserver.annotation.IgnoreSecurity;
import com.aw.braceletserver.entity.LoginResult;
import com.aw.braceletserver.entity.UserInfo;
import com.aw.braceletserver.properties.PresetUser;
import com.aw.braceletserver.service.UserService;
import com.aw.braceletserver.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private PresetUser presetUser;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle在请求处理之前进行调用（Controller方法调用之前）");
        // 只有返回true才会继续向下执行，返回false取消当前请求

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String requestPath = request.getRequestURI();
        logger.debug("requestIp: " + IpUtil.getIpAddress(request));
        logger.debug("Method: " + method.getName() + ", IgnoreSecurity: " + method.isAnnotationPresent(IgnoreSecurity.class));
        logger.debug("requestPath: " + requestPath);
        if (requestPath.contains("/swagger") || requestPath.contains("/configuration/ui")) {
            return true;
        }
        if (requestPath.contains("/error")) {
            return true;
        }
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return true;
        }
        LoginResult loginResult = userService.login(presetUser.getName(), presetUser.getPass());
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(loginResult, userInfo);
        request.setAttribute("UserInfo", userInfo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("postHandle在请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        logger.info("afterCompletion在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
