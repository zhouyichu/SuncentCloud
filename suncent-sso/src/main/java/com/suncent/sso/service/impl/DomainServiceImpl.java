/**  
* <p>Title: DomainServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月3日  
* @version 1.0  
*/  
package com.suncent.sso.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suncent.sso.mapper.DomainMapper;
import com.suncent.sso.service.DomainService;
import com.suncent.sso.vo.DomainVO;

/**  
 * <p>Title: DomainServiceImpl</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月3日 下午3:31:40
 */
@Service
public class DomainServiceImpl implements DomainService{
	@Autowired
	private DomainMapper domainMapper;
	@Override
	public List<DomainVO> getAll() {
		return domainMapper.getAll();
	}

}
