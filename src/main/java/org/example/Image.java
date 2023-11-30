package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Image {
    int hauteur;
    int largeur;
    int[][] image;

    public void Image(){}

    public void Read(String file){
        try {
            ArrayList<Integer> pixels = new ArrayList<>();
            String[] list;
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(file));
            fichier.readLine(); fichier.readLine();
            list = fichier.readLine().split(" ");
            largeur = parseInt(list[0]);
            hauteur = parseInt(list[1]);
            fichier.readLine();
            while ((ligne = fichier.readLine()) != null) {
                list = ligne.split(" ");
                for (String s : list){
                    if (!s.isEmpty()) {
                        pixels.add(parseInt(s));
                    }
                }
            }
            System.out.println(pixels.size() + " " + hauteur*largeur);
            image = new int[hauteur][largeur];
            for (int i=0; i<hauteur; i++){
                for (int j=0; j<largeur; j++){
                    image[i][j] = pixels.get(i*largeur+j);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void Write(String file){
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write("P2");
            bw.newLine();
            bw.write("#");
            bw.newLine();
            bw.write(largeur + " " + hauteur);
            bw.newLine();
            bw.write("255");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0; i<image.length; i++){
                for (int j=0; j<image[i].length; j++){
                    list.add(image[i][j]);
                }
            }
            while (!list.isEmpty()) {
                bw.newLine();
                int elmt;
                for (int j = 0; j < 17; j++) {
                    if (!list.isEmpty()) {
                        elmt = list.remove(0);
                        if (elmt < 10) {
                            bw.write("  " + elmt + " ");
                        } else if (elmt < 100) {
                            bw.write(" " + elmt + " ");
                        } else {
                            bw.write(elmt + " ");
                        }
                    }
                }
            }
            bw.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void Seuillage(int seuil){
        for (int i=0; i<hauteur; i++){
            for (int j=0; j<largeur; j++){
                if (image[i][j]>=seuil){
                    image[i][j] = 255;
                }else{
                    image[i][j] = 0;
                }
            }
        }
    }

    public Image Diff(Image im){
        Image diff = new Image();
        if ((hauteur!=im.hauteur)||(largeur!=im.largeur)){
            System.out.println("Erreur de format");
        }else{
            diff.image = new int[hauteur][largeur];
            diff.hauteur = hauteur;
            diff.largeur = largeur;
            for (int i=0; i<hauteur; i++){
                for (int j=0; j<largeur; j++){
                    diff.image[i][j] = abs(image[i][j] - im.image[i][j]);
                }
            }
        }
        return diff;
    }
}
