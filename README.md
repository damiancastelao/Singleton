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

Vamos a crear una clase que solo va a instanciarse una vez, la llamaremos `BaseDeDatos`


________________


>El constructor de esta clase lo vamos a hacer `private`.
De esta manera no podremos acceder a él desde la clase principal.
> Ya que no queremos instanciarlo

________________
 
```
public class BaseDeDatos {
    /**
    * Constructor bloqueado con private
    */
    private BasedeDatos() {}

}
```

Si no puedo acceder a él, entonces desde la clase principal, no puedo usar la sentencia:

Intento instanciar un objeto con el constructor privado, esto es un error

`BasedeDatos miUnicaInstancia = new BasedeDatos();`

El IDE me dará un error: 

*'BaseDeDatos()' has private access in '...'*


Pero, ¡esto es lo que queremos!.

Lo que vamos a hacer es crear un método para devolver un objeto único.

Este método en los Singleton se suele llamar siempre igual: `getInstance()`

---

Antes de crear este método, vamos a crear un par de atributos, para despues comprobar que tenemos el mismo objeto.

En la clase BaseDeDatos, añadimos `nombre` y `token`, y sus relativos `get/set`

## Método getInstance()

La propia clase `BaseDeDatos` va a ser la que contenga su propia y única instancia.

Para eso vamos a definir un atributo `static` que el tipo va a ser la propia clase:

`private static BaseDeDatos instance = null;`

Nuestro método tiene que comprobar si `instance` es `null`

Si es `null` quiere decir que nunca se instanción, entonces hay que instanciarlo.

Si no fuera `null`, quiere decir que ya fué creado antes, asi que no hacemos nada y lo devolvemos.


>Importante:  el método `getInstance()` será `static` para poder acceder directamente desde la clase `Singleton`

Segun exista o no ya el objeto lo instanciamos o cambiamos los datos

```
public static BaseDeDatos getInstance() {
   if (instance == null) {
       // desde aqui si que puedo acceder al constructor
       // porque estoy en la misma clase
       instance = new BaseDeDatos();
   }
   return instance;
}
```

## Pruebas

Para las pruebas vamos a instanciar dos objetos y comprobaremos que son el mismo

Primero creamos un objeto `miUnicaInstancia`:

`Singleton miUnicaInstancia = BaseDeDatos.getInstance();`

Rellenamos los atributos

```
miUnicaInstancia.setEdad(20);
miUnicaInstancia.setNombre("Pepe");
```
	
Luego, otro diferente `otraInstanciaSeraLaMisma`, que será el mismo, ya que el método se encargará de entregar el mismo objeto:

```
Singleton otraInstanciaSeraLaMisma = Singleton.getInstance();
otraInstanciaSeraLaMisma.setEdad(34);
```

Comprueba con el debug que son el mismo objeto.
