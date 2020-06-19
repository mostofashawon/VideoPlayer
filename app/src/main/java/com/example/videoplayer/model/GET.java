
package com.example.videoplayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GET {

    private String srl;

    private String title;

    private String subcategory;

    private String preview;

    private String contentpath;


    public GET() {
    }


    public GET(String srl, String title, String subcategory, String preview, String contentpath) {
        super();
        this.srl = srl;
        this.title = title;
        this.subcategory = subcategory;
        this.preview = preview;
        this.contentpath = contentpath;
    }

    public String getSrl() {
        return srl;
    }

    public void setSrl(String srl) {
        this.srl = srl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getContentpath() {
        return contentpath;
    }

    public void setContentpath(String contentpath) {
        this.contentpath = contentpath;
    }

}
