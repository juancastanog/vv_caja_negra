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
    private static SingleLinkedListImpl<String> listaTest, listaVacia, listaUnElemento, listaAux, listaAux1;

    @BeforeEach
    public void setUp() {
        this.listaTest = new SingleLinkedListImpl<String>("A", "B", "C", "D");
        this.listaVacia = new SingleLinkedListImpl<String>();
        this.listaUnElemento = new SingleLinkedListImpl<String>("Z");
        this.listaAux = new SingleLinkedListImpl<String>("B", "C");
        this.listaAux1 = new SingleLinkedListImpl<String>("C", "D");

    }

    /*
    En la siguente clase se comprueban los siguientes casos:
    1: El elemento que se busca en la lista no existe.
    2: La lista que se pasa por parámetro está vacía
    3: Los elementos están al inicio de la lista
    4: Los elementos están situados en una posición intermedia de la lista
    5: El elemento se sitúa en la última posición
     */

    @Nested
    @DisplayName("sublist()")
    class sublist {
        @Test
        public void subListNotFound() {
            assertEquals(-1, subList(listaUnElemento));
        }

        @Test
        public void subListEmpty() {
            assertEquals(0, subList(listaVacia));
        }

        @Test
        public void subListFound1() {
            assertEquals(3, subList(listaAux1));
        }

        @Test
        public void lastPosition() {
            listaUnElemento = new SingleLinkedListImpl<String>("D");
            assertEquals(4, subList(listaUnElemento));
        }

        @Test
        public void subListFound() {
            assertEquals(2, subList(listaAux));
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