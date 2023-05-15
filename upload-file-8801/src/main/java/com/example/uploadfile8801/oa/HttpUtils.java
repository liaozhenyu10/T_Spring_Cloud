package com.example.uploadfile8801.oa;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * HttpUtils 工具类
 * @author PENGZQ
 * @since 2020-12-21
 *
 */
public class HttpUtils {
	
	private static final Log log = LogFactory.getLog(HttpUtils.class);
    
    
    public static String sendHttpGet(String httpUrl) {
    	HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求 
        CloseableHttpClient httpClient = null;  
        CloseableHttpResponse response = null;  
        HttpEntity entity = null;  
        String responseContent = null;  
        try {  
            // 创建默认的httpClient实例.  
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()  
                    .setSocketTimeout(15000)  
                    .setConnectTimeout(15000)  
                    .setConnectionRequestTimeout(15000)  
                    .build(); 
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
            // 执行请求  
            response = httpClient.execute(httpGet);  
            entity = response.getEntity();  
            responseContent = EntityUtils.toString(entity, "UTF-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                // 关闭连接,释放资源  
                if (response != null) {  
                    response.close();  
                }  
                if (httpClient != null) {  
                    httpClient.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return responseContent;  
    } 
    
    public static String upload(String url, Map<String, List<FileInfo>> fileMap, Map<String, String> paramMap) {
    	
    	
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	String result = "";
    	HttpEntity httpEntity = null;
    	HttpEntity responseEntity = null;
    	CloseableHttpResponse httpResponse = null;
    	
    	try {
    		
    		HttpPost httpPost = new HttpPost(url);
        	MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        	multipartEntityBuilder.setCharset(Charset.forName("utf-8"));
        	multipartEntityBuilder.setMode(HttpMultipartMode.RFC6532);	//加上这行代码解决返回中文乱码问题
        	
        	//文件参数
        	if (fileMap != null) {
        		Iterator entries = fileMap.entrySet().iterator();
            	while (entries.hasNext()) {
            		Map.Entry<String, List<FileInfo>> entry = (Map.Entry<String, List<FileInfo>>) entries.next();
            		String key = entry.getKey();
            		List<FileInfo> fileInfoList = entry.getValue();

            		int count = 0;
            		for (FileInfo fileInfo : fileInfoList) {
            			multipartEntityBuilder.addBinaryBody(key+"["+count+"]", new File(fileInfo.getFilePath()), ContentType.MULTIPART_FORM_DATA, fileInfo.getFileName());
						count ++;
            		}
            	}
        	}
        	ContentType contentType = ContentType.create("text/plain",Charset.forName("UTF-8"));
        	//普通参数
        	if (paramMap != null) {
        		Iterator entries = paramMap.entrySet().iterator();
        		while (entries.hasNext()) {
            		Map.Entry<String, String> entry = (Map.Entry<String, String>) entries.next();
            		String key = entry.getKey();
            		multipartEntityBuilder.addTextBody(entry.getKey(), entry.getValue(), contentType);
            	}
        	}
        	
        	httpEntity = multipartEntityBuilder.build();
        	httpPost.setEntity(httpEntity);
        	httpResponse = httpClient.execute(httpPost);
        	responseEntity = httpResponse.getEntity();
        	
        	if (responseEntity != null) {
        		//将响应内容转字符串
        		result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
        	}
    		
    	} catch (Exception e) {
    		e.printStackTrace(); 
    	} finally {
    		try {  
                // 关闭连接,释放资源  
                if (httpResponse != null) {  
                	httpResponse.close();  
                }  
                if (httpClient != null) {  
                    httpClient.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }
    	}
    	
    	return result;
    }
    
    public static class FileInfo {
    	private String filePath;
    	private String fileName;
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		
    }
    

}
