package vehiculos;

public class Camion extends VehiculoCarga{

    public Camion(String matricula, double pma) {
        super(matricula, pma);
    }

    public double precioAlquiler(int dias){
        double precioAlquiler = PRECIO_POR_DIA*dias + PRECIO_POR_TONELADA_DE_PMA*pma + 40;
        return precioAlquiler;
    }
    
    public String toString(){
        return "El camión de matrícula " + matricula + ", tiene un PMA de " + pma + " toneladas.";
    }
}
