package com.example.test;

import android.graphics.Bitmap;
import android.net.Uri;

class listingObjects {
    private String listingCreator;
    private String listingNum;
    private String itemName;
    private String itemCondition;
    private String itemDescription;
    private String contactInfo;
    private String img;
    private favoriteObjects favorites;

    public listingObjects() {

    }

    public listingObjects(String listingCreator, String itemName, String itemCondition, String itemDescription, String contactInfo, String img, favoriteObjects favorites) {
        this.listingCreator = listingCreator;
        this.itemName = itemName;
        this.itemCondition = itemCondition;
        this.itemDescription = itemDescription;
        this.contactInfo = contactInfo;
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

    public String getContactInfo() { return contactInfo; }

    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public favoriteObjects getFavorites() { return favorites; }

    public void setFavorites(favoriteObjects favorites) { this.favorites = favorites; }

}
