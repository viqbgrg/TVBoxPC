package com.github.viqbgrg.tvbox.service;

import com.github.viqbgrg.tvbox.model.Site;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SiteService {
    @Value("${vod.api}")
    private String api;

    public Site getSite() {
        Site site = new Site();
        site.setApi(api);
        return site;
    }
}
