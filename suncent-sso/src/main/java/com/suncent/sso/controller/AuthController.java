/**  
* <p>Title: AuthController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年12月14日  
* @version 1.0  
*/  
package com.suncent.sso.controller;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.suncent.sso.config.RedisConfig;
import com.suncent.sso.service.InfoService;
import com.suncent.sso.service.UserService;
import com.suncent.sso.utils.JwtUtil;
import com.suncent.sso.utils.ResponseInfo;
import com.suncent.sso.utils.ResultUtil;
import com.suncent.sso.vo.CoreVO;
import com.suncent.sso.vo.DeptVO;
import com.suncent.sso.vo.UserVO;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**  
 * <p>Title: AuthController</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年12月14日 下午3:05:01
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RedisConfig redisCfg;
	@Autowired
	private InfoService infoService;
	
	@RequestMapping(value="",method = {RequestMethod.GET,RequestMethod.POST})
	public String test(HttpServletRequest request,Model model) {
		String returnUrl = request.getParameter("returnUrl");
		model.addAttribute("returnUrl", returnUrl);
		List<DeptVO> deptList = infoService.deptList();
		List<CoreVO> coreList = infoService.coreList();
		model.addAttribute("dept",deptList);
		model.addAttribute("core",coreList);
		return "login";
	}
	
	@RequestMapping(value="/checkAuth",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseInfo<?> login(HttpServletRequest request,HttpServletResponse response) {
		String account = request.getParameter("account");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String returnUrl = request.getParameter("returnUrl");
		//	后台校验
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
		}
		//	生成jwt存入redis
		String token = UUID.randomUUID().toString();
		String jwtValue = JwtUtil.sign(token);
		if(jwtValue != null) {
			JedisPool jedisPool = redisCfg.redisPoolFactory();
			Jedis jedis = jedisPool.getResource();
			JSONObject jo = (JSONObject) JSONObject.toJSON(user);
			jedis.set(token, jo.toJSONString());
			jedis.expire(token,1800);//半小时过期
		}
		//	签名设置到Cookie
		Cookie cookie = new Cookie("tokenId", jwtValue);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		//	转发
		try {
			response.sendRedirect(returnUrl);
		} catch (Exception e) {
			log.error("SSO login success,but redirect error: "+e.getMessage());
			e.printStackTrace();
		}
		return ResultUtil.success();
	}
	
	@RequestMapping(value="checkToken",method = RequestMethod.GET)
    public @ResponseBody String tokenCheck (String wlId) {
		String user = null;
		if(StringUtils.isEmpty(wlId)) {
			return null;
		}else{
			String token = JwtUtil.verify(wlId);
			if(StringUtils.isEmpty(token)) {
				return null;
			}
			Jedis jedis = redisCfg.redisPoolFactory().getResource();
            user = jedis.get(token);
            jedis.expire(token,1800);
        }
        return user;
    }
	
	/**
	 * 清空全局会话
	 * @param token 身份令牌
	 */
	@RequestMapping(value="/loginout",method = RequestMethod.GET)
	public void loginOut(String token) {
		Jedis jedis = redisCfg.redisPoolFactory().getResource();
		jedis.del(token);
	}
}
