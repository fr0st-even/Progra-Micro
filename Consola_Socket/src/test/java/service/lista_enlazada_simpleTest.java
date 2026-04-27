/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.function.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Iosef Canchán
 */

 
public class lista_enlazada_simpleTest {
 
    private lista_enlazada_simple lista;
    private lista_enlazada_simple op;
    private final BiFunction<Object, Object, Integer> comparar = (a, b) -> a.equals(b) ? 1 : 0;
 
    @Before
    public void setUp() {
        lista = new lista_enlazada_simple();
        op = new lista_enlazada_simple();
    }
 
    @Test
    public void testEstaVacia() {
        assertTrue(op.estaVacia(null));
        Nodo n = new Nodo();
        assertFalse(op.estaVacia(n));
    }
 
    @Test
    public void testCrearMemoria() {
        Nodo n = op.crearMemoria("Hola", null);
        assertEquals("Hola", n.dato);
        assertNull(n.ptr_sig);
    }
 
    @Test
    public void testInsertarAlFrente() {
        op.insertarAlFrente(lista, "C");
        op.insertarAlFrente(lista, "B");
        op.insertarAlFrente(lista, "A");
        assertEquals("A", lista.ini.dato);
        assertEquals("B", lista.ini.ptr_sig.dato);
        assertEquals("C", lista.fin.dato);
    }
 
    @Test
    public void testInsertarAlFinal() {
        op.insertarAlFinal(lista, "A");
        op.insertarAlFinal(lista, "B");
        op.insertarAlFinal(lista, "C");
        assertEquals("A", lista.ini.dato);
        assertEquals("C", lista.fin.dato);
        assertEquals(3, op.contarElementosLista(lista.ini));
    }
 
    @Test
    public void testRemoverAlFrente() {
        int[] errno = {0};
        assertNull(op.removerAlFrente(lista, errno));
        assertEquals(1, errno[0]);
 
        op.insertarAlFinal(lista, "A");
        op.insertarAlFinal(lista, "B");
        assertEquals("A", op.removerAlFrente(lista, errno));
        assertEquals("B", lista.ini.dato);
        assertEquals("B", op.removerAlFrente(lista, errno));
        assertNull(lista.ini);
    }
 
    @Test
    public void testContarElementos() {
        assertEquals(-1, op.contarElementosLista(null));
        op.insertarAlFinal(lista, "A");
        op.insertarAlFinal(lista, "B");
        assertEquals(2, op.contarElementosLista(lista.ini));
    }
 
    @Test
    public void testImprimirLista() {
        op.insertarAlFinal(lista, "A");
        op.insertarAlFinal(lista, "B");
        StringBuilder sb = new StringBuilder();
        op.imprimirLista(lista.ini, (d) -> sb.append(d).append(","));
        assertEquals("A,B,", sb.toString());
    }
 
    @Test
    public void testBuscarElemento() {
        op.insertarAlFinal(lista, "A");
        op.insertarAlFinal(lista, "B");
        Object[] encontrado = {null};
        assertEquals(-1, op.buscarDentroDeLista(null, comparar, "A", encontrado));
        assertEquals(1, op.buscarDentroDeLista(lista.ini, comparar, "B", encontrado));
        assertEquals("B", encontrado[0]);
        assertEquals(0, op.buscarDentroDeLista(lista.ini, comparar, "Z", encontrado));
    }
 
    @Test
    public void testBuscarEnLista() {
        op.insertarAlFinal(lista, 10);
        op.insertarAlFinal(lista, 20);
        op.insertarAlFinal(lista, 30);
        op.insertarAlFinal(lista, 20);
        lista_enlazada_simple res = new lista_enlazada_simple();
        op.buscarDentroDeLista(lista.ini, comparar, 20, res);
        assertEquals(2, op.contarElementosLista(res.ini));
        assertEquals(20, res.ini.dato);
    }
}
