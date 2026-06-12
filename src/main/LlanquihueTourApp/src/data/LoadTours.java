package src.data;

//Importamos para leer y escribir txt
import src.model.Tour;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

//importamos el error al leer


public class LoadTours {

    public static ArrayList<Tour> cargarTours(){
        ArrayList<Tour> listaTour = new ArrayList<>();
        StringBuilder lineasError = new StringBuilder("\n----Lineas Con Error----\n");
        int contadorBuenas = 0;
        int contadorlineas = 0;
        int contadorError = 0;
        try(BufferedReader leer = new BufferedReader(new FileReader("src/main/LlanquihueTourApp/src/resources/tours.txt"))){   //abre el archivo y arroja error si no encuentra
            String[] listAux; //lista para guardar split
            String linea; //variable para consumir txt

            while((linea = leer.readLine())!=null){ //si la linea existe la lee y consume
                contadorlineas++; //cuenta las lineas

                if(!linea.trim().isEmpty()){ //si la linea no esta vacia la separa
                    listAux = linea.split("\\s*,\\s*"); //aplica split

                    if(listAux.length==3){ //si no tiene las 3 variables arroja error
                        boolean tieneVacio=false;

                        for(String list : listAux){ //verifica que no esten vacias las variables a leer
                            if(list.trim().isEmpty()){
                                tieneVacio = true;
                            }
                        }

                        if(tieneVacio == false){

                            try {
                                double precio = Double.parseDouble(listAux[2]);
                                listaTour.add(new Tour(listAux[0],listAux[1],precio));
                                contadorBuenas++; //cuenta líneas leídas correctamente


                            }catch (NumberFormatException e) {
                                lineasError.append("Linea Nº").append(contadorlineas).append(": ").append(linea).append("|Error: Error en Formato\n");
                                contadorError++;
                            }



                        }else{
                            contadorError++;
                            lineasError.append("Linea Nº").append(contadorlineas).append(": ").append(linea).append("|Error: Contiene Vacio\n");
                        }

                    }else if(listAux.length>3){
                        lineasError.append("Linea Nº").append(contadorlineas).append(": ").append(linea).append("|Error: Contiene mas datos\n");
                        contadorError++;
                    }else if(listAux.length<3){
                        lineasError.append("Linea Nº").append(contadorlineas).append(": ").append(linea).append("|Error: Contiene menos datos\n");
                        contadorError++;
                    }
                }


            }


        }catch(FileNotFoundException e){
            lineasError.setLength(0);
            lineasError.append("Error Fatal: Archivo no encontrado");
            contadorError++;

        }catch(IOException e){
            contadorError++;
            lineasError.setLength(0);
            lineasError.append("Error Fatal: Error al leer el archivo");
        }
        lineasError.append("------------------------");
        lineasError.append("\nSTATUS");
        lineasError.append("\nLineas cargadas con exito: ").append(contadorBuenas);
        lineasError.append("\nLineas con errores: ").append(contadorError);
        lineasError.append("\n------------------------\n");

        if(contadorError ==0 ){
            lineasError.setLength(0);
            lineasError.append("Datos cargados satisfactoriamente");
        }

        if(contadorBuenas == 0){
            lineasError.append("\nNo se cargaron datos\n");
        }

        System.out.println(lineasError);
        return listaTour;
    }

}
