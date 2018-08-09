package com.bank;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static String exchange(String url, HttpHeaders headers, String httpMethod, Map map) {
		RestTemplate restTemplate = new RestTemplate();
		String resultString = null;
		HttpEntity<?> entity = new HttpEntity<>(map, headers);
		try {
			ResponseEntity<?> result = restTemplate.exchange(url, getHttpMethodType(httpMethod.toUpperCase()), entity,
					String.class);
			System.out.println(result);
			if (result.getStatusCode().equals(HttpStatus.OK)) {
				resultString = (String) result.getBody();
			}
			System.out.println(resultString.toString());
		}
		catch (HttpClientErrorException e) {
			throw e;
		}
		return resultString;
	}

	private static HttpMethod getHttpMethodType(String httpMethodType) {
		switch (httpMethodType) {
			case "GET":
			return HttpMethod.GET;
			case "POST":
			return HttpMethod.POST;
			case "PUT":
			return HttpMethod.PUT;
			default:
			return HttpMethod.GET;
		}
	}

	public static String exchangeForPut(String url, Object object, String httpMethod) {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Accept", "application/json");
		ResponseEntity<String> response = null;
		HttpEntity<?> entity = new HttpEntity<>(object, headers);
		String resultString = null;
		try {
			response = restTemplate.exchange(url, getHttpMethodType(httpMethod.toUpperCase()), entity, String.class);
		}
		catch (HttpClientErrorException e) {
			throw e;
		}
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			resultString = (String) response.getBody();
		}
		System.out.println(resultString.toString());
		return resultString.toString();
	}
}
