package vehiculos;

public class Vehiculo {
    public static final int COCHE = 0;
    public static final int MICROBUS = 1;
    public static final int FURGONETA = 2;
    public static final int CAMION = 3;
    static final double PRECIO_POR_DIA = 50.0;
    String matricula = "";

    public Vehiculo (String matricula){
        this.matricula = matricula;
    }

    public double precioAlquiler (int dias){
        double precioAlquiler = PRECIO_POR_DIA*dias;
        return precioAlquiler;
    }

    public String matricula(){
        return matricula;
    }

    public String toString(){
        return "La matrícula del vehículo es: " + matricula;
    }
    
}
