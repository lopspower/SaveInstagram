package com.mikhaellopez.saveinsta.model;

/** Created by Pratik Butani
 */
public class EventInstaPictureLoad {

    private String userName;
    private String userFullName;
    private String urlImage;
    private String urlIconProfil;
    private String idContent;
    private boolean isVideo;
    private String urlVideo;
    private boolean loadWell = true;

    public EventInstaPictureLoad(String userName, String userFullName, String urlImage, String urlIconProfil, String idContent, boolean isVideo, String urlVideo) {
        this.userName = userName;
        this.userFullName = userFullName;
        this.urlImage = urlImage;
        this.urlIconProfil = urlIconProfil;
        this.idContent = idContent;
        this.isVideo = isVideo;
        this.urlVideo = urlVideo;
    }

    public EventInstaPictureLoad() {
        this.loadWell = false;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getUrlIconProfil() {
        return urlIconProfil;
    }

    public String getIdContent() {
        return idContent;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public boolean isLoadWell() {
        return loadWell;
    }
}
