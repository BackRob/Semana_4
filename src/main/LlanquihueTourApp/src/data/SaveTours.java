package src.data;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import src.model.Tour;

public class SaveTours {
    public static void guardarDatos(Tour tour){

        try(BufferedWriter escribir = new BufferedWriter(
                new FileWriter("src/main/LlanquihueTourApp/src/resources/tours.txt",true)) ){
            escribir.write(tour.getNombre()+","+tour.getTipo()+","+tour.getPrecio());
            escribir.newLine();
            System.out.println("Archivo guardado con exito");

        }catch (FileNotFoundException e){
            System.out.println("ERROR: Archivo no encontrado");

        } catch (IOException e) {
            System.out.println("ERROR: Errror al esribir en el archivo");
        }


    }
}
