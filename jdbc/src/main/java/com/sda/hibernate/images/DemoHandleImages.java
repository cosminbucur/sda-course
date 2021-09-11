package com.bucur.images;

public class DemoHandleImages {

    public static void main(String[] args) {
        HandleImages preparedStatements = new HandleImages();
        preparedStatements.uploadImage("jdbc\\src\\main\\resources\\save-me.png");
        preparedStatements.downloadImage("jdbc\\src\\main\\resources\\image-from-db.png");
    }
}
