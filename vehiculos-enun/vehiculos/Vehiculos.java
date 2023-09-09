package vehiculos;
import tads.*;
/** 
 * Colecci�n de vehiculos dados de alta en la empresa.
 * 
 * @author Adrian Romero Verdasco
 */
public class Vehiculos extends ArrayList<Vehiculo>
{
  /** 
   * Constructor de Vehiculos.
   */
  public Vehiculos () {
    super();
  }
  /** 
   A�ade un veh�culo a la lista, poni�ndolo
   al final para respetar el orden de llegada.
   */
  public void registrarVehiculo (Vehiculo v) {
    this.add(size(), v);
  }
  /** 
   * POST: Devuelve el vehiculo con <matricula> o null en caso
   *       de no encontrarlo. 
   */
  public Vehiculo buscaVehiculo (String matricula) {
    Vehiculo encontrado = null;
    for(int i = 0; i < this.size(); i++){
      String matricula1 = this.get(i).matricula;
      if(matricula == matricula1)
        return encontrado = this.get(i);
    }
    return encontrado;
  }
  /** 
   * PRE: Hay al menos un vehiculo con <matricula> en la lista de veh�culos.
   * POST: resultado es el precio del alquiler del vehiculo con <matricula> y 
           durante un periodo de varios <dias>.
   * throws: RuntimeException en caso que no haya ning�n vehiculo con esta
             matricula en la lista de veh�culos.
   */
  public double precioAlquiler (String matricula, int dias) {
    double precio;
    Vehiculo vehiculo = this.buscaVehiculo(matricula);
    if(vehiculo == null){
      throw new RuntimeException();
    }
    else return precio = vehiculo.precioAlquiler(dias);
  } 
  /**
   POST: resultado es una cadena de caracteres con todos los 
         veh�culos registrados y sus precios en funci�n del numero 
         de <dias>.
   */
  public String mostrarTodosLosPrecios (int dias) {
    String precios = "";
    for(int i = 0; i < this.size(); i++){
      precios = precios + "El vehículo con matrícula " + this.get(i).matricula + ", cuesta " + this.get(i).precioAlquiler(dias) + "." + "\n";
    }
    return precios;
  }
}
