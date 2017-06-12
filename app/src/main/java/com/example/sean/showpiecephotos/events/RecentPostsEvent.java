package com.example.sean.showpiecephotos.events;

import com.example.sean.showpiecephotos.model.Pojo.recent.RecentPosts;

public class RecentPostsEvent {

    private RecentPosts post;

    public RecentPostsEvent(RecentPosts post) {
        this.post = post;
    }

    public RecentPosts getRecentPosts() {
        return post;
    }
}
