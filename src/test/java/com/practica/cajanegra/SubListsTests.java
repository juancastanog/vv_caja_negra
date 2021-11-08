package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

@DisplayName("Tests que incluyen los de tipo SubList")
class SubListsTests {
    private static SingleLinkedListImpl<String> listaTest, listaVacia, listaFinal, listaFinalFalla, listaIni, listaMid, listaInicioFalla, listaNoContenida;

    @BeforeEach
    public void setUp() {
        this.listaTest = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        this.listaVacia = new SingleLinkedListImpl<String>();
        this.listaFinal = new SingleLinkedListImpl<String>("Y","Z");
        this.listaInicioFalla = new SingleLinkedListImpl<String>("X", "A");
        this.listaFinalFalla = new SingleLinkedListImpl<String>("A", "C");
        this.listaIni = new SingleLinkedListImpl<String>("A", "B");
        this.listaMid = new SingleLinkedListImpl<String>("B", "M", "Y");
        this.listaNoContenida = new SingleLinkedListImpl<String>("E","R");
    }

    /*
    En la siguente clase se comprueban los siguientes casos:
    1: El elemento que se busca en la lista no existe.
    2: La lista que se pasa por par�metro est� vac�a
    3: Los elementos est�n al inicio de la lista
    4: Los elementos est�n situados en una posici�n intermedia de la lista
    5: El elemento se sit�a en la �ltima posici�n
     */

    @Nested
    @DisplayName("sublist()")
    class sublist {

        //SubLista en la primera posición
        @Test
        public void subListIni() {
            assertEquals(1, subList(listaIni));
        }

        //La sublista está en la última posición
        @Test
        public void lastPosition() {
            listaFinal = new SingleLinkedListImpl<String>("Z");
            assertEquals(5, subList(listaFinal));
        }

        //La sublista comienza en una posición intermedia
        @Test
        public void subListFoundInMid() {
            assertEquals(2, subList(listaMid));
        }

        //El primer elemento no está en la lista y el resto sí
        @Test
        public void subListInicioFalla() {
            assertEquals(-1, subList(listaInicioFalla));
        }

        //El último elemento no está en la lista y el resto sí
        @Test
        public void subListFinalFalla() {
            assertEquals(-1, subList(listaFinalFalla));
        }
        
        @Test
        public void subListEmpty() {
            assertEquals(0, subList(listaVacia));
        }

        @Test
        public void subListNotFound() {
            assertEquals(-1, subList(listaNoContenida));
        }

    }

    public int subList(AbstractSingleLinkedListImpl<String> part) {
        if (part.isEmpty()) {
            return 0;
        }
        int primPos = 0, auxCont = 0;
        boolean encontrado = false;
        boolean startSubList = false;
        Iterator iterator1 = part.iterator();
        for (Iterator iterator = listaTest.iterator(); iterator.hasNext() && !encontrado; ) {
            String actString = (String) iterator.next();
            String aux = (String) iterator1.next();
            primPos++;
            if (actString.equals(aux)) {
                if (!startSubList) {
                    auxCont = primPos;
                    startSubList = !startSubList;
                }
                if (!iterator1.hasNext()) {
                    encontrado = true;
                }
            } else if (!actString.equals(iterator1)) {
                iterator1 = part.iterator();
                startSubList = false;
            }
        }
        if (encontrado)
            return auxCont;
        else
            return -1;
    }
}