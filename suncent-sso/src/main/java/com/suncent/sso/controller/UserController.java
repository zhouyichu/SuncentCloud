/**  
* <p>Title: UserController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年10月30日  
* @version 1.0  
*/  
package com.suncent.sso.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.suncent.sso.service.UserService;
import com.suncent.sso.utils.ExcelReader;
import com.suncent.sso.utils.ResponseInfo;
import com.suncent.sso.utils.ResultUtil;
import com.suncent.sso.vo.UserVO;

/**  
 * <p>Title: UserController</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年10月30日 下午2:35:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/batchInsertUser",method = RequestMethod.POST)
	public ResponseInfo<?> batchInsertUser(HttpServletRequest request) {
		log.info("Batch insert user>>>");
		String path = request.getParameter("path");
		List<UserVO> userList = ExcelReader.readExcel(path);
		int res = userService.batchInsertUser(userList);
		log.info("Total: "+res);
		if(res>0) {
			return ResultUtil.success("Total: "+res);
		}else {
			return ResultUtil.error();
		}
	}
}
