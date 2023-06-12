package com.github.viqbgrg.tvbox.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static com.github.viqbgrg.tvbox.Constant.TIMEOUT_HTTP;

@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient.Builder().connectTimeout(TIMEOUT_HTTP, TimeUnit.MILLISECONDS).build();
    }

}
