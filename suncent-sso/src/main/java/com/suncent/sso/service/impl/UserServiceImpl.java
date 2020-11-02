/**  
* <p>Title: UserServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年10月30日  
* @version 1.0  
*/  
package com.suncent.sso.service.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.suncent.sso.mapper.UserMapper;
import com.suncent.sso.service.UserService;
import com.suncent.sso.utils.MD5Utils;
import com.suncent.sso.vo.UserVO;

/**  
 * <p>Title: UserServiceImpl</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年10月30日 下午2:09:05
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public int insertUser(UserVO user) {
		user.setUserId(UUID.randomUUID().toString());
		String pwd = user.getPwd();
		user.setPwd(MD5Utils.MD5(pwd));
		return userMapper.insertUser(user);
	}
	
	public int batchInsertUser(List<UserVO> userList) {
		for (UserVO userVO : userList) {
			String level = userMapper.getLevelByCoreDept(userVO.getCore(), userVO.getDept());
			userVO.setLevel(level);
			userVO.setUserId(UUID.randomUUID().toString());
			String pwd = userVO.getPwd();
			if(!StringUtils.isEmpty(pwd)) {
				userVO.setPwd(MD5Utils.MD5(pwd));
			}
		}
		return userMapper.batchInsertUser(userList);
	}

	@Override
	public int updateUser(UserVO user) {
		return userMapper.updateUser(user);
	}

	@Override
	public UserVO queryUser(UserVO user) {
		String pwd = user.getPwd();
		user.setPwd(MD5Utils.MD5(pwd));
		return userMapper.queryUser(user);
	}

	@Override
	public UserVO checkUser(String account, String pwd) {
		pwd = MD5Utils.MD5(pwd);
		return userMapper.checkUser(account, pwd);
	}

	@Override
	public int updateUserPwd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isExist(UserVO user) {
		int res = userMapper.isExist(user);
		return res>0?true:false;
	}

}
