package com.github.viqbgrg.tvbox.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class HttpService {

    private final OkHttpClient client;

    public HttpService(OkHttpClient client) {
        this.client = client;
    }


    public Call newCall(String url) {
        return client.newCall(new Request.Builder().url(url).build());
    }

    public Call newCall(OkHttpClient client, String url) {
        return client.newCall(new Request.Builder().url(url).build());
    }

    public Call newCall(String url, Headers headers) {
        return client.newCall(new Request.Builder().url(url).headers(headers).build());
    }

    public Call newCall(String url, Map<String, String> params) {
        return client.newCall(new Request.Builder().url(buildUrl(url, params)).build());
    }

    public Call newCall(OkHttpClient client, String url, Map<String, String> params) {
        return client.newCall(new Request.Builder().url(buildUrl(url, params)).build());
    }

    public Call newCall(OkHttpClient client, String url, RequestBody body) {
        return client.newCall(new Request.Builder().url(url).post(body).build());
    }

    private HttpUrl buildUrl(String url, Map<String, String> params) {
        HttpUrl.Builder builder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        for (Map.Entry<String, String> entry : params.entrySet())
            builder.addQueryParameter(entry.getKey(), entry.getValue());
        return builder.build();
    }


}
