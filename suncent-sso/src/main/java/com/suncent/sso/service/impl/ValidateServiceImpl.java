/**  
* <p>Title: ValidateServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年12月12日  
* @version 1.0  
*/  
package com.suncent.sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suncent.sso.mapper.UserMapper;
import com.suncent.sso.service.ValidateService;
import com.suncent.sso.vo.UserVO;

/**  
 * <p>Title: ValidateServiceImpl</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年12月12日 下午2:26:24
 */
@Service
public class ValidateServiceImpl implements ValidateService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public UserVO checkAccount(String account) {
		return userMapper.checkUser(account, null);
	}

}
