package src.data;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import src.model.Tour;

public class SaveTours {
    public static void GuardarDatos(Tour tour){

        try(BufferedWriter escribir = new BufferedWriter(
                new FileWriter("\"src/main/LlanquihueTourApp/src/resources/tours.txt\"")) ){


        }catch (FileNotFoundException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
