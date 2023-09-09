package tads;

/**
 * Implementación del TAD Lista mediante una cadena enlazada.
 *
 * @author UPM
 * @param <E> El tipo de los objetos que se van a almacenar en la pila
 */
public class LinkedList<E> implements IList<E> {

  private Node<E> cabeza;

  public LinkedList() {
    cabeza = null;
  }

  public void add(int index, E element) {
    if (index < 0 || index > size())
      throw new RuntimeException("Indice " + index + " fuera de rango");
    if (index == 0)
      cabeza = new Node<E>(element, cabeza);
    else {
      Node<E> aux = cabeza;
      for (int i = 0; i <= index - 2; i++)
        aux = aux.next;
      aux.next = new Node<E>(element, aux.next);
    }
  }

  public E get(int index) {
    if (index < 0 || index >= size())
      throw new RuntimeException("Indice " + index + " fuera de rango");
    Node<E> aux = cabeza;
    for (int i = 0; i <= index - 1; i++)
      aux = aux.next;
    return aux.element;
  }

  public int size() {
    int num = 0;
    Node<E> aux = cabeza;
    while (aux != null) {
      num = num + 1;
      aux = aux.next;
    }
    return num;
  }

  public void set(int index, E element) {
    if (index < 0 || index >= size())
      throw new RuntimeException("Indice " + index + " fuera de rango");
    Node<E> aux = cabeza;
    for (int i = 0; i <= index - 1; i++)
      aux = aux.next;
    aux.element = element;
  }

  public int indexOf(E element) {
    int pos = 0;
    Node<E> aux = cabeza;
    boolean encontrado = false;
    while (aux != null && !encontrado)
      if (aux.element.equals(element))
        encontrado = true;
      else {
        pos = pos + 1;
        aux = aux.next;
      }
    return encontrado ? pos : -1;
  }

  public void remove(int index) {
    if (index < 0 || index > size() - 1)
      throw new RuntimeException("Indice " + index + " fuera de rango");
    Node<E> actual = cabeza;
    Node<E> anterior = cabeza;
    for (int i = 0; i <= index - 1; i++) {
      anterior = actual;
      actual = actual.next;
    }
    if (actual == anterior)
      cabeza = cabeza.next;
    else if (actual == null)
      anterior.next = null;
    else
      anterior.next = actual.next;
  }

  public void remove(E element) {
    int pos = indexOf(element);
    if (pos > -1)
      remove(pos);
  }

  public String toString() {
    String salida = "[";
    Node<E> aux = cabeza;
    int cont = 0;
    while (aux != null) {
      if (cont != 0)
        salida += ", ";
      salida += aux.element;
      aux = aux.next;
      cont += 1;
    }
    return salida + "]";
  }

  public IList<E> subList(int fromIndex, int toIndex) {
    if (toIndex - fromIndex + 1 > size())
      throw new RuntimeException();
    if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
      throw new RuntimeException();

    IList<E> resultado = new LinkedList<E>();
    int j = 0;
    for (int i = fromIndex; i < toIndex; i += 1) {
      resultado.add(j, get(i));
      j += 1;
    }
    return resultado;
  }

}
