package src.ui;

import src.data.LoadTours;
import src.model.Tour;
import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        ArrayList <Tour> listaTours = LoadTours.cargarTours();

        for (Tour tour : listaTours){
            System.out.println(tour);
        }
    }
}