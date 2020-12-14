/**  
* <p>Title: InfoService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年12月14日  
* @version 1.0  
*/  
package com.suncent.sso.service;

import java.util.List;
import com.suncent.sso.vo.CoreVO;
import com.suncent.sso.vo.DeptVO;

/**  
 * <p>Title: InfoService</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年12月14日 下午4:08:54
 */
public interface InfoService {

	public List<DeptVO> deptList();
	
	public List<CoreVO> coreList();
}
