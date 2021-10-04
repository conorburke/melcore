package com.github.conorburke.melcore.owners.utils;

import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;

@Component
public class UserContext {
    // public static final String CORRELATION_ID = "tmx-correlation-id";
    // public static final String AUTH_TOKEN     = "tmx-auth-token";
    // public static final String USER_ID        = "tmx-user-id";
    // public static final String OWNERANIZATION_ID = "tmx-organization-id";

    // private String correlationId= new String();
    // private String authToken= new String();
    // private String userId = new String();
    // private String organizationId = new String();

    // public String getCorrelationId() { 
    //     return correlationId;
    // }

    // public void setCorrelationId(String correlationId) {
    //     this.correlationId = correlationId;
    // }

    // public String getAuthToken() {
    //     return authToken;
    // }

    // public void setAuthToken(String authToken) {
    //     this.authToken = authToken;
    // }

    // public String getUserId() {
    //     return userId;
    // }

    // public void setUserId(String userId) {
    //     this.userId = userId;
    // }
	
    // public String getOrganizationId() {
	// 	return organizationId;
	// }
	
    // public void setOrganizationId(String organizationId) {
	// 	this.organizationId = organizationId;
	// }

    public static final String CORRELATION_ID = "tmx-correlation-id";
    public static final String AUTH_TOKEN     = "Authorization";
    public static final String USER_ID        = "tmx-user-id";
    public static final String OWNER_ID         = "tmx-owner-id";

    private static final ThreadLocal<String> correlationId= new ThreadLocal<String>();
    private static final ThreadLocal<String> authToken= new ThreadLocal<String>();
    private static final ThreadLocal<String> userId = new ThreadLocal<String>();
    private static final ThreadLocal<String> ownerId = new ThreadLocal<String>();


    public static String getCorrelationId() { return correlationId.get(); }
    public static void setCorrelationId(String cid) {correlationId.set(cid);}

    public static String getAuthToken() { return authToken.get(); }
    public static void setAuthToken(String aToken) {authToken.set(aToken);}

    public static String getUserId() { return userId.get(); }
    public static void setUserId(String aUser) {userId.set(aUser);}

    public static String getOwnerId() { return ownerId.get(); }
    public static void setOwnerId(String aOwner) {ownerId.set(aOwner);}

    public static HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CORRELATION_ID, getCorrelationId());

        return httpHeaders;
    }

}
