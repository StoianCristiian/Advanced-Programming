package com.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

record ImageItem(String name, LocalDate date, List<String> tags, String location) {}

class ImageRepository {
    private final List<ImageItem> images = new ArrayList<>();

    public void addImage(ImageItem image) {
        images.add(image);
    }

    public void displayImage(String imageName) throws IOException {
        for (ImageItem image : images) {
            if (image.name().equals(imageName)) {
                File file = new File(image.location());
                if (!file.exists()) {
                    throw new IOException("File not found: " + image.location());
                }
                Desktop.getDesktop().open(file);
                return;
            }
        }
        throw new IllegalArgumentException("Image not found in repository: " + imageName);
    }
}