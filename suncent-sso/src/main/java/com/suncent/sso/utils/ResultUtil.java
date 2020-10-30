/**  
* <p>Title: ResultUtil.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年10月30日  
* @version 1.0  
*/  
package com.suncent.sso.utils;

/**  
 * <p>Title: ResultUtil</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年10月30日 下午2:53:29
 */
public class ResultUtil {

	public static ResponseInfo<String> success(){
		ResponseInfo<String> ri = new ResponseInfo<String>();
		ri.setCode("200");
		ri.setMsg("success!");
		return ri;
	}
	
	public static ResponseInfo<String> success(String data){
		ResponseInfo<String> ri = new ResponseInfo<String>();
		ri.setCode("200");
		ri.setMsg("success!");
		ri.setData(data);
		return ri;
	}
	
	public static ResponseInfo<String> success(String msg,String data){
		ResponseInfo<String> ri = new ResponseInfo<String>();
		ri.setCode("200");
		ri.setMsg(msg);
		ri.setData(data);
		return ri;
	}
	
	public static ResponseInfo<String> error(){
		ResponseInfo<String> ri = new ResponseInfo<String>();
		ri.setCode("500");
		ri.setMsg("error!");
		return ri;
	}
	
	public static ResponseInfo<String> error(String data){
		ResponseInfo<String> ri = new ResponseInfo<String>();
		ri.setCode("500");
		ri.setMsg("error!");
		ri.setData(data);
		return ri;
	}
	
	public static ResponseInfo<String> error(String msg,String data){
		ResponseInfo<String> ri = new ResponseInfo<String>();
		ri.setCode("500");
		ri.setMsg(msg);
		ri.setData(data);
		return ri;
	}
}
