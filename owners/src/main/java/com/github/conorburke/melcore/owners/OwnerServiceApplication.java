package com.github.conorburke.melcore.owners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import java.util.Collections;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import com.github.conorburke.melcore.owners.utils.UserContextInterceptor;
import org.springframework.http.client.ClientHttpRequestInterceptor;

@SpringBootApplication
@RefreshScope
@EnableResourceServer
@EnableBinding(Source.class)
public class OwnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnerServiceApplication.class, args);
	}

	// may be outdated. reference 'on service discovery'
	@SuppressWarnings("unchecked")
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        if (interceptors==null){
            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        }
        else{
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        }

        return template;
	}

}
