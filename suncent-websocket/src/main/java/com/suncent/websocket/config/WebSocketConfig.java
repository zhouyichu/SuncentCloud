/**  
* <p>Title: WebSocketConfig.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月12日  
* @version 1.0  
*/  
package com.suncent.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**  
 * <p>Title: WebSocketConfig</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月12日 下午4:33:14
 */
@Configuration
public class WebSocketConfig {

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
