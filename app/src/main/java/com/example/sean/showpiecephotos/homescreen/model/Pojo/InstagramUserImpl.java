package com.example.sean.showpiecephotos.homescreen.model.Pojo;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class InstagramUserImpl implements InstagramUser {

    private static final String LOG_TAG = "InstagramUserImpl class";

    private String userName;
    private String fullName;
    private String bio;
    private String website;
    private String follows;
    private String followedBy;
    private String profilePicture;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public String getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(String followedBy) {
        this.followedBy = followedBy;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public static InstagramUserImpl fromJson(JSONObject jsonObject) {
        InstagramUserImpl instagramUser = new InstagramUserImpl();


        try {
            //todo : messy
            instagramUser.userName = jsonObject.getJSONObject("data").getString("username");
            instagramUser.fullName = jsonObject.getJSONObject("data").getString("full_name");
            instagramUser.bio = jsonObject.getJSONObject("data").getString("bio");
            instagramUser.website = jsonObject.getJSONObject("data").getString("website");
            instagramUser.followedBy = jsonObject.getJSONObject("data").getJSONObject("counts").getString("followed_by");
            instagramUser.follows = jsonObject.getJSONObject("data").getJSONObject("counts").getString("follows");
            instagramUser.profilePicture = jsonObject.getJSONObject("data").getString("profile_picture");
        }
        catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
        return instagramUser;
    }

}
