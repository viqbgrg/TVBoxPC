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

    public Result categoryContent(String tid, String page) {
        Site site = siteService.getSite();
        Map<String, String> params = new HashMap<>();
        //params.put("ext", Utils.getBase64(App.gson().toJson(extend)));
        params.put("ac", "detail");
        params.put("t", tid);
        params.put("pg", page);
        String body = null;
        try {
            body = httpService.newCall(site.getApi(), params).execute().body().string();
            return gson.fromJson(body, Result.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Result detailContent(String key, String id) {
        Site site = siteService.getSite();
        Map<String, String> params = new HashMap<>();
        params.put("ac", "detail");
        params.put("ids", id);
        try {
            String body = httpService.newCall(site.getApi(), params).execute().body().string();
            return gson.fromJson(body, Result.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Result playerContent(String key, String flag, String id) {
        Site site = siteService.getSite();
        Map<String, String> params = new HashMap<>();
        params.put("play", id);
        params.put("flag", flag);
        try {
            String body = httpService.newCall(site.getApi(), params).execute().body().string();
            return gson.fromJson(body, Result.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchContent(Site site, String keyword) throws Throwable {
        Map<String, String> params = new HashMap<>();
        params.put("wd", keyword);
        if (site.getType() != 0) {
            params.put("ac", "detail");
        }
        String body = httpService.newCall(site.getApi(), params).execute().body().string();
        //Result result = Result.fromJson(body);
        //post(site, fetchPic(site, result));
    }
}
