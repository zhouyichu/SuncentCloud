/**  
* <p>Title: IdleConnectionEvictor.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月2日  
* @version 1.0  
*/  
package com.suncent.ssob.common;

import org.apache.http.conn.HttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**  
 * <p>Title: IdleConnectionEvictor</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月2日 下午5:32:57
 */
@Component
public class IdleConnectionEvictor extends Thread{
	@Autowired
	private HttpClientConnectionManager connMgr;
	
	private volatile boolean shutdown;
	
	public IdleConnectionEvictor() {
		super();
		super.start();
	}
 
	@Override
	public void run() {
		try {
			while (!shutdown) {
				synchronized (this) {
					wait(5000);
					// 关闭失效的连接
					connMgr.closeExpiredConnections();
				}
			}
		} catch (InterruptedException ex) {
		// 结束
		}
	}
	
	//关闭清理无效连接的线程
	public void shutdown() {
		shutdown = true;
		synchronized (this) {
			notifyAll();
		}
	}
}