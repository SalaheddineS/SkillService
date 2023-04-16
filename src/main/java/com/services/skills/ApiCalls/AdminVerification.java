package com.services.skills.ApiCalls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminVerification {
        @Value("${authenticationms.uri}")
        private String authenticationmsUrl;

       public boolean verifyAdmin(String token) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("token", token);
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<String> response = restTemplate.exchange(authenticationmsUrl , HttpMethod.POST, entity, String.class);
            return response.getBody().equals("true");
        }
}
