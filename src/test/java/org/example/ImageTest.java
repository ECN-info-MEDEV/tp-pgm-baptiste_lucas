package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    @Test
    void Test(){
        Image image = new Image();
        image.Read("C:\\Users\\bapti\\Downloads\\ImagesTestPGM\\ImagesTestPGM\\baboon.pgm");
        image.Write("baboon.pgm");
    }
    @Test
    void EqualsTest(){
        Image image1 = new Image("brain.pgm");
        Image image2 = new Image();
        Image image3 = new Image();
        image2.Read("brain.pgm");
        image3.Read("baboon.pgm");
        assertTrue(image1.equals(image2));
        assertFalse(image1.equals(image3));
    }

}