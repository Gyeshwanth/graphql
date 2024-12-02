package com.yeshwanth.graphqlclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphqlConfig {


    @Bean
    public HttpGraphQlClient httpGraphQlClient() {

        WebClient webClient = WebClient.builder().baseUrl("http://localhost:2611/graphql").build();

        return HttpGraphQlClient.builder(webClient).build();
    }

}
