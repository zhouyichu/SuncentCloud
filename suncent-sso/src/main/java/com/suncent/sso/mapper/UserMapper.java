/**  
* <p>Title: UserMapper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年10月30日  
* @version 1.0  
*/  
package com.suncent.sso.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.suncent.sso.vo.UserVO;

/**  
 * <p>Title: UserMapper</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年10月30日 下午2:12:29
 */
@Repository
public interface UserMapper {
	
	public int insertUser(UserVO user);
	
	public int batchInsertUser(List<UserVO> userList);
	
	public int updateUser(UserVO user);
	
	public UserVO queryUser(UserVO user);
	
	public UserVO checkUser(String account,String pwd);
	
	public int updateUserPwd();
	
	public String getLevelByCoreDept(String core,String dept);
	
	public int isExist(UserVO user);
}
