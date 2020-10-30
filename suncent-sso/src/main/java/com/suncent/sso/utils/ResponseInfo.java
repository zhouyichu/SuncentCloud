/**  
* <p>Title: ResponseInfo.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年10月30日  
* @version 1.0  
*/  
package com.suncent.sso.utils;

/**  
 * <p>Title: ResponseInfo</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年10月30日 下午2:44:44
 */
public class ResponseInfo<T> {
	private String code;//状态码
	private String msg;//响应消息
	private T data;//具体内容
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
