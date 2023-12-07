package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    @Test
    void TestRead(){
        Image image = new Image();
        image.Read("test.pgm");
        assertArrayEquals(new int[]{1, 2, 3}, image.image[0]);
        assertArrayEquals(new int[]{4, 5, 6}, image.image[1]);
        assertArrayEquals(new int[]{7, 8, 9}, image.image[2]);
        assertEquals(3, image.largeur);
        assertEquals(3, image.hauteur);
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