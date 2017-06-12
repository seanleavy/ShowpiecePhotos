package com.example.sean.showpiecephotos.events;

import com.example.sean.showpiecephotos.model.Pojo.self.Self;

public class SelfUserEvent {

    private Self user;

    public SelfUserEvent(Self user) {
        this.user = user;
    }

    public Self getSelfUser() {
        return user;
    }
}
