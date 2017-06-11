package com.example.sean.showpiecephotos.events;

import com.example.sean.showpiecephotos.model.Pojo.user.InstagramUser;

public class SelfUserEvent {

    private InstagramUser user;

    public SelfUserEvent(InstagramUser user) {
        this.user = user;
    }

    public InstagramUser getSelfUser() {
        return user;
    }
}
