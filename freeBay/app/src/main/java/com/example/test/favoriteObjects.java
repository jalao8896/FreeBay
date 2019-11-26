package com.example.test;

public class favoriteObjects {
    private String userID;
    private boolean isFavorite;

    public favoriteObjects() {

    }

    public favoriteObjects(String userID) {
        this.userID = userID;
    }

    public favoriteObjects(String userID, boolean isFavorite) {
        this.userID = userID;
        this.isFavorite = isFavorite;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
