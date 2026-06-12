package src.ui;

import src.data.LoadTours;
import src.model.Tour;
import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList <Tour> listaTours = LoadTours.cargarTours();

        System.out.println("Lista Completa Tours");
        for (Tour tour : listaTours){

            System.out.println(tour);

        }

        System.out.println("\nFiltrado por Gastronomico y precio mayor a 1000");
        for (Tour tour : listaTours){
            if (tour.getTipo().equals("Gastronomico")){
                if (tour.getPrecio()>1000.0) {
                    System.out.println(tour);
                }

            }
        }
    }
}