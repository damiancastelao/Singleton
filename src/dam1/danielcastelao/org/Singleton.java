package dam1.danielcastelao.org;

/**
 * Solo una instancia
 */
public class Singleton {
    // atributos para comprobar que siempre es el mismo objeto
    private String nombre;
    private Integer edad;

    /**
     * Constructor bloqueado con private
     */
    private Singleton() {}

    /**
     * Edad de la persona
     * @param edad de la persona
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Nombre de la persona
     * @param nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
