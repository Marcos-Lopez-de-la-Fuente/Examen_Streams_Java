import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{
    static final long serialVersionUID = 1174260355542286466L;

 
    private String nombre;
    private int telefono;
    private ArrayList<Medicamento> lista;

  
    public Usuario(String nombre, int telefono, ArrayList<Medicamento> lista) {
        this.setNombre(nombre);
        this.setTelefono(telefono);
        this.setLista(lista);
    }



    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getTelefono() {return telefono;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public ArrayList<Medicamento> getLista() {return lista;}
    public void setLista(ArrayList<Medicamento> lista) {this.lista = lista;}


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Usuario [lista=" + lista + ", nombre=" + nombre + ", telefono=" + telefono + "]";
    }


    
}
