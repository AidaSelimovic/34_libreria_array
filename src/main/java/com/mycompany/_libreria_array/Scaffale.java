/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreria_array;

import eccezioni.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.TextFile;

/**
 *Rappresenta uno scaffale costituito da NUM_RIPIANI mensole, ciascuna delle quali
 * può contenere dei libri. 
 * @author Studente
 */
public class Scaffale implements Serializable
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
                try 
                {
                    lib=scaffale.getLibro(i, j);
                    this.setLibro(lib, i, j);
                } 
                catch (EccezioneRipianoNonValido e) 
                {
                   //non succederà mai
                } 
                catch (EccezionePosizioneNonValida e) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneVuota e) 
                {
                    //non fare nulla
                } 
                catch (EccezionePosizioneOccupata e)
                {
                   //non fare nulla
                }
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
    public void setLibro(Libro libro,int ripiano,int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        if(ripiano<0 || ripiano>=NUM_RIPIANI)
           throw new EccezioneRipianoNonValido();
        ripiani[ripiano].setVolume(libro, posizione);
        /*if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //-1 o -2*/
        
    }


    /**
     * Restituisce il libro che si trova in un certo ripiano, in una certa posizione
     * @param ripiano
     * @param posizione
     * @return null se il ripiano non esiste, se la posizione non esiste o se nei dati ripiano/posizione 
     * non è presente il libro. 
     * Negli altri casi restituisce il libro.
     */
    public Libro getLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if(ripiano<0 || ripiano>=NUM_RIPIANI)
           throw new EccezioneRipianoNonValido();
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
    public void rimuoviLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if(ripiano<0 || ripiano>=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        ripiani[ripiano].rimuoviVolume(posizione);
        /*if(esito>=0)
            return 0; //tutto ok
        else
            return esito; //-1 o -2*/
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
                try 
                {
                    lib=this.getLibro(i, j);
                    if(lib.getAutore().equalsIgnoreCase(autore))
                    {
                        contaLibriAutore++; //sarà la dimensione dell'array
                    }
                } 
                catch (EccezioneRipianoNonValido e) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneNonValida e) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneVuota e) 
                {
                    //non fare nulla
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
                try 
                {
                    lib=this.getLibro(i, j);
                    if(lib.getAutore().equalsIgnoreCase(autore))
                    {
                        elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
                        contaLibriAutore++; //sarà la dimensione dell'array
                    }
                } 
                catch (EccezioneRipianoNonValido e) 
                {
                   //non succederà mai
                } 
                catch (EccezionePosizioneNonValida e) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneVuota e) 
                {
                    //non fare nulla
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
                try 
                {
                    lib=getLibro(i, j);
                    elencoLibriPresenti[c]=lib;
                    c++;
                } 
                catch (EccezioneRipianoNonValido e) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneNonValida e) 
                {
                   //non succederà mai
                } 
                catch (EccezionePosizioneVuota e) 
                {
                   //non fare nulla
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
    
    public void esportaCSV(String fileName) throws IOException, FileException
    {
        TextFile f1=new TextFile(fileName,'W');
        Libro lib;
        String datiVolume;
        for(int i=0;i<getNumRipiani();i++)
        {
            for(int j=0;j<getNumMaxLibri(i);j++)
            {
                try 
                {
                    lib=this.getLibro(i, j);
                    datiVolume=i+";"+j+";"+lib.getTitolo()+";"+lib.getAutore()+";"+lib.getNumeroPagine();
                    f1.toFile(datiVolume);
                    
                } 
                catch (EccezioneRipianoNonValido ex) 
                {
                   //mai
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //mai
                } 
                catch (EccezionePosizioneVuota ex) 
                {
                    //niente
                }
            }
        }
        
        f1.close();
        
    }
    
    public void importaCSV(String fileName) throws IOException
    {
        TextFile f1=new TextFile(fileName,'R');
        String rigaLetta;
        String datiLibro[];
        String titolo, autore;
        int numeroPagine, ripiano, posizione;
        Libro lib;
        try 
        {
            while(true)
            {
                
                rigaLetta=f1.fromFile();
                datiLibro=rigaLetta.split(";");
                ripiano=Integer.parseInt(datiLibro[0]); //convertito datiLibro in un intero e passato all'array di stringhe
                posizione=Integer.parseInt(datiLibro[1]); 
                titolo=datiLibro[2];
                autore=datiLibro[3];
                numeroPagine=Integer.parseInt(datiLibro[4]); 
                lib=new Libro(titolo, autore, numeroPagine);
                try 
                {
                    this.setLibro(lib, ripiano, posizione);
                } 
                catch (EccezioneRipianoNonValido ex) 
                {
                    //non fa nulla, il libro non viene posizionato nello scaffale
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                   //non fa nulla, il libro non viene posizionato nello scaffale
                } 
                catch (EccezionePosizioneOccupata ex) 
                {
                    //non fa nulla, il libro non viene posizionato nello scaffale
                }
            } 
        }
        catch (FileException ex) 
        {
            //file finito
            f1.close();
        }
    }
    
    public void salvaScaffale(String fileName) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(fileName));
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    public Scaffale caricaScaffale (String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Scaffale s;
        ObjectInputStream reader=new ObjectInputStream(new FileInputStream (fileName));
        s=(Scaffale) reader.readObject();
        reader.close();
        return s;
    }
}
