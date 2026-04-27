/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.function.*;
/**
 *
 * @author Iosef Canchán
 */
public class lista_enlazada_simple {
    Nodo ini;
    Nodo fin;
    
    
    boolean estaVacia(Nodo ini){
        return ini == null;
    }
    
    Nodo crearMemoria(Object dato, Nodo ptr_sig){
        Nodo tmp = new Nodo();
        if(tmp != null){
            tmp.dato = dato;
            tmp.ptr_sig = ptr_sig;
        }
        return tmp;
    }
    
    void insertarAlFrente(lista_enlazada_simple lista, Object inf){
        if(estaVacia(lista.ini)){
            lista.ini = lista.fin = crearMemoria(inf, null);
        } else{
            Nodo nuevo = crearMemoria(inf, lista.ini);
            lista.ini = nuevo; 
        }
    }
    
    void insertarAlFinal(lista_enlazada_simple lista, Object inf){
        if(estaVacia(lista.ini)){
            lista.ini = lista.fin = crearMemoria(inf, null);
        } else{
            Nodo nuevo = crearMemoria(inf, null);
            lista.fin.ptr_sig =  nuevo;
            lista.fin = nuevo;
        }
    }
    
    Object removerAlFrente(lista_enlazada_simple lista, int[] errno){
        if(estaVacia(lista.ini)){
            errno[0] = 1;
            return null;
        }
        
        Object dato = lista.ini;
        
        if(lista.ini == lista.fin){
            lista.ini = lista.fin = null;
        } else{
            lista.ini = lista.ini.ptr_sig;
        }
        
        errno[0] = 0;
        return dato;
    }
    
    void imprimirLista(Nodo ini, Consumer<Object> func){
        Nodo actual = ini;
        
        if(null == ini){
            System.out.println("La lista esta vacia\n");
            return;
        }
        while(actual != null){
            func.accept(actual.dato);
            actual = actual.ptr_sig;
        }
        System.out.println("\n");
    }
    
    int contarElementosLista(Nodo ini){
        int contador = 0;
        Nodo actual = ini;
        
        if(null == ini){
            contador = -1;
            return contador;
        }
        while(actual != null){
            contador++;
            actual = actual.ptr_sig;
        }
        return contador;
    }
    
    int buscarDentroDeLista(Nodo ini, BiFunction<Object,Object,Integer> func, Object clave, Object[] i){
        Nodo actual = ini;
        if(null == ini){
            return -1;
        }
        while(actual != null){
            if(func.apply(actual.dato, clave)==1){
                i[0] = actual.dato;
                return 1;
            }
            actual = actual.ptr_sig;
        }
        return 0;
    }
    
    void buscarDentroDeLista(Nodo ini, BiFunction<Object,Object,Integer> func,Object clave,lista_enlazada_simple lista ){
        Nodo actual = ini;
        if(null == ini){
            System.out.println("La lista esta vacia\n");
            return;
        }
        while(actual != null){
            if(func.apply(actual.dato, clave) == 1){
                insertarAlFinal(lista, actual.dato);
            }
            actual = actual.ptr_sig;
        }
    }
}
