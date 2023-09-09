package vehiculos;

public class VehiculoPasajeros extends Vehiculo {
    static final double PRECIO_POR_PLAZA_Y_DIA = 1.5;
    int plazas;

    public VehiculoPasajeros(String matricula, int plazas) {
        super(matricula);
        this.plazas = plazas;
    }
    
    public double precioAlquiler (int dias){
        double precioAlquiler = PRECIO_POR_DIA*dias + PRECIO_POR_PLAZA_Y_DIA*dias;
        return precioAlquiler;
    }

    public int plazas(){
        return plazas;
    }

    public String toString(){
        return "El vehículo de pasajeros con matrícula" + matricula + ", tiene " + plazas + " plazas.";
    }
}
