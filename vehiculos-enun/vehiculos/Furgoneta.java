package vehiculos;

public class Furgoneta extends VehiculoCarga {

    public Furgoneta(String matricula, double pma) {
        super(matricula, pma);
    }
    
    public String toString(){
        return "La furgoneta con matrícula " + matricula + ", tiene un PMA de " + pma + " toneladas.";
    }
}
