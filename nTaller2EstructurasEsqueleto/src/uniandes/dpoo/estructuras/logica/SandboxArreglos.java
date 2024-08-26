package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros()
    {
    	int[] copia = arregloEnteros.clone();
    	
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas()
    {
    	String[] copia = arregloCadenas.clone();
    	
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros()
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas()
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	arregloEnteros = Arrays.copyOf(arregloEnteros, arregloEnteros.length + 1);
    	arregloEnteros[arregloEnteros.length - 1] = entero;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	arregloCadenas = Arrays.copyOf(arregloCadenas, arregloCadenas.length + 1);
    	arregloCadenas[arregloCadenas.length - 1] = cadena;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {   
    	if (arregloEnteros.length != 0)
    	{
    		int ocurrences = 0;
    		
    		for(int entero : arregloEnteros)
        	{
        		if (entero == valor)
        			ocurrences += 1;
        	}        	
    		int[] newArreglo = new int[arregloEnteros.length - ocurrences];
        	
        	for(int i = 0, j = 0; i < arregloEnteros.length; i++)
        	{
        		if (arregloEnteros[i] != valor)
        		{
        			newArreglo[j] = arregloEnteros[i];
        			j++;
        		}
        	}
        	arregloEnteros = newArreglo;
    	}
    	
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {    	
    	if (arregloEnteros.length != 0)
    	{
    		int ocurrences = 0;
    		
    		for(String string : arregloCadenas)
        	{
        		if (string.equals(cadena))
        			ocurrences += 1;
        	}
        	
    		String[] newArreglo = new String[arregloCadenas.length - ocurrences];
        	
        	for(int i = 0, j = 0; i < arregloCadenas.length; i++)
        	{
        		if (arregloCadenas[i] != cadena)
        		{
        			newArreglo[j] = arregloCadenas[i];
        			j++;
        		}
        	}
    	}
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	//if (arregloEnteros.length != 0)
    	//{    
    		int[] newArray = new int[arregloEnteros.length + 1];
    		
    		if (posicion <= 0)
    		{
    			newArray[0] = entero;
    			
    			for(int i = 1, j = 0; i < newArray.length; i++, j++)
    				newArray[i] = arregloEnteros[j];
    		}
    		else if (posicion >= arregloEnteros.length - 1) 
    		{    			
    			for(int i = 0; i < newArray.length - 1; i++)
    				newArray[i] = arregloEnteros[i];
    			
    			newArray[newArray.length -1] = entero;
    		}
    		else
    		{
    			for(int i = 0, j = 0; i < newArray.length; i++, j++)
    			{
    				if (i == posicion)
    				{
    					newArray[i] = entero;
    					++i;
    				}
    				
    				newArray[i] = arregloEnteros[j];
    			}
    		}
    		arregloEnteros = newArray;
    	//}
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (arregloEnteros.length != 0 && 0 <= posicion && posicion < arregloEnteros.length)
    	{
    		int[] newArray = new int[arregloEnteros.length - 1];
    		
    		for(int i = 0, j = 0; i < arregloEnteros.length; i++)
			{
    			if (i == posicion)
    				continue;
    			newArray[j++] = arregloEnteros[i];
			}
    		arregloEnteros = newArray;
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	arregloEnteros = new int[valores.length];
    	
    	if (valores.length > 0)
    	{
    		int n;
    		
    		for(int i = 0; i < arregloEnteros.length; i++)
    		{
    			n = (int) valores[i];
    			arregloEnteros[i] = n;
    		}
    	}
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	arregloCadenas = new String[objetos.length];
    	
    	if (objetos.length > 0)
    	{
    		String c;
    		
    		for(int i = 0; i < arregloCadenas.length; i++)
    		{
    			c = objetos[i].toString();
    			arregloCadenas[i] = c;
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	if (arregloEnteros.length > 0)
    	{
    		int n;
    		
    		for(int i = 0; i < arregloEnteros.length; i++)
    		{
    			n = arregloEnteros[i];
    			
    			if (n < 0)
    				n *= -1;
    			
    			arregloEnteros[i] = n;
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {

    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int ocurrences = 0;
    	
    	if (arregloEnteros.length > 0)
    	{
    		for(int number : arregloEnteros)
        	{
        		if(number == valor)
        			ocurrences += 1;
        	}
    	}
    	
        return ocurrences;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int ocurrences = 0;
    	
    	if (arregloCadenas.length > 0)
    	{
    		for(String string : arregloCadenas)
        	{
        		if(string.toLowerCase().equals(cadena.toLowerCase()))
        			ocurrences += 1;
        	}
    	}
    	
        return ocurrences;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int[] indexes = new int[]{};
    	
    	if (arregloEnteros.length > 0)
    	{
    		for(int i = 0; i < arregloEnteros.length; i++)
    		{
    			if (arregloEnteros[i] == valor && i == 0)
    			{
    				indexes = Arrays.copyOf(indexes, indexes.length + 1);
    	    		indexes[0] = i;
    			}
    				
    	    	else if (arregloEnteros[i] == valor)
    	    	{
    	    		indexes = Arrays.copyOf(indexes, indexes.length + 1);
    	    		indexes[indexes.length - 1] = i;
    	    	}
    		}
    	}
    	
        return indexes;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	int[] range = new int[0];
    	
    	if (arregloEnteros.length > 0)
    	{
    		range = new int[2];
    		int min = 9999999;
    		int max = -9999999;
    		
    		for(int n : arregloEnteros)
    		{
    			if (n < min)
    				min = n;
    			if (n > max)
    				max = n;
    		}
    		range[0] = min;
    		range[1] = max;
    	}
    	
        return range;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        return null;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	
        return -1;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean answer = false;
    	
    	if(Arrays.equals(otroArreglo, arregloEnteros))
    		answer = true;
    		
        return answer;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	boolean answer = false;
    	Arrays.sort(otroArreglo);
    	Arrays.sort(arregloEnteros);
    	
    	if(Arrays.equals(arregloEnteros, otroArreglo))
    		answer = true;
    	
        return answer;
    }
    
    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	arregloEnteros = new int[arregloEnteros.length];
    	int interval = maximo - minimo + 1;
    	
    	for(int i = 0; i < arregloEnteros.length; i++)
    	{
    		arregloEnteros[i] = (int) (Math.random() * interval) + minimo;
    	}
    }

}
