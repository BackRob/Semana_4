package src.data;

import src.model.Tour;
import java.io.*;
import java.util.ArrayList;


public class GestionDatos {
    private final ArrayList<Tour> listaTour = new ArrayList<>();

    //constructor con datos cargados
    public GestionDatos(){
        cargarTours();
    }


    //metodo para cargar datos al arraylist
    public void cargarTours(){
        listaTour.clear();
        StringBuilder lineasError = new StringBuilder("\n----Lineas Con Error----\n");
        int contadorBuenas = 0;
        int contadorlineas = 0;
        int contadorError = 0;
        try(BufferedReader leer = new BufferedReader(new FileReader("src/main/LlanquihueTourApp/src/resources/tours.txt"))){   //abre el archivo y arroja error si no encuentra
            String[] listAux; //lista para guardar split
            String linea; //variable auxiliar para consumir txt

            while((linea = leer.readLine())!=null){ //si la linea existe la lee y consume
                contadorlineas++; //cuenta las lineas

                if(!linea.trim().isEmpty()){ //si la linea no esta vacia la separa
                    listAux = linea.split("\\s*,\\s*"); //aplica split

                    if(listAux.length==3){ //si no tiene las 3 variables arroja error
                        boolean tieneVacio=false;

                        for(String list : listAux){ //verifica que no esten vacias las variables a leer
                            if (list.trim().isEmpty()) {
                                tieneVacio = true;
                                break;
                            }
                        }

                        if(!tieneVacio){ //si no tienen vacio crea y guarda los objetos Tour.

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
                    }else {
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
    }



    //Metodo para guardar datos
    public void guardarDatos(Tour tour){
        if (tour != null) {
            try (BufferedWriter escribir = new BufferedWriter(
                    new FileWriter("src/main/LlanquihueTourApp/src/resources/tours.txt", true))) {
                //for(Tour t : listaTour){}

                escribir.write(tour.getNombre() + "," + tour.getTipo() + "," + tour.getPrecio());
                escribir.newLine();
                System.out.println("Archivo guardado con exito");
                listaTour.add(tour); //asi se evita volver a cargar toda la lista

            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Archivo no encontrado");

            } catch (IOException e) {
                System.out.println("ERROR: Error al escribir en el archivo");
            }
        }else{
            System.out.println("Error: TOUR null");
        }

    }

    //Metodo para sobreescribir linea (Trasladando todo el arraylist al archivo)
    public void SobreescribirDatos() {
        int contadorExito = 0;

        try (BufferedWriter escribir = new BufferedWriter(
                new FileWriter("src/main/LlanquihueTourApp/src/resources/tours.txt"))) {
            for (Tour tour : listaTour) {
                escribir.write(tour.getNombre() + "," + tour.getTipo() + "," + tour.getPrecio());
                escribir.newLine();
                contadorExito++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");

        } catch (IOException e) {
            System.out.println("ERROR: Error al escribir en el archivo");
        }

        if (contadorExito == listaTour.size()) {
            System.out.println("Archivo Sobreescrito con exito");
        }else{
            System.out.println("ERROR: Ocurrieron errores al escribir en el archivo .txt");
        }



    }


    //Metodo para buscar por nombre y mostrar por consola
    public void buscarNombre(String nombre){
        int contadorCoincidencias = 0;
        StringBuilder sb = new StringBuilder("Nombre Buscado: ").append(nombre).append("\n");
        sb.append("----COINCIDENCIAS----\n");
        if (!nombre.trim().isEmpty()){
            for(Tour tour:listaTour){
                if(tour.getNombre().equalsIgnoreCase(nombre)){
                    contadorCoincidencias++;
                    sb.append(contadorCoincidencias).append(".-").append(tour).append("\n");
                }
            }

        }else{
            System.out.println("ERROR: Filtro ingresado vacio");
            return;
        }

        if (contadorCoincidencias == 0){
            sb.setLength(0);
            sb.append("SIN COINCIDENCIAS PARA NOMBRE: \"").append(nombre).append("\"\n");

        }

        System.out.println(sb);
    }

    //Metodo para buscar por tipo y mostrar por consola
    public void buscarTipo(String tipo){
        int contadorCoincidencias = 0;
        StringBuilder sb = new StringBuilder("Tipo Buscado: ").append(tipo).append("\n");
        sb.append("----COINCIDENCIAS----\n");
        if (!tipo.trim().isEmpty()){
            for(Tour tour:listaTour){
                if(tour.getTipo().equalsIgnoreCase(tipo)){
                    contadorCoincidencias++;
                    sb.append(contadorCoincidencias).append(".-").append(tour).append("\n");
                }
            }

        }else{
            System.out.println("ERROR: Filtro ingresado vacio");
            return;
        }

        if (contadorCoincidencias == 0){
            sb.setLength(0);
            sb.append("SIN COINCIDENCIAS PARA TIPO:  \"").append(tipo).append("\"\n");

        }

        System.out.println(sb);
    }

    //Metodo para filtrar recibiendo el precio y el operador
    public void filtrarPrecio(double precio,String operador){
        StringBuilder sb = new StringBuilder("Filtro Aplicado: Precio ").append(operador).append(" ").append(precio);
                sb.append("\n");
        sb.append("----Filtrado----\n");
        if (precio<0 || operador==null || operador.trim().isEmpty()){
            System.out.println("ERROR: Error en argumentos, Por favor ingresar datos validos para filtrar");
            return;
        }

        int contador = 0;
        for (Tour tour : listaTour) {
            switch (operador.trim()) {

                case ">":
                    if (tour.getPrecio() > precio)  sb.append(tour).append("\n");
                    contador++;
                    break;

                case ">=","=>":
                    if (tour.getPrecio() >= precio) sb.append(tour).append("\n");
                    contador++;
                    break;

                case "<":
                    if (tour.getPrecio() < precio) sb.append(tour).append("\n");
                    contador++;
                    break;

                case "<=", "=<":
                    if (tour.getPrecio() <= precio) sb.append(tour).append("\n");
                    contador++;
                    break;
            }
        }

        if (contador==0){
            sb.setLength(0);
            sb.append("SIN DATOS QUE CUMPLAN CON EL FILTRO\n");
        }


        System.out.println(sb);
    }


}

