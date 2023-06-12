package com.github.viqbgrg.tvbox.service;

import com.github.viqbgrg.tvbox.model.Result;
import com.github.viqbgrg.tvbox.model.Site;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SiteVodService {
    private final SiteService siteService;
    private final HttpService httpService;

    private final Gson gson;

    public SiteVodService(SiteService siteService, HttpService httpService, Gson gson) {
        this.siteService = siteService;
        this.httpService = httpService;
        this.gson = gson;
    }

    public Result homeContent() {
        Site site = siteService.getSite();
        Map<String, String> params = new HashMap<>();
        params.put("filter", "true");
        try {
            String body = httpService.newCall(site.getApi(), params).execute().body().string();
            return gson.fromJson(body, Result.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
