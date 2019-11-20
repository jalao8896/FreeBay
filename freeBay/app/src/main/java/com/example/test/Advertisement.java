package com.example.test;


public class Advertisement {
    private String itemCondition;
    private String contactInfo;
    private String Ad_Title;
    private String Ad_Body;
    private int Thumbnail;


    public Advertisement(){
    }

    public Advertisement(String ad_Title, String itemCondition, String ad_Body, int thumbnail) {

        Ad_Title = ad_Title;
        itemCondition = itemCondition;
        Ad_Body = ad_Body;
        Thumbnail = thumbnail;
    }

    public String getAd_Title() {
        return Ad_Title;
    }

    public String getItemCondition() {
        return itemCondition;
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

    public void setCategory(String itemCondition) {
        this.itemCondition = itemCondition;
    }

    public void setAd_Body(String ad_Body) {
        Ad_Body = ad_Body;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
