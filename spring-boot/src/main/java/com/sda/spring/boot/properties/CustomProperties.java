package com.sda.spring.boot.properties;

public class CustomProperties {

    private String appOwner;
    private String releaseVersion;

    public void setAppOwner(String appOwner) {
        this.appOwner = appOwner;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    @Override
    public String toString() {
        return "CustomProperties{" +
                "appOwner='" + appOwner + '\'' +
                ", releaseVersion='" + releaseVersion + '\'' +
                '}';
    }
}
