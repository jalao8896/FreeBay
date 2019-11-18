package com.example.test;


public class Advertisement {

    private String Ad_Title;
    private String Category;
    private String Ad_Body;
    private int Thumbnail;

    public Advertisement(){
    }

    public Advertisement(String ad_Title, String ad_Category, String ad_Body, int thumbnail) {
        Ad_Title = ad_Title;
        Category = ad_Category;
        Ad_Body = ad_Body;
        Thumbnail = thumbnail;
    }

    public String getAd_Title() {
        return Ad_Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getAd_Body() {
        return Ad_Body;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setAd_Title(String ad_Title) {
        Ad_Title = ad_Title;
    }

    public void setCategory(String ad_Category) {
        Category = ad_Category;
    }

    public void setAd_Body(String ad_Body) {
        Ad_Body = ad_Body;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
