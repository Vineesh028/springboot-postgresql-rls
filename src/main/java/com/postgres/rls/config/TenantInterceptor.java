package com.postgres.rls.config;



import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.postgres.rls.exception.ErrorResponse;
import com.postgres.rls.util.Constant;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TenantInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (request.getHeader(Constant.TENANT_ID) == null) {
      response.getWriter().write(new ErrorResponse("Header tenant-id is missing").toString());
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.setContentType("application/json");
      return false;
    }
    try {
      String tenantId = request.getHeader(Constant.TENANT_ID);
      TenantContext.setTenantId(tenantId);
      return true;
    } catch (NumberFormatException e) {
      response.getWriter().write(new ErrorResponse("Header tenant-id value is incorrect").toString());
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.setContentType("application/json");
      return false;
    }

  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    TenantContext.clear();
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    
  }
}
