package dam1.danielcastelao.org;

public class Main {

    public static void main(String[] args) {
        System.out.println("Proyecto para aprender a hacer un Singleton");

        // intento instanciar un objeto con el constructor privado
        // esto es un error
        // Singleton miUnicaInstancia = new Singleton();

        // creamos un objeto
        BaseDeDatos miUnicaInstancia = BaseDeDatos.getInstance();
        // rellenamos los atributos
        miUnicaInstancia.setToken("AAR3");
        miUnicaInstancia.setNombre("Pepe");

        // creamos otro objeto Singleton
        // como la única manera es con getInstance(), este método se encargará
        // de devolvernos el objeto creado anteriormente
        BaseDeDatos otraInstancia = BaseDeDatos.getInstance();
        // podemos cambiar la edad
        // comprobar con el debug que los dos objetos:
        // miUnicaInstancia y otraInstanciaSeraLaMisma son el mismo
        otraInstancia.setToken("BG4H");

        // version 1.1 del programa con otra instancia
        BaseDeDatos versionInstancia = BaseDeDatos.getInstance();
        versionInstancia.setNombre("version 1.2");
    }
}
