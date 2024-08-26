package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre conjuntos implementados usando un árbol (TreeSet).
 *
 * Todos los métodos deben operar sobre el atributo arbolCadenas que se declara como un NavigableSet.
 * 
 * El objetivo de usar el tipo NavigableSet es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (TreeSet).
 * 
 * A diferencia de un Set, en un NavigableSet existe una noción de orden que en este caso corresponde al órden lexicográfico.
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxConjuntos
{
    /**
     * Un conjunto (set) de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Por defecto, los elementos del conjunto están ordenados lexicográficamente.
     */
    private NavigableSet<String> arbolCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }

    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente
     * @return Una lista con las cadenas ordenadas
     */
    public List<String> getCadenasComoLista( )
    {
    	ArrayList<String> myList = new ArrayList<>();
    	
    	if(arbolCadenas.size() > 0)
    	{
    		myList = new ArrayList<>(arbolCadenas);
        	myList.sort(null);
    	}
    	
        return myList;
    }

    /**
     * Retorna una lista con las cadenas del conjunto, ordenadas lexicográficamente de mayor a menor.
     * @return Una lista con las cadenas ordenadas de mayor a menor
     */
    public List<String> getCadenasComoListaInvertida( )
    {
    	ArrayList<String> myList = new ArrayList<>();
    	
    	if(arbolCadenas.size() > 0)
    	{
    		myList = new ArrayList<>(arbolCadenas);
        	myList.sort(Comparator.reverseOrder());
    	}
        return myList;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor en el conjunto de cadenas.
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La primera cadena del conjunto, o null si está vacío.
     */
    public String getPrimera( )
    {
    	String first = null;
    	
    	if(arbolCadenas.size() > 0)
    		first = arbolCadenas.getFirst();
    	
        return first;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor en el conjunto de cadenas
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La última cadena del conjunto, o null si está vacío.
     */
    public String getUltima( )
    {
    	String last = null;
    	
    	if(arbolCadenas.size() > 0)
    		last = arbolCadenas.getLast();
    	
        return last;
    }

    /**
     * Retorna una colección con las cadenas que hacen parte del conjunto de cadenas y son mayores o iguales a la cadena que se recibe por parámetro
     * @param cadena
     * @return Una colección de cadenas mayores a la cadena dada. Si la cadena hace parte del conjunto, debe hacer parte de la colección retornada.
     */
    public Collection<String> getSiguientes( String cadena )
    {
    	ArrayList<String> myList = new ArrayList<>();
    	
    	if(arbolCadenas.size() > 0)
    	{
    		Iterator<String> iterador = arbolCadenas.iterator();
    		String c;
    		
    		while(iterador.hasNext())
    		{
    			c = iterador.next();
    			if(c.compareTo(cadena) >= 0)
    				myList.add(c);
    		}
    	}
        return myList;
    }

    /**
     * Retorna la cantidad de valores en el conjunto de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arbolCadenas.size();
    }

    /**
     * Agrega un nuevo valor al conjunto de cadenas.
     * 
     * Este método podría o no aumentar el tamaño del conjunto, dependiendo de si el número está repetido o no.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	arbolCadenas.add(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	arbolCadenas.remove(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas, independientemente de las mayúsculas o minúsculas
     * @param cadena La cadena que se va eliminar, sin tener en cuenta las mayúsculas o minúsculas
     */
    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
    	if(arbolCadenas.size() > 0)
    	{
    		Iterator<String> iterador = arbolCadenas.iterator();
    		String c;
    		
    		while(iterador.hasNext())
    		{
    			c = iterador.next().toLowerCase();
    			if(c.equals(cadena.toLowerCase()))
    				arbolCadenas.remove(c);
    		}
    	}
    }

    /**
     * Elimina la primera cadena del conjunto
     */
    public void eliminarPrimera( )
    {
    	arbolCadenas.pollFirst();
    }

    /**
     * Reinicia el conjunto de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
    	arbolCadenas = new TreeSet<String>( );
    	
    	if(objetos.size() > 0)
    	{
    		Iterator<Object> iterador = objetos.iterator();
        	String c;
        	
        	while(iterador.hasNext())
        	{
        		c = iterador.next().toString();
        		arbolCadenas.add(c);
        	}
    	}
    	
    }

    /**
     * Modifica el conjunto de cadenas para que todas las cadenas estén en mayúsculas.
     * 
     * Note que esta operación podría modificar el órden de los elementos dentro del conjunto.
     */
    public void volverMayusculas( )
    {
    	if(arbolCadenas.size() > 0)
    	{
    		List<String> myList = new ArrayList<>();
    		Iterator<String> iterador = arbolCadenas.iterator();
    		String c;
    		
    		while(iterador.hasNext())
    		{
    			c = iterador.next().toUpperCase();
    			myList.add(c);
    		}
    		arbolCadenas = new TreeSet<String>(myList);      

    	}
    	
    }

    /**
     * Construye un árbol de cadenas donde todas las cadenas están organizadas de MAYOR a MENOR.
     */
    public TreeSet<String> invertirCadenas( )
    {
    	TreeSet<String> myTree = new TreeSet<>();
    	
    	if(arbolCadenas.size() > 0)
    		myTree = (TreeSet<String>) new TreeSet<>(arbolCadenas).descendingSet();
    	
        return myTree;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del conjunto de cadenas
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro del conjunto
     */
    public boolean compararElementos( String[] otroArreglo )
    {
    	boolean same = true;
    	List<String> strings = new ArrayList<>(arbolCadenas);
    	
    	for(String s : otroArreglo)
    	{
    		if(!strings.contains(s))
    			same = false;
    	}
    	
        return same;
    }

}
