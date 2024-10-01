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
  Nodo inicio;
    listaDoble() {
        inicio = null;
    }
      public void insertarFinal(String nombre, int age) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAtras(null);
        nuevo.setSiguiente(null);
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            inicio = nuevo;
        }
        else {
            
            Nodo temporal = inicio;
            while(temporal.getSiguiente()!=null) {
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevo);
            nuevo.setAtras(temporal);
        }
    }
      
     public void posicion(int indice){
     Nodo temp = inicio;
     String siguiente ="";
     String atras="";
     int contador=0;
     while(temp.getSiguiente()!=null && contador!=indice){
     temp =temp.getSiguiente();
     contador+=1;
     }
     if(temp.getAtras()!=null){
         atras="el anterior es "+temp.getAtras().getName()+" y ";
     
     }else{
     atras="eres el primero y ";
     }
         if (temp.getSiguiente()!=null) {
             siguiente = "el siguiente es "+temp.getSiguiente().getName()+"";
         }else{
         siguiente="eres el ultimo";
         }
     
     JOptionPane.showMessageDialog(null, atras + siguiente);
     
     }
     
     public void mayores(){
     Nodo temp = inicio;
     String nombre ="";
     
     int contador=0;
     while(temp!=null){
         if(temp.getAge()>=18){
           nombre = nombre+" "+temp.getName()+" su posicion es "+contador+"\n";
         }
     temp =temp.getSiguiente();
     contador+=1;
     }
         if (nombre.equals("")) {
             nombre="no hay mayores";
         }
     JOptionPane.showMessageDialog(null, nombre);
     }
     
     
     
     public void eliminar(){
      int posicion = 1;
        Nodo anterior = inicio;
        Nodo siguiente = null;
        
        while (anterior!=null) {
            
            if (siguiente == null && posicion == 1 && anterior.getAge()<18) {
                Nodo enlaceTemporal = anterior.getSiguiente();
                while(enlaceTemporal.getAge()<18) {
                    enlaceTemporal = enlaceTemporal.getSiguiente();
                }
                inicio = enlaceTemporal;
                enlaceTemporal.setAtras(null);
            }
            
           if (siguiente != null && siguiente.getAge()<18) {
                Nodo enlaceTemporal = anterior.getSiguiente();
                while(enlaceTemporal!=null && enlaceTemporal.getAge()<18) {
                    enlaceTemporal = enlaceTemporal.getSiguiente();
                }
                anterior.setSiguiente(enlaceTemporal);
                
                if(enlaceTemporal!=null){
                enlaceTemporal.setAtras(anterior);}
                
            }
           
           anterior = anterior.getSiguiente();
            if (anterior==null) {
                break;
            }
            siguiente = anterior.getSiguiente();
            posicion++;
        }
    
     
     }
     
     public void listar(){
     Nodo nodo = inicio;
     String lista="";
     while(nodo!=null){
     
     lista += " nombre: "+nodo.getName()+" y edad: "+nodo.getAge();
     nodo=nodo.getSiguiente();
     }
     JOptionPane.showMessageDialog(null, lista);
     
     }
      
      
}
