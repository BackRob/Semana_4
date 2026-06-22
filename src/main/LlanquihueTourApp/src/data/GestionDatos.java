package src.data;

import src.model.Tour;
import java.io.*;
import java.util.ArrayList;


public class GestionDatos {
    private ArrayList<Tour> listaTour = new ArrayList<>();




    //metodo para cargar datos al arraylist
    public void cargarTours(){
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

                        if(tieneVacio == false){ //si no tienen vacio crea y guarda los objetos Tour.

                            try { //manejo de errores al parsear
                                double precio = Double.parseDouble(listAux[2]);
                                listaTour.add(new Tour(listAux[0],listAux[1],precio));
                                contadorBuenas++; //cuenta líneas leídas correctamente


                            }catch (NumberFormatException e) {
                                lineasError.append("Linea Nº").append(contadorlineas).append(": ").append(linea).append("|Error: Error en Formato\n");
                                contadorError++;
                            }



                        }else{ //si tiene vacio, guarda la liena y guarda el error.
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


        }catch(FileNotFoundException e){ // si no encuentra el archivo arroja error.
            lineasError.setLength(0);
            lineasError.append("Error Fatal: Archivo no encontrado");
            contadorError++;

        }catch(IOException e){
            contadorError++;
            lineasError.setLength(0);
            lineasError.append("Error Fatal: Error al leer el archivo");
        }
        lineasError.append("------------------------");
        lineasError.append("\nSTATUS"); //status al cargar desde txt
        lineasError.append("\nLineas cargadas con exito: ").append(contadorBuenas);
        lineasError.append("\nLineas con errores: ").append(contadorError);
        lineasError.append("\n------------------------\n");

        if(contadorError ==0 ){ //si el contador de error esta en 0, se cargaron todos los datos
            lineasError.setLength(0);
            lineasError.append("Datos cargados satisfactoriamente");
            lineasError.append("\nLineas cargadas con exito: ").append(contadorBuenas);
        }

        if(contadorBuenas == 0){    //si el contador de buenas esta en 0, no se cargaron datos
            lineasError.append("\nNo se cargaron datos, el archivo esta vacio o contiene errores");
            lineasError.append("\nLineas con errores: ").append(contadorError);
        }

        System.out.println(lineasError); //muetra por consola todos los datos en error y el status.
        return listaTour;
    }



    //Metodo para guardar datos
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
