package com.saife.dashboard.client.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface SaifeEndpoint {

	public String endpoint();
	public HttpMethod method() default HttpMethod.GET;
	
}
