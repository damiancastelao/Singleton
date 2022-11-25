# Singleton

>Una instancia única de una clase

## Introducción
Los diseños de patrones nos ayudan a programar. Son plantillas modulares, que podremos utilizar en nuestros diferentes códigos.

El más sencillo es el `Singleton`.

Pretendemos que solamente se instancie una única instancia de la clase, siempre la misma.

## Escenario
Tenemos nuestra aplicación y una clase a parte.

De esta clase solo queremos hacer un objeto, una instancia.

Siempre que *instanciemos* vamos a obtener el mismo objeto.

En este [repositorio](https://github.com/damiancastelao/Singleton) puedes ver el código completo. 

En los [commits](https://github.com/damiancastelao/Singleton/commits/master) están los pasos

________________

## Configuración inicial 

Crearemos un proyecto nuevo y le pondremos de nombre `ProxectoSingleton`.

Lo subimos a GitHub.

Vamos a crear una clase que solo va a instanciarse una vez, la llamaremos `Singleton`


________________


>El constructor de esta clase lo vamos a hacer `private`.
De esta manera no podremos acceder a él desde la clase principal.
> Ya que no queremos instanciarlo

________________
 
```
public class Singleton {
    /**
    * Constructor bloqueado con private
    */
    private Singleton() {}

}
```

Si no puedo acceder a él, entonces desde la clase principal, no puedo usar la sentencia:


//intento instanciar un objeto con el constructor privado
// esto es un error
Singleton miUnicaInstancia = new Singleton();
	El IDE me dará un error: 
'Singleton()' has private access in 'com.mipaquete.Singleton'


Pero esto es lo que queremos. Lo que vamos a hacer es crear un método para devolver un objeto único. Este método en los Singleton se suele llamar siempre igual: “getInstance()”


Antes de crear este método, vamos a crear un par de atributos, para despues comprobar que tenemos el mismo objeto.
En la clase Singleton, añadimos ‘nombre’ y ‘edad’, y sus relativos get/set
________________
Atributo instance - Método getInstance()
La propia clase Singleton va a ser la que contenga su propia y única instancia.
Para eso vamos a definir un atributo ‘static’ que el tipo va a ser la propia clase:


// esta va a ser nuestra unica instancia
private static Singleton instance = null;
	

Nuestro método tiene que comprobar si ‘instance’ es ‘null’. Si es ‘null’ qiuere decir que nunca se instanció, entonces hay que instanciarlo. Si no fuera ‘null’, quiere decir que ya fué creado antes, asi que no hacemos nada y lo devolvemos.


________________


Importante:  el método getInstance() será ‘static’ para poder acceder directamente desde la clase Singleton
________________




/**
* Segun exista o no ya el objeto lo instanciamos o cambiamos los datos
*
* @return la instancia. Si no existe la crea primero
*/
public static Singleton getInstance() {
   if (instance == null) {
       // desde aqui si que puedo acceder al constructor
       // porque estoy en la misma clase
       instance = new Singleton();
   }
   return instance;
}


	________________
Pruebas
Para las pruebas vamos a instanciar dos objetos y comprobaremos que son el mismo
Primero ‘miUnicaInstancia’:


// creamos un objeto
Singleton miUnicaInstancia = Singleton.getInstance();
// rellenamos los atributos
miUnicaInstancia.setEdad(20);
miUnicaInstancia.setNombre("Pepe");
	Luego, otro diferente ‘otraInstanciaSeraLaMisma, que será el mismo:


// creamos otro objeto Singleton
// como la única manera es con getInstance(), este método se encargará
// de devolvernos el objeto creado anteriormente
Singleton otraInstanciaSeraLaMisma = Singleton.getInstance();
// podemos cambiar la edad
// comprobar con el debug que los dos objetos:
// miUnicaInstancia y otraInstanciaSeraLaMisma son el mismo
otraInstanciaSeraLaMisma.setEdad(34);


	

Comprueba con el debug que son el mismo objeto.


Documentación complementaria