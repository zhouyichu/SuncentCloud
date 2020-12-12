/**  
* <p>Title: ValidateService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年12月12日  
* @version 1.0  
*/  
package com.suncent.sso.service;

import com.suncent.sso.vo.UserVO;

/**  
 * <p>Title: ValidateService</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年12月12日 下午2:24:34
 */
public interface ValidateService {

	public UserVO checkAccount(String account);
}
