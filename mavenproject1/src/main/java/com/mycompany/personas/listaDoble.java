/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.personas;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-16
 */
public class listaDoble {

    int contador2 = 0;
    Nodo inicio;

    listaDoble() {
        inicio = null;
    }

    public void insertarFinal(String nombre, int age) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAtras(nuevo);
        nuevo.setSiguiente(nuevo);
        contador2 += 1;
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            inicio = nuevo;
        } else {

            Nodo temporal = inicio;
            Nodo temp = inicio;
            while (temporal.getSiguiente() != inicio) {
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevo);
            nuevo.setAtras(temporal);
            nuevo.setSiguiente(temp);
            temp.setAtras(nuevo);
        }
    }

    public void posicion(int indice) {
        if(indice<=contador2 && indice>0 ){
        Nodo temp = inicio;
        String siguiente = "";
        String atras = "";
        int contador = 0;
        if (inicio != null) {
            while (temp.getSiguiente() != null && contador != indice-1) {
                temp = temp.getSiguiente();
                contador += 1;
            }
            if (temp.getAtras() != null) {
                atras = "el anterior es " + temp.getAtras().getName() + " y ";

            } else {
                atras = "eres el primero y ";
            }
            if (temp.getSiguiente() != null) {
                siguiente = "el siguiente es " + temp.getSiguiente().getName() + "";
            } else {
                siguiente = "eres el ultimo";
            }

            JOptionPane.showMessageDialog(null, atras + siguiente);

        } else {
            JOptionPane.showMessageDialog(null, "no hay nadie");
        }}else{
                    JOptionPane.showMessageDialog(null, "el indice no es valido intentelo de nuevo");

        }
    }

    public void mayores() {
        Nodo temp = inicio;
        String nombre = "";
        int n=0;
        int contador = 0;
        if (inicio != null) {
            while (contador2!=n) {
                n++;
                if (temp.getAge() >= 18) {
                    nombre = nombre + " " + temp.getName() + " su posicion es " + (contador+1) + "\n";
                }
                temp = temp.getSiguiente();
                contador += 1;
            }
            if (nombre.equals("")) {
                nombre = "no hay mayores";
            }
            JOptionPane.showMessageDialog(null, nombre);
        } else {
            JOptionPane.showMessageDialog(null, "no hay nadie");
        }

    }
    public void eliminarIndice(int indice){
    int posicion = 1;
        Nodo anterior = inicio;
        Nodo siguiente = null;
    
    }

    public void eliminar() {
        int posicion = 1;
        Nodo anterior = inicio;
        Nodo siguiente = null;

        while (anterior != null) {

            if (siguiente == null && posicion == 1 && anterior.getAge() < 18) {
                Nodo enlaceTemporal = anterior.getSiguiente();
                while (enlaceTemporal.getAge() < 18) {
                    enlaceTemporal = enlaceTemporal.getSiguiente();
                    contador2--;
                }
                inicio = enlaceTemporal;
                enlaceTemporal.setAtras(null);
            }

            if (siguiente != null && siguiente.getAge() < 18) {
                Nodo enlaceTemporal = anterior.getSiguiente();
                while (enlaceTemporal != null && enlaceTemporal.getAge() < 18) {
                    enlaceTemporal = enlaceTemporal.getSiguiente();
                      contador2--;
                }
                anterior.getAtras().setSiguiente(enlaceTemporal);

                if (enlaceTemporal != null) {
                    enlaceTemporal.setAtras(anterior.getAtras());
                }

            }

            anterior = anterior.getSiguiente();
            if (anterior == null) {
                break;
            }
            siguiente = anterior;
            posicion++;
        }

    }

    public void listar() {
        Nodo nodo = inicio;
        int n=0;
        String lista = "";
        while (contador2!=n) {
            n++;
            lista += " nombre: " + nodo.getName() + " y edad: " + nodo.getAge()+"\n";
            nodo = nodo.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, lista);

    }

}
