package vehiculos;

public class Coche extends VehiculoPasajeros {

    public Coche(String matricula, int plazas) {
        super(matricula, plazas);
    }
    
    public String toString(){
        return "El coche con matrícula " + matricula + ", tiene " + plazas + " plazas.";
    }
}
