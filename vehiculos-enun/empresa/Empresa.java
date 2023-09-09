package empresa;
import tads.*;
import vehiculos.*;
/**
 * Empresa de alquiler de vehículos.
 *
 * @author Adrian Romero Verdasco
 */
public class Empresa
{
  private Vehiculos vehiculos;
  private IList<IQueue<Vehiculo>> flota;
  private IQueue<Peticion> peticiones;
  private Vehiculos asignados;
  private IQueue<Peticion> listaDeEspera;
  
  private static Vehiculos cargaVehiculos (Vehiculo[] vs){
    Vehiculos vehiculos = new Vehiculos();
	  for (int i = 0; i < vs.length; i++)
	    vehiculos.registrarVehiculo(vs[i]);
    return vehiculos;
  }
  private static IQueue<Peticion> cargaPeticiones (Peticion[] ps)
  {
    IQueue<Peticion> peticiones = new Queue<Peticion>();
	  for (int i = 0; i < ps.length; i++)
	    peticiones.push(ps[i]);
    return peticiones;
  }
  /**
   Constructor de la Empresa.
   */
  public Empresa (Vehiculo[] vs, Peticion[] ps){

  }
  /**
   Carga la <flota> de vehiculos a partir de <vehiculos>
   (ver enunciado).
   */
  public void cargarFlota (){
    for(int i = 0; i < vehiculos.size(); i++){
      if(vehiculos.get(i) instanceof Coche){
        flota.get(Vehiculo.COCHE).push(vehiculos.get(i));
      }
      else if(vehiculos.get(i) instanceof Microbus){
        flota.get(Vehiculo.MICROBUS).push(vehiculos.get(i));
      }
      else if(vehiculos.get(i) instanceof Furgoneta){
        flota.get(Vehiculo.FURGONETA).push(vehiculos.get(i));
      }
      else if(vehiculos.get(i) instanceof Camion){
        flota.get(Vehiculo.CAMION).push(vehiculos.get(i));
      }
    }
  }
  /**
   Alquila los vehiculos a partir de las <peticiones> 
   extrayéndolos de la <flota> y los pone en <asignados>.
   Las peticiones que no se pueden atender se encolan en
   la <listaDeEspera> (ver enunciado). 
   */
  public void alquilarVehiculos (){
    while(!peticiones.isEmpty()){
      if(peticiones.peek().codigo() == 0){
        if(flota.get(Vehiculo.COCHE)==null){
          throw new RuntimeException();
        }
        else flota.get(Vehiculo.COCHE).pop();
      }
      if(peticiones.peek().codigo() == 1){
        if(flota.get(Vehiculo.MICROBUS)==null){
          throw new RuntimeException();
        }
        else flota.get(Vehiculo.MICROBUS).pop();
      }
      if(peticiones.peek().codigo() == 2){
        if(flota.get(Vehiculo.FURGONETA)==null){
          throw new RuntimeException();
        }
        else flota.get(Vehiculo.FURGONETA).pop();
      }
      if(peticiones.peek().codigo() == 0){
        if(flota.get(Vehiculo.CAMION)==null){
          throw new RuntimeException();
        }
        else flota.get(Vehiculo.CAMION).pop();
      }
    }
  }
  /*
   Para implementar mejorCliente podemos utilizar
   la clase interna privada Contador y las operaciones
   posicion y actualizar.
   Contador modela la frecuencia de aparición de 
   un String llamado elemento.
  */
  private class Contador{
    String elemento;
    int frecuencia;             
    Contador (String elemento){
      this.elemento = elemento;
      frecuencia = 0;
    } 
  }  
 /**
  lf es una lista de frecuencias que cuenta el número de
  apariciones del dni de un cliente.
  POST: 
    resultado tiene la posición que ocupar el dni 
    en la lista de frecuencias lf.
    En caso de no estar en la lista, el resultado 
    es -1.
  */
  private int posicion (String dni, IList<Contador> lf)
  {
    int i = 0;
    boolean esta = false;
    while (i < lf.size() && !esta)
      if (dni.equals(lf.get(i).elemento))
        esta = true;
      else
        i = i + 1;
    return esta? i : -1;
  }
 /**
  Actualiza la lista de frecuencias lf con el dni.
  */
  private void actualizar (String dni, IList<Contador> lf) {
  }
  /**
   PRE: !peticiones.isEmpty()
   POST: resultado tiene el DNI del cliente que más peticiones
         de vehículos ha hecho.
   throws RuntimeException si peticiones.isEmpty() 
   (ver enunciado). 
   */
  public String mejorCliente (){
    String mejorCliente;
    if(peticiones.isEmpty()){
      throw new RuntimeException();
    }
    else{
      for(int i = 0; i < this.size(); i++){
        String matricula1 = this.get(i).matricula;
        if(matricula == matricula1)
          return encontrado = this.get(i);
      }
    }
    return mejorCliente;
  }
  /**
   POST: resultado es una cadena de caracteres con todos 
         los datos de la empresa.
   */
  public String toString ()
  {
    String s = new String();
    s += "vehiculos: \n" + vehiculos.toString() + "\n";
    for (int i = Vehiculo.COCHE; i <= Vehiculo.CAMION; i+=1) 
    {
      s += " flota" + i + ": " + flota.get(i).toString() + "\n";
    }
    s += "peticiones: \n" + peticiones.toString() + "\n";
    s += "asignados: \n" + asignados.toString() + "\n";
    s += "listaDeEspera: \n" + listaDeEspera.toString() + "\n";
    return s;
  }
} 
  