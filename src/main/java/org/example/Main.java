package org.example;

public class Main {
    public static void main(String[] args) {
        Image image = new Image();
        Image image1 = new Image();
        image.Read("C:\\Users\\bapti\\Downloads\\ImagesTestPGM\\ImagesTestPGM\\brain.pgm");
        image.Seuillage(100);
        image.Write("C:\\Users\\bapti\\Downloads\\ImagesTestPGM\\ImagesTestPGM\\a.pgm");
        image1.Read("C:\\Users\\bapti\\Downloads\\ImagesTestPGM\\ImagesTestPGM\\brain.pgm");
        Image diff = image.Diff(image1);
        diff.Write("C:\\Users\\bapti\\Downloads\\ImagesTestPGM\\ImagesTestPGM\\b.pgm");
    }
}