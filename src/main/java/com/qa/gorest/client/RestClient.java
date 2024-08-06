package com.qa.gorest.client;

import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	private static RequestSpecBuilder reqspecbuilder;
	private static final String BASE_URI = "https://www.gorest.co.in";
	private static final String BEARER_TOKEN = "";
	static {

		reqspecbuilder = new RequestSpecBuilder();
	}

	/**
	 * This method will add the authorization
	 */
	public void addAuthorization() {
		reqspecbuilder.addHeader("Authorization", "Bearer " + BEARER_TOKEN);
	}

	// Request Specifications
	/**
	 * Request Specification with base uri and authorization
	 * 
	 * @return
	 */

	public RequestSpecification createRequestSpec() {

		reqspecbuilder.setBaseUri(BASE_URI);
		addAuthorization();
		return reqspecbuilder.build();

	}

	/**
	 * This is a request specification with base uri and headersmap
	 * 
	 * @param headersMap
	 * @return RequestSpecification
	 */
	public RequestSpecification createRequestSpec(Map<String, String> headersMap) {

		reqspecbuilder.setBaseUri(BASE_URI);
		addAuthorization();
		if (headersMap != null) {
			reqspecbuilder.addHeaders(headersMap);
		}
		return reqspecbuilder.build();

	}

	/**
	 * This is a request specification which adds below parameters to the request
	 * @param headersMap
	 * @param queryParamsMap
	 * @return RequestSpecification
	 */
	
	public RequestSpecification createReqSpec(Map<String,String> headersMap,Map<String,Object>queryParamsMap) {
		reqspecbuilder.setBaseUri(BASE_URI);
		addAuthorization();
		if(headersMap!=null) {
			reqspecbuilder.addHeaders(headersMap);
		}
		
		if(queryParamsMap!=null) {
			reqspecbuilder.addQueryParams(queryParamsMap);
		}
		return reqspecbuilder.build();
	}
}
