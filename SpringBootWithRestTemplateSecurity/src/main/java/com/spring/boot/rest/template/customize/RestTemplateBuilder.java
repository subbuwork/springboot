package com.spring.boot.rest.template.customize;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author subbu
 *
 */
public class RestTemplateBuilder {
	static Logger logger = LoggerFactory.getLogger(RestTemplateBuilder.class);
	
	public static RestTemplate securityRestTemplateBuilder(String userName,String password){
		HttpClient httpClient = createHttpClient(userName,password);	
		
		ClientHttpRequestFactory clientHttpRequestFactory = createRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		return restTemplate;
	}

	private static ClientHttpRequestFactory createRequestFactory(HttpClient httpClient) {
		logger.info(".....In side createRequestFactory()...");
     HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new  HttpComponentsClientHttpRequestFactory();
     httpComponentsClientHttpRequestFactory.setHttpClient(httpClient);
		return httpComponentsClientHttpRequestFactory;
	}

	private static HttpClient createHttpClient(String userName, String password) {
       logger.info("In side createHttpClient(");
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		UsernamePasswordCredentials usernamePasswordCredentials = new UsernamePasswordCredentials(userName,password);
		credentialsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);
		HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();
		return httpClient;
	}

}
