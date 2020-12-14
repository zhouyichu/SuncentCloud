/**  
* <p>Title: InfoMapper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年12月14日  
* @version 1.0  
*/  
package com.suncent.sso.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.suncent.sso.vo.CoreVO;
import com.suncent.sso.vo.DeptVO;

/**  
 * <p>Title: InfoMapper</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年12月14日 下午4:11:56
 */
@Repository
public interface InfoMapper {

	public List<DeptVO>	deptList();
	
	public List<CoreVO> coreList();
}
