/**  
* <p>Title: UserService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年10月30日  
* @version 1.0  
*/  
package com.suncent.sso.service;

import java.util.List;

import com.suncent.sso.vo.UserVO;

/**  
 * <p>Title: UserService</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年10月30日 下午2:06:21
 */
public interface UserService {

	public int insertUser(UserVO user);
	
	public int batchInsertUser(List<UserVO> userList);
	
	public int updateUser(UserVO user);
	
	public UserVO queryUser(UserVO user);
	
	public UserVO checkUser(String account,String pwd);
	
	public boolean isExist(UserVO user);
	
	public int updateUserPwd();
}
