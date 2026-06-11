package src.model;

public class Tour {
    private String nombre;
    private String tipo;
    private double precio;


    public Tour(){
        this("SIN_NOMBRE","SIN_TIPO",0);
    }

    //Constructor Completo
    public Tour(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }


    //Sets
    public void setTipo(String tipo) {this.tipo = tipo;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    //Gets
    public String getTipo() {return tipo;}
    public double getPrecio() {return precio;}
    public String getNombre() {return nombre;}


    @Override
    public String toString() {
        return "Tour{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
