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
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/batchInsertUser",method = RequestMethod.POST)
	public ResponseInfo<?> batchInsertUser(HttpServletRequest request) {
		String path = request.getParameter("path");
		List<UserVO> userList = ExcelReader.readExcel(path);
		int res = userService.batchInsertUser(userList);
		if(res>0) {
			return ResultUtil.success("Total: "+res);
		}else {
			return ResultUtil.error();
		}
	}
	
	
	@RequestMapping(value="/login",method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ResponseInfo<?> checkUser(HttpServletRequest request,HttpServletResponse response) {
		String account = request.getParameter("account");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String returnUrl = request.getParameter("returnUrl");
		//后台校验
		if(StringUtils.isEmpty(account) && StringUtils.isEmpty(phone) && StringUtils.isEmpty(email)) {
			log.info("User login error: user (account,phone,email) is null");
			return ResultUtil.error("User name is null");
		}
		if(StringUtils.isEmpty(pwd)) {
			log.info("User login error: user password is null");
			return ResultUtil.error("User password is null");
		}
		if(StringUtils.isEmpty(returnUrl)) {
			log.info("User login error: return url is null");
			return ResultUtil.error("Return url is null");
		}
		//	查询User
		UserVO tempUser = new UserVO();
		tempUser.setAccount(account);
		tempUser.setPhone(phone);
		tempUser.setEmail(email);
		tempUser.setPwd(pwd);
		UserVO user = userService.queryUser(tempUser);
		if(user == null) {
			log.info("Query user is null");
			return ResultUtil.error("Query user is null");
		}else {
			return ResultUtil.success();
		}
	}
}
