package com.androidbuts.saveinsta.model;

/**
 * Created by Mikhael LOPEZ on 12/01/16.
 */
public class InstaPostPage {

    private InstaMedia media;

    public InstaPostPage() {
        super();
    }

    public InstaPostPage(InstaMedia media) {
        this.media = media;
    }

    public InstaMedia getMedia() {
        return media;
    }
}
