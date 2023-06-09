package com.github.viqbgrg.tvbox.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class Vod {

    @SerializedName("vod_id")
    private String vodId;

    @SerializedName("vod_name")
    private String vodName;

    @SerializedName("type_name")
    private String typeName;

    @SerializedName("vod_pic")
    private String vodPic;

    @SerializedName("vod_remarks")
    private String vodRemarks;

    @SerializedName("vod_year")
    private String vodYear;

    @SerializedName("vod_area")
    private String vodArea;

    @SerializedName("vod_director")
    private String vodDirector;

    @SerializedName("vod_actor")
    private String vodActor;

    @SerializedName("vod_content")
    private String vodContent;

    @SerializedName("vod_play_from")
    private String vodPlayFrom;

    @SerializedName("vod_play_url")
    private String vodPlayUrl;

    @SerializedName("vod_tag")
    private String vodTag;


    private Site site;

    @Data
    public static class Flag {

        @SerializedName("flag")
        private String flag;
        private String show;

        private String urls;

        @SerializedName("episodes")
        private List<Episode> episodes;

        private boolean activated;

        public Flag() {
            this.episodes = new ArrayList<>();
        }


        //public void createEpisode(String data) {
        //    String[] urls = data.contains("#") ? data.split("#") : new String[]{data};
        //    for (int i = 0; i < urls.length; i++) {
        //        String[] split = urls[i].split("\\$");
        //        String number = String.format(Locale.getDefault(), "%02d", i + 1);
        //        Episode episode = split.length > 1 ? new Episode(split[0].isEmpty() ? number : split[0].trim(), split[1]) : new Episode(number, urls[i]);
        //        if (!getEpisodes().contains(episode)) getEpisodes().add(episode);
        //    }
        //}

        @Data
        public static class Episode {

            @SerializedName("name")
            private String name;
            @SerializedName("url")
            private String url;

            private int number;

            private boolean activated;

        }
    }
}
