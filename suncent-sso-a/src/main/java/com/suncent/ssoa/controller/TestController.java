/**  
* <p>Title: TestController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月3日  
* @version 1.0  
*/  
package com.suncent.ssoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * <p>Title: TestController</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月3日 上午11:13:17
 */
@Controller
public class TestController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
