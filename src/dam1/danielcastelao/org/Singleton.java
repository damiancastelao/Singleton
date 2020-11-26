package dam1.danielcastelao.org;

/**
 * Solo una instancia
 */
public class Singleton {
    // atributos para comprobar que siempre es el mismo objeto
    private String nombre;
    private Integer edad;

    // esta va a ser nuestra unica instancia
    private static Singleton instance = null;

    /**
     * Constructor bloqueado con private
     */
    private Singleton() {
    }

    /**
     * Segun exista o no ya el objeto lo instanciamos o cambiamos los datos
     *
     * @return la instancia. Si no existe la crea primero
     */
    public static Singleton getInstance() {
        // compruebo si ya está creada
        if (instance == null) {
            // como no está creada, la creo
            // desde aqui si que puedo acceder al constructor
            // porque estoy en la misma clase
            instance = new Singleton();
        }
        // devuelvo la instancia
        return instance;
    }

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
