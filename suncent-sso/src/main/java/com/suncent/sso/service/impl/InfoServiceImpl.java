/**  
* <p>Title: InfoServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年12月14日  
* @version 1.0  
*/  
package com.suncent.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suncent.sso.mapper.InfoMapper;
import com.suncent.sso.service.InfoService;
import com.suncent.sso.vo.CoreVO;
import com.suncent.sso.vo.DeptVO;

/**  
 * <p>Title: InfoServiceImpl</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年12月14日 下午4:10:25
 */
@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoMapper infoMapper;
	@Override
	public List<DeptVO> deptList() {
		return infoMapper.deptList();
	}

	@Override
	public List<CoreVO> coreList() {
		return infoMapper.coreList();
	}

}
