/**  
* <p>Title: HttpAPI.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月2日  
* @version 1.0  
*/  
package com.suncent.ssob.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.suncent.ssob.vo.HttpResult;

/**  
 * <p>Title: HttpAPI</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月2日 下午5:22:04
 */
@Component
public class HttpAPI {
	private CloseableHttpClient httpClient;
	@Autowired
	private RequestConfig config;
	
	@Bean
	public CloseableHttpClient gethttpClient() {
		if(httpClient != null) {
			return httpClient;
		}else {
			return HttpClients.createDefault();
		}
	}
	/**
	 * 	不带参数，直接Get
	 * @param url
	 * @return 状态码为200返回body，否则返回null
	 * @throws Exception
	 */
    public String doGet(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);
        CloseableHttpResponse response = gethttpClient().execute(httpGet);
        // 判断状态码是否为200
        if (response.getStatusLine().getStatusCode() == 200) {
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }
        return null;
    }

    /**
     * 	带参Get
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
        return this.doGet(uriBuilder.build().toString());
    }
    
    /**
     * 	带参post
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url, Map<String, Object> map) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(config);
        if (map != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
        }
        CloseableHttpResponse response = gethttpClient().execute(httpPost);
        int code = response.getStatusLine().getStatusCode();
        String body = EntityUtils.toString(response.getEntity(), "UTF-8");
        return new HttpResult(code, body);
    }
    
    /**
     * 	不带参post
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url) throws Exception {
        return this.doPost(url, null);
    }
}