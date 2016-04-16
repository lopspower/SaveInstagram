package com.androidbuts.saveinsta.model;

import java.util.List;

/**
 * Created by Mikhael LOPEZ on 12/01/16.
 */
public class InstaEntryData {

    private List<InstaPostPage> PostPage;

    public InstaEntryData() {
        super();
    }

    public InstaEntryData(List<InstaPostPage> postPage) {
        PostPage = postPage;
    }

    public List<InstaPostPage> getPostPage() {
        return PostPage;
    }
}
