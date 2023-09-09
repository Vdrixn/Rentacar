package vehiculos;

public class VehiculoCarga extends Vehiculo {
    static final double PRECIO_POR_TONELADA_DE_PMA = 20;
    double pma;

    public VehiculoCarga(String matricula, double pma) {
        super(matricula);
        this.pma = pma;
    }
    
    public double precioAlquiler(int dias){
        double precioAlquiler = PRECIO_POR_DIA*dias + PRECIO_POR_TONELADA_DE_PMA*pma;
        return precioAlquiler;
    }

    public String toString(){
        return "El vehículo de carga con matrícula " + matricula + ", tiene un PMA de " + pma + " toneladas.";
    }
}
