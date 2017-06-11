package com.example.sean.showpiecephotos.model.Pojo.user.nested;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "media",
        "follows",
        "followed_by"
})
public class Counts {

    @JsonProperty("media")
    private Integer media;
    @JsonProperty("follows")
    private Integer follows;
    @JsonProperty("followed_by")
    private Integer followedBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("media")
    public Integer getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(Integer media) {
        this.media = media;
    }

    @JsonProperty("follows")
    public Integer getFollows() {
        return follows;
    }

    @JsonProperty("follows")
    public void setFollows(Integer follows) {
        this.follows = follows;
    }

    @JsonProperty("followed_by")
    public Integer getFollowedBy() {
        return followedBy;
    }

    @JsonProperty("followed_by")
    public void setFollowedBy(Integer followedBy) {
        this.followedBy = followedBy;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

