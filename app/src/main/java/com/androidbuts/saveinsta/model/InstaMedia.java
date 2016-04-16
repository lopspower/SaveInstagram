package com.androidbuts.saveinsta.model;

/**
 * Created by Mikhael LOPEZ on 12/01/16.
 */
public class InstaMedia {

    private String id;
    private boolean is_video;
    private String video_url;
    private InstaOwner owner;

    public InstaMedia() {
        super();
    }

    public InstaMedia(String id, boolean is_video, String video_url, InstaOwner owner) {
        this.id = id;
        this.is_video = is_video;
        this.video_url = video_url;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public boolean isVideo() {
        return is_video;
    }

    public String getVideoUrl() {
        return video_url;
    }

    public InstaOwner getOwner() {
        return owner;
    }
}
