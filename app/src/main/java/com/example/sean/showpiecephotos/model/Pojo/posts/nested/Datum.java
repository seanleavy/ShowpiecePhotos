package com.example.sean.showpiecephotos.model.Pojo.posts.nested;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.Caption;
import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.Comments;
import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.Images;
import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.Likes;
import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.User;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "user",
        "images",
        "created_time",
        "caption",
        "user_has_liked",
        "likes",
        "tags",
        "filter",
        "comments",
        "type",
        "link",
        "location",
        "attribution",
        "users_in_photo"
})
public class Datum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("user")
    private User user;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("caption")
    private Caption caption;
    @JsonProperty("user_has_liked")
    private Boolean userHasLiked;
    @JsonProperty("likes")
    private Likes likes;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("filter")
    private String filter;
    @JsonProperty("comments")
    private Comments comments;
    @JsonProperty("type")
    private String type;
    @JsonProperty("link")
    private String link;
    @JsonProperty("location")
    private Object location;
    @JsonProperty("attribution")
    private Object attribution;
    @JsonProperty("users_in_photo")
    private List<Object> usersInPhoto = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("caption")
    public Caption getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    @JsonProperty("user_has_liked")
    public Boolean getUserHasLiked() {
        return userHasLiked;
    }

    @JsonProperty("user_has_liked")
    public void setUserHasLiked(Boolean userHasLiked) {
        this.userHasLiked = userHasLiked;
    }

    @JsonProperty("likes")
    public Likes getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    @JsonProperty("comments")
    public Comments getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(Comments comments) {
        this.comments = comments;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("location")
    public Object getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Object location) {
        this.location = location;
    }

    @JsonProperty("attribution")
    public Object getAttribution() {
        return attribution;
    }

    @JsonProperty("attribution")
    public void setAttribution(Object attribution) {
        this.attribution = attribution;
    }

    @JsonProperty("users_in_photo")
    public List<Object> getUsersInPhoto() {
        return usersInPhoto;
    }

    @JsonProperty("users_in_photo")
    public void setUsersInPhoto(List<Object> usersInPhoto) {
        this.usersInPhoto = usersInPhoto;
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
