package com.example.sean.showpiecephotos.events;

import com.example.sean.showpiecephotos.model.Pojo.recentPosts.InstagramPost;

import java.util.List;

public class RecentPostsEvent {

    private InstagramPost post;

    public RecentPostsEvent(InstagramPost post) {
        this.post = post;
    }

    public InstagramPost getRecentPosts() {
        return post;
    }
}
