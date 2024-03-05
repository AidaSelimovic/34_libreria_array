/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreria_array;

/**
 *Rappresenta uno scaffale costituito da NUM_RIPIANI mensole, ciascuna delle quali
 * può contenere dei libri. 
 * @author Studente
 */
public class Scaffale 
{
    private Mensola[] ripiani;
    private final static int NUM_RIPIANI=5;
    
    /**
     * Costruttore
     */
    public Scaffale()
    {
        ripiani=new Mensola[NUM_RIPIANI];
        //istanzio una mensola vuota per ciascun ripiano
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            ripiani[i]=new Mensola();
        }
    }
    
    /**
     * Costruttore di copia
     * @param scaffale 
     */
    public Scaffale(Scaffale scaffale)
    {
        Libro lib;
        ripiani=new Mensola[NUM_RIPIANI];
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            ripiani[i]=new Mensola();
            for(int j=0; j<scaffale.getNumMaxLibri();j++)
            {
                lib=scaffale.getLibro(i, j);
                if(lib!=null)
                    this.setLibro(scaffale.getLibro(i, j), i, j);
            }
        }
    }
    
    /**
     * Inserisce il libro nella posizione "posizione" del ripiano “ripiano”. 
     * se il ripiano non è valido --> return -3
     * se la posizione non è valida --> return -1 
     * se la posizione non è vuota --> return -2
     * se ok  return 0
     * @param libro
     * @param ripiano
     * @param posizione
     * @return 
     */
    public int setLibro(Libro libro,int ripiano,int posizione)
    {
        int esito;
        if(ripiano<0 || ripiano>=NUM_RIPIANI)
           return -3;
        esito=ripiani[ripiano].setVolume(libro, posizione);
        if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //-1 o -2
        
    }


    /**
     * Restituisce il libro che si trova in un certo ripiano, in una certa posizione
     * @param ripiano
     * @param posizione
     * @return null se il ripiano non esiste, se la posizione non esiste o se nei dati ripiano/posizione 
     * non è presente il libro. 
     * Negli altri casi restituisce il libro.
     */
    public Libro getLibro(int ripiano, int posizione)
    {
        if(ripiano<0 || ripiano>=NUM_RIPIANI)
            return null;
        Libro lib;
        lib=ripiani[ripiano].getVolume(posizione);
        return lib;
    }
    
    /**
     * Rimuove un volume da un determinato ripiano e una determinata posizione
     * @param ripiano
     * @param posizione
     * @return se il ripiano non è valido--> return -3
     * se la posizione non è valids--> return -1
     * se la posizione è vuota--> return -2
     * se tutto ok--> return 0
     */
    public int rimuoviLibro(int ripiano, int posizione)
    {
        int esito;
        if(ripiano<0 || ripiano>=NUM_RIPIANI)
            return -3;
        esito=ripiani[ripiano].rimuoviVolume(posizione);
        if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //-1 o -2
    }
    
    /**
     * 
     * @return il numero di mensole (ripiani) presenti nello scaffale
     */
    public int getNumRipiani()
    {
        return NUM_RIPIANI;
    }
    
    /**
     * 
     * @return il numero massimo di volumi contenuti in uno scaffale
     */
    public int getNumMaxLibri()
    {
        int contatore=0;
        for(int i=0; i<NUM_RIPIANI; i++)
        {
            contatore+=ripiani[i].getNUM_MAX_VOLUMI();
        }
            
        return contatore;
    }
    
    /**
     * 
     * @return il numero di volumi presenti nello scaffale 
     */
    public int getNumLibri()
    {
        int contaVolumi=0;
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            contaVolumi+=ripiani[i].getNumVolumi();
        }
        return contaVolumi;
    }
    
    /**
     * Restituisce il numero di libri presenti in un ripiano
     * @param ripiano
     * @return se il ripiano non esiste--> return -1
     */
    public int getNumLibri(int ripiano)
    {
        if(ripiano<0 || ripiano>NUM_RIPIANI)
            return -1;
        return ripiani[ripiano].getNumVolumi();
        
    }
    
    /**
     * Restituisce il numero massimo di libri presenti in un ripiano
     * @param ripiano
     * @return se il ripiano non esiste--> return -1
     */
    public int getNumMaxLibri(int ripiano)
    {
        if(ripiano<0 || ripiano>NUM_RIPIANI)
            return -1;
        return ripiani[ripiano].getNUM_MAX_VOLUMI();
    }
    
    public String[] elencoTitoliAutore(String autore)
    {
        Libro lib;
        String elencoTitoliAutore[];
        int contaLibriAutore=0;
        for(int i=0; i<NUM_RIPIANI;i++)
        {
            for(int j=0;j<ripiani[i].getNUM_MAX_VOLUMI();j++)
            {
                lib=this.getLibro(i, j);
                if(lib!=null)
                {
                    if(lib.getAutore().equalsIgnoreCase(autore))
                    {
                        contaLibriAutore++; //sarà la dimensione dell'array
                    }
                }
            }
        }
        
        //se non ci sono libri dell'autore--> return null
        if(contaLibriAutore==0)
            return null;
        //istanzio l'array dinamicamente 
        elencoTitoliAutore=new String[contaLibriAutore];
        
        //copio i titoli dell'autore nell'array di titoli
        contaLibriAutore=0;
        for(int i=0; i<NUM_RIPIANI;i++)
        {
            for(int j=0;j<ripiani[i].getNUM_MAX_VOLUMI();j++)
            {
                lib=this.getLibro(i, j);
                if(lib!=null)
                {
                    if(lib.getAutore().equalsIgnoreCase(autore))
                    {
                        elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
                        contaLibriAutore++; //sarà la dimensione dell'array
                    }
                }
            }
        }
        return elencoTitoliAutore;
        
    }
    
    public Libro[] elencoLibriPresenti()
    {
        Libro[] elencoLibriPresenti=new Libro[getNumLibri()];
        Libro lib;
        int c=0; //contatore
        for(int i=0;i<getNumRipiani();i++)
        {
            for(int j=0;j<ripiani[i].getNUM_MAX_VOLUMI();j++)
            {
                lib=getLibro(i, j);
                if(lib!=null)
                {
                    elencoLibriPresenti[c]=lib;
                    c++;
                }
                    
            }
        }
        return elencoLibriPresenti;
    }
    
    /**
     * Restituisce una stringa che contiene i volumi presenti in ciascun scaffale
     * @return 
     */
    public String toString()
    {
        String s="";
        for(int i=0; i<NUM_RIPIANI; i++)
        {
            s+="Ripiano "+i+":\n"+ripiani[i].toString();
        }
        return s;
    }
}
