/**  
* <p>Title: DomainService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月3日  
* @version 1.0  
*/  
package com.suncent.sso.service;

import java.util.List;

import com.suncent.sso.vo.DomainVO;

/**  
 * <p>Title: DomainService</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月3日 下午3:31:00
 */
public interface DomainService {

	public List<DomainVO> getAll();
}
