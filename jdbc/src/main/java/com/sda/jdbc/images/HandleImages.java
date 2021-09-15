package com.sda.jdbc.images;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class HandleImages {

    // TODO: extract to a property file
    String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    public void uploadImage(String sourcePath) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                // INSERT
                PreparedStatement statement = connection.prepareStatement("INSERT into images values(?,?)");
                statement.setString(1, "geek-image");

                Path pathToImage = Paths.get(sourcePath);
                InputStream fin = Files.newInputStream(pathToImage);
                statement.setBinaryStream(2, fin, fin.available());
                int i = statement.executeUpdate();
                System.out.println(i + " records affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadImage(String destinationPath) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM images");

                Path pathToImage = Paths.get(destinationPath);
                OutputStream fos = Files.newOutputStream(pathToImage);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    // 2 means 2nd column data
                    Blob blob = rs.getBlob(2);
                    // 1 means first image
                    byte[] content = blob.getBytes(1, (int) blob.length());
                    fos.write(content);
                    fos.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
