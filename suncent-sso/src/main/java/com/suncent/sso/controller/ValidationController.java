/**  
* <p>Title: Validation.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年12月12日  
* @version 1.0  
*/  
package com.suncent.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.suncent.sso.service.ValidateService;
import com.suncent.sso.vo.UserVO;

/**  
 * <p>Title: Validation</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年12月12日 下午2:17:14
 */
@Controller
@RequestMapping("/validate")
public class ValidationController {
	@Autowired
	private ValidateService valiService;
	
	@RequestMapping("/checkAccount")
	public @ResponseBody JSONObject checkAccount(@RequestParam String account) {
		boolean res = true;
		if(StringUtils.isEmpty(account)) {
			res = false;
		}else {
			UserVO user = valiService.checkAccount(account);
			res=null==user?false:true;
		}
		JSONObject json = new JSONObject();
		json.put("valid", res);
		return json;
	}
}
