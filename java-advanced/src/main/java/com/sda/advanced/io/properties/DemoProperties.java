package com.sda.advanced.io.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoProperties {

    public static void main(String[] args) throws IOException {
        String appConfigPath = "C:\\dev\\sda\\sda\\java-advanced\\src\\main\\resources\\app.properties";
        String catalogConfigPath = "C:\\dev\\sda\\sda\\java-advanced\\src\\main\\resources\\catalog";
        String iconConfigPath = "C:\\dev\\sda\\sda\\java-advanced\\src\\main\\resources\\icons.xml";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        Properties catalogProps = new Properties();
        catalogProps.load(new FileInputStream(catalogConfigPath));

        Properties iconProps = new Properties();
        iconProps.loadFromXML(new FileInputStream(iconConfigPath));

        String appVersion = appProps.getProperty("version");
        System.out.println(appVersion);

        System.out.println(catalogProps.getProperty("c1"));

        System.out.println(iconProps.getProperty("fileIcon"));
    }

}
