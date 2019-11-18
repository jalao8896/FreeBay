package com.example.test;

import android.graphics.Bitmap;
import android.net.Uri;

class listingObjects {
    private String itemName;
    private String itemCondition;
    private String itemDescription;
    private String contactInfo;
    private String img;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemNameText) {
        itemName = itemNameText;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(String itemConditionText) {
        itemCondition = itemConditionText;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescriptionText) {
        itemDescription = itemDescriptionText;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfoText) {
        contactInfo = contactInfoText;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String ImgFile) {
        img = ImgFile;
    }

    public listingObjects() {

    }

    public listingObjects(String itemNameText, String itemConditionText, String itemDescriptionText, String contactInfoText, String ImgFile) {
        itemName = itemNameText;
        itemCondition = itemConditionText;
        itemDescription = itemDescriptionText;
        contactInfo = contactInfoText;
        img = ImgFile;
    }
}
