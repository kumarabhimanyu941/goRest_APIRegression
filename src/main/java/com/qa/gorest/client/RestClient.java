package com.qa.gorest.client;

import java.util.Map;

import com.qa.gorest.utils.APIFrameworkException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
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

	public void setContentType(String contenttype) {

		switch (contenttype.toLowerCase()) {

		case "json":
			reqspecbuilder.setContentType(ContentType.JSON);
			break;

		case "xml":
			reqspecbuilder.setContentType(ContentType.XML);
			break;

		case "urlencoded":
			reqspecbuilder.setContentType(ContentType.URLENC);
			break;

		case "multipart":
			reqspecbuilder.setContentType(ContentType.MULTIPART);
			break;

		default:
			System.out.println("Please pass correct content type");
			throw new APIFrameworkException("INVALIDCONTENTTYPE");
		}
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
	 * 
	 * @param headersMap
	 * @param queryParamsMap
	 * @return RequestSpecification
	 */

	public RequestSpecification createReqSpec(Map<String, String> headersMap, Map<String, Object> queryParamsMap) {
		reqspecbuilder.setBaseUri(BASE_URI);
		addAuthorization();
		if (headersMap != null) {
			reqspecbuilder.addHeaders(headersMap);
		}

		if (queryParamsMap != null) {
			reqspecbuilder.addQueryParams(queryParamsMap);
		}
		return reqspecbuilder.build();
	}
}
