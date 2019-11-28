package com.example.test;

import android.graphics.Bitmap;
import android.net.Uri;

class listingObjects {
    private String listingCreator;
    private String listingNum;
    private String itemName;
    private String itemCondition;
    private String itemDescription;
    private String emailInfo;
    private String phoneNumber;
    private String img;
    private favoriteObjects favorites;

    public listingObjects() {

    }

    public listingObjects(String listingCreator, String itemName, String itemCondition, String itemDescription, String emailInfo, String phoneNumber ,String img, favoriteObjects favorites) {
        this.listingCreator = listingCreator;
        this.itemName = itemName;
        this.itemCondition = itemCondition;
        this.itemDescription = itemDescription;
        this.emailInfo = emailInfo;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.favorites = favorites;
    }

    public String getListingCreator() { return listingCreator; }

    public void setListingCreator(String listingCreator) { this.listingCreator = listingCreator; }

    public String getListingNum() { return listingNum; }

    public void setLlistingNum(String listingNum) { this.listingNum = listingNum; }

    public String getItemName() { return itemName; }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemCondition() { return itemCondition; }

    public void setItemCondition(String itemCondition) { this.itemCondition = itemCondition; }

    public String getItemDescription() { return itemDescription; }

    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public String getEmailInfo() { return emailInfo; }

    public void setEmailInfo(String emailInfo) { this.emailInfo = emailInfo; }

    public String getPhoneNumberInfo() { return phoneNumber; }

    public void setPhoneNumberInfo(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public favoriteObjects getFavorites() { return favorites; }

    public void setFavorites(favoriteObjects favorites) { this.favorites = favorites; }

}
