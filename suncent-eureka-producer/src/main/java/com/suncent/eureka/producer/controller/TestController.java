/**  
* <p>Title: TestController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月4日  
* @version 1.0  
*/  
package com.suncent.eureka.producer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**  
 * <p>Title: TestController</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月4日 下午4:34:16
 */
@Controller("/producer")
public class TestController {

	@RequestMapping(value="/sayHello",method = RequestMethod.GET)
	public @ResponseBody String sayHello() {
		return "Hi,I like the world!";
	}
}
