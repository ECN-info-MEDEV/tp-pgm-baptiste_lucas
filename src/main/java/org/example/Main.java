package org.example;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Image image = new Image();
        image.Read("C:\\Users\\bapti\\Downloads\\ImagesTestPGM\\ImagesTestPGM\\brain.pgm");
        System.out.println(image.image[0][1]);
        image.Write("C:\\Users\\bapti\\Downloads\\ImagesTestPGM\\ImagesTestPGM\\a.pgm");
    }
}
