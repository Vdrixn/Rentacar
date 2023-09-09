package vehiculos;

public class Microbus extends VehiculoPasajeros {
    static final double PRECIO_POR_PLAZA = 2;

    public Microbus(String matricula, int plazas) {
        super(matricula, plazas);
    }
    
    public double precioAlquiler(int dias){
        double precioAlquiler = PRECIO_POR_DIA*dias + PRECIO_POR_PLAZA_Y_DIA*dias + PRECIO_POR_PLAZA*this.plazas();
        return precioAlquiler;
    }

    public String toString(){
        return "El microbus de matrícula " + matricula + ", tiene " + plazas + " plazas.";
    }
}
