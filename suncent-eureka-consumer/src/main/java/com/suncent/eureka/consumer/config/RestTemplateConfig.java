/**  
* <p>Title: RestTemplateConfig.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月4日  
* @version 1.0  
*/  
package com.suncent.eureka.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**  
 * <p>Title: RestTemplateConfig</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月4日 下午4:38:19
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
