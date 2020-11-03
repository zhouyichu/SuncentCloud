/**  
* <p>Title: LoginInterceptor.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月2日  
* @version 1.0  
*/  
package com.suncent.ssoa.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.suncent.ssoa.util.HttpAPI;

/**  
 * <p>Title: LoginInterceptor</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月2日 下午4:45:43
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	private LoginInterceptor loginInterceptor;
	private HttpAPI httpApi;
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	@Bean
	public LoginInterceptor getLoginInterceptor() {
		if (loginInterceptor != null) {
			return loginInterceptor;
		} else {
			return new LoginInterceptor();
		}
	}
	
	@Bean
	public HttpAPI getHttpApi() {
		if(httpApi != null) {
			return httpApi;
		}else {
			return new HttpAPI();
		}
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length >0) {
			for (Cookie cookie : cookies) {
				if("tokenId".equals(cookie.getName())) {
					log.info("sso-a: cookie exist, begin check...");
					String wlId = cookie.getValue();
					String userStr = getHttpApi().doGet("http://localhost:8080/suncent-sso/user/checkToken?wlId="+wlId);
					log.info("Get user info: "+userStr);
					if(StringUtils.isEmpty(userStr)) {
						response.sendRedirect("http://localhost:8080/suncent-sso/user/test");
						return false;
					}else {
						request.getSession().setAttribute("user", userStr);
						return true;
					}
				}else {
					response.sendRedirect("http://localhost:8080/suncent-sso/user/test");
					return false;
				}
			}
		}else {
			response.sendRedirect("http://localhost:8080/suncent-sso/user/test");
		}
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getLoginInterceptor());
		// 排除配置
		addInterceptor.excludePathPatterns("/login", "/checkLogin", "/register", "/loginValidateCode","/checkLoginValidateCode", "/static/**","/baseQuery/**");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}
}
