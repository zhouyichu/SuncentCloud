/**  
* <p>Title: DomainMapper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月3日  
* @version 1.0  
*/  
package com.suncent.sso.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.suncent.sso.vo.DomainVO;

/**  
 * <p>Title: DomainMapper</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月3日 下午3:32:26
 */
@Repository
public interface DomainMapper {
	public List<DomainVO> getAll();
}
