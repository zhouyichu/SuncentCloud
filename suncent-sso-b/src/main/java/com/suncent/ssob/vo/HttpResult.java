/**  
* <p>Title: HttpResult.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月2日  
* @version 1.0  
*/  
package com.suncent.ssob.vo;

/**  
 * <p>Title: HttpResult</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月2日 下午5:28:07
 */
public class HttpResult {
	private int code;
	private String body;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public HttpResult(int code, String body) {
		super();
		this.code = code;
		this.body = body;
	}
	public HttpResult() {
		super();
	}
}