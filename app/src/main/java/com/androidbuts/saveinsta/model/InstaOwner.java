package com.androidbuts.saveinsta.model;

/**
 * Created by Mikhael LOPEZ on 12/01/16.
 */
public class InstaOwner {

    private String id;
    private String username;
    private String entry_data;
    private String profile_pic_url;
    private String full_name;

    public InstaOwner() {
        super();
    }

    public InstaOwner(String id, String username, String entry_data, String profile_pic_url, String full_name) {
        this.id = id;
        this.username = username;
        this.entry_data = entry_data;
        this.profile_pic_url = profile_pic_url;
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEntry_data() {
        return entry_data;
    }

    public String getProfilePicUrl() {
        return profile_pic_url;
    }

    public String getFullname() {
        return full_name;
    }
}
