package dam1.danielcastelao.org;

/**
 * Solo una instancia
 */
public class BaseDeDatos {
    // atributos para comprobar que siempre es el mismo objeto
    private String nombre;
    private String token;

    // esta va a ser nuestra unica instancia
    private static BaseDeDatos instance = null;

    /**
     * Constructor bloqueado con private
     */
    private BaseDeDatos() {
    }

    /**
     * Segun exista o no ya el objeto lo instanciamos o cambiamos los datos
     *
     * @return la instancia. Si no existe la crea primero
     */
    public static BaseDeDatos getInstance() {
        // compruebo si ya está creada
        if (instance == null) {
            // como no está creada, la creo
            // desde aqui si que puedo acceder al constructor
            // porque estoy en la misma clase
            instance = new BaseDeDatos();
        }
        // devuelvo la instancia
        return instance;
    }

    /**
     * Edad de la persona
     * @param token de la persona
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Nombre de la persona
     * @param nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
