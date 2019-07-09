/**
  * Copyright 2019 bejson.com 
  */
package com.code.domain.vo;

import lombok.Data;

import java.util.List;
@Data
public class ZhiHuHotVO {


    private String fresh_text;
    private Paging paging;
    private List<Data> data;


    @lombok.Data
    public static class Data {

        private String style_type;
        private String detail_text;
        private Target target;
        private int trend;
        private boolean debut;
        private String card_id;
        private List<Children> children;
        private String attached_info;
        private String type;
        private String id;

    }

    @lombok.Data
    public static class Paging {

        private boolean is_end;
        private String previous;
        private String next;
    }



    @lombok.Data
    public static class Author {

        private String headline;
        private String avatar_url;
        private String name;
        private String url;
        private String url_token;
        private String type;
        private String user_type;
        private String id;


    }


    @lombok.Data
    public static class Children {

        private String type;
        private String thumbnail;
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
        public String getThumbnail() {
            return thumbnail;
        }

    }



    @lombok.Data
    public static class Target {

        private List<Integer> bound_topic_ids;
        private String excerpt;
        private int answer_count;
        private boolean is_following;
        private long id;
        private Author author;
        private String url;
        private String title;
        private long created;
        private int comment_count;
        private long follower_count;
        private String type;


    }

}