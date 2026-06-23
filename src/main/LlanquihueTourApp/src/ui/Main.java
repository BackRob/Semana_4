package src.ui;
import src.data.GestionDatos;


public class Main {
    public static void main(String[] args) {
        GestionDatos gestor = new GestionDatos();
        gestor.buscarNombre("lago petrolhue");
        gestor.buscarTipo("gastronomico");
        gestor.filtrarPrecio(4000,">");

    }
}