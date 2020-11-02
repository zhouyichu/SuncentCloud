/**  
* <p>Title: WebConfig.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月2日  
* @version 1.0  
*/  
package com.suncent.ssoa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**  
 * <p>Title: WebConfig</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月2日 下午4:42:51
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor loginInterceptor;

	// 这个方法是用来配置静态资源的，比如html，js，css，等等
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("*.jpg", "*.js", "*.html", "*.css", "*.jpeg");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/suncentmp/*","/checkLogin","/register");

	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry){
        //设置系统访问的默认首页
        registry.addViewController("/").setViewName("redirect:/index");
    }
}
