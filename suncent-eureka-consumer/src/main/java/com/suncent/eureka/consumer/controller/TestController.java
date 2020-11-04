/**  
* <p>Title: TestController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月4日  
* @version 1.0  
*/  
package com.suncent.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**  
 * <p>Title: TestController</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月4日 下午4:36:20
 */
@RestController("/consumer")
public class TestController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/sayHi")
	public String sayHello() {
		String hiStr = restTemplate.getForObject("http://eureka-producer/producer/sayHello", String.class);
		return hiStr;
	}
}
