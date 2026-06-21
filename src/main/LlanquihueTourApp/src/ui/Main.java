package src.ui;

import src.data.LoadTours;
import src.data.SaveTours;
import src.model.Tour;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList <Tour> listaTours = LoadTours.cargarTours();

        System.out.println("Guardado de un archivo");
        Tour tour1 = new Tour("Queule","Pesca deportiva",25000.0);
        SaveTours.guardarDatos(tour1);

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