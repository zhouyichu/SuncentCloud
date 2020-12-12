/**  
* <p>Title: PageController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月12日  
* @version 1.0  
*/  
package com.suncent.websocket.controller;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**  
 * <p>Title: PageController</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月12日 下午2:28:27
 */
@Controller
public class PageController {

	@RequestMapping(value = "/chatroom",method = RequestMethod.GET)
	public String chatroom(Model model) {
		String filename=RandomStringUtils.randomAlphanumeric(10);
		model.addAttribute("nick", filename);
		return "chatroom";
	}
}
