package com.jobportal.studentservice.config;

import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GlobalServerInterceptorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class GlobalInterceptorConfiguration {
    @Bean
    public GlobalServerInterceptorConfigurer globalInterceptorConfigurerAdapter() {
        return new GlobalServerInterceptorConfigurer() {
            @Override
            public void configureServerInterceptors(List<ServerInterceptor> interceptors) {
                interceptors.add(new LogGrpcInterceptor());
            }
        };
    }
}