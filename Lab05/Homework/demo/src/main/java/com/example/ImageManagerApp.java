package com.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ImageManagerApp {
    public static void main(String[] args) {
        ImageRepository repository = new ImageRepository();

        List<String> tags1 = List.of("nature", "sunset");
        ImageItem image1 = new ImageItem("Sunset", LocalDate.now(), tags1, "D:/Facultate/AP/images/asd.png");
        repository.addImage(image1);

        List<String> tags2 = List.of("city", "night");
        ImageItem image2 = new ImageItem("City Night", LocalDate.now(), tags2, "D:/Facultate/AP/images/dsa.png");
        repository.addImage(image2);

        try {
            repository.displayImage("City Night");
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
