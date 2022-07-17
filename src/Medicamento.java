import java.io.Serializable;

public class Medicamento implements Serializable{
    static final long serialVersionUID = -5912684430505100787L;
    //ATRIBUTOS
    private String id;
    private String nombre;


    
    /** 
     * @return String
     */
    public String getId() {
        return id;
    }
    
    /** 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Medicamento(String id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Medicamento [id=" + id + ", nombre=" + nombre + "]";
    }

    
}
