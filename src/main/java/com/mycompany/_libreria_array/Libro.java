/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreria_array;

import java.io.Serializable;

/**
 * Classe che rappresenta un libro
 * @author Studente
 */
public class Libro implements Serializable
       
{
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina=0.05;
    private final double COSTO_FISSO=5.5;

    
    /**
     * Metodo costruttore
     * @param titolo titolo del libro
     * @param autore autore del libro
     * @param numeroPagine numero di pagine di cui è composto il libro
     */
    public Libro(String titolo, String autore, int numeroPagine)
    {   
        setTitolo(titolo);
        setAutore(autore);
        setNumeroPagine(numeroPagine);
    }
    
    /**
     * Costruttore di copia 
     * @param libro il libro da copiare
     */
    public Libro(Libro libro)
    {
        titolo=libro.getTitolo();
        autore=libro.getAutore();
        numeroPagine=libro.getNumeroPagine();
        
    }
    
    /**
     * 
     * @return il titolo del libro 
     */
    public String getTitolo()
    {
        return titolo;
    }
    
   /**
    * 
    * @return autore del libro
    */
    public String getAutore()
    {
        return autore;
    }
    
    /**
     * 
     * @return il numero di pagine
     */
    public int getNumeroPagine()
    {
        return numeroPagine;
    }
    
    /**
     * 
     * @return il costo di una pagina
     */
    public static double getCostoPagina()
    {
        return costoPagina;
    }
    
    /**
     * 
     * @return il costo fisso di ogni libro
     */
    public double getCOSTO_FISSO()
    {
        return COSTO_FISSO;
    }
    
    /**
     * assegna un autore al libro
     * @param autore 
     */
    public void setAutore(String autore)
    {
        this.autore=autore;
    }
    
    /**
     * assegna un titolo al libro
     * @param titolo 
     */
    public void setTitolo(String titolo)
    {
        this.titolo=titolo;
    }
    
    /**
     * assegna un numero di pagine al libro
     * @param numeroPagine 
     */
    public void setNumeroPagine(int numeroPagine)
    {
        this.numeroPagine=numeroPagine;
    }
    
    /**
     * assegna il costo per ogni pagina
     * @param costoP 
     */
    public static void setCostoPagina(double costoP)
    {
        costoPagina=costoP;
    }
    
    /**
     * 
     * @return restituisce il libro in formato testuale
     */
    public String toString()
    {
        String s;
        s=getTitolo()+";"+getAutore()+";"+getNumeroPagine()+";"+prezzo()+"€";
        return s;
    }
    
    /**
     * calcola il costo di ogni libro
     * @return il prezzo del libro
     */
    public double prezzo()
    {
        double p;
        p=COSTO_FISSO+(numeroPagine*costoPagina);
        return p;
    }

}

