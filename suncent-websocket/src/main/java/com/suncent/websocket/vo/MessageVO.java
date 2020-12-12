/**  
* <p>Title: MessageVO.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月12日  
* @version 1.0  
*/  
package com.suncent.websocket.vo;

import com.alibaba.fastjson.JSON;

/**  
 * <p>Title: MessageVO</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月12日 下午4:43:21
 */
public class MessageVO {
	public static final String ENTER = "ENTER";
	public static final String SPEAK = "SPEAK";
	public static final String QUIT = "QUIT";
	
	private String type;
	private String userName;
	private String msg;
	private int onlineCount;
	
	public static String jsonStr(String type,String userName,String msg,int onlineTotal) {
		return JSON.toJSONString(new MessageVO(type, userName, msg, onlineTotal));
	}

	public MessageVO(String type, String userName, String msg, int onlineCount) {
		super();
		this.type = type;
		this.userName = userName;
		this.msg = msg;
		this.onlineCount = onlineCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getOnlineCount() {
		return onlineCount;
	}

	public void setOnlineCount(int onlineCount) {
		this.onlineCount = onlineCount;
	}
	
}
