/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreria_array;

import java.util.*;
import utilita.Menu;
import utilita.Ordinatore;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) 
    {
        /*
        int esito;
        String titoloDaCercare;
        Libro l1=new Libro("I promessi sposi", "Manzoni", 360);
        Libro l2=new Libro("La divina commedia", "Dante", 250);
        
        Scanner tastiera=new Scanner(System.in);
        /*
        //istanzio una mensola
        Mensola m1=new Mensola();
        
        //test: aggiunta di libro in posizone valida
        esito=m1.setVolume(l1, 0);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già occupata");
        else
            System.out.println("Volume aggiunto correttamente in posizione "+esito);
            
        //test: aggiunta di libro in posizone non valida
        esito=m1.setVolume(l1, 15);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già occupata");
        else
            System.out.println("Volume aggiunto correttamente in posizione "+esito);
        
        //test: aggiunta di libro in posizone occupata
        esito=m1.setVolume(l1, 0);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già occupata");
        else
            System.out.println("Volume aggiunto correttamente in posizione "+esito);
        
        //test: recupero di un libro in posizone valida
        Libro lib;
        lib=m1.getVolume( 0);
        if(lib==null)
            System.out.println("Posizione non valida o vuota");
        else
            System.out.println("Volume: "+lib.toString());
        
        //test: recupero di un libro in posizione non valida
        lib=m1.getVolume( -1);
        if(lib==null)
            System.out.println("Posizione non valida o vuota");
        else
            System.out.println("Volume: "+lib.toString());
        
        //test: recupero di un libro in posizione vuota
        lib=m1.getVolume( 2);
        if(lib==null)
            System.out.println("Posizione non valida o vuota");
        else
            System.out.println("Volume: "+lib.toString());
        
        //test: rimozione di un libro in posizione non valida
        esito=m1.rimuoviVolume(-1);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già vuota, nessun libro è stato rimosso");
        else
            System.out.println("Libro rimosso con successo");
       
        //test: rimozione di un libro in posizione già vuota
        esito=m1.rimuoviVolume(1);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già vuota, nessun libro è stato rimosso");
        else
            System.out.println("Libro rimosso con successo");
        
        //test: rimozione di un libro in posizione valida
        esito=m1.rimuoviVolume(0);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già vuota, nessun libro è stato rimosso");
        else
            System.out.println("Libro rimosso con successo");
        
        //test: massimo numero di libri
        System.out.println("Numero massimo di libri "+ m1.getNUM_MAX_VOLUMI());
        
        //aggiunta di due volumi
        esito=m1.setVolume(l1, 3);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già occupata");
        else
            System.out.println("Volume aggiunto correttamente in posizione "+esito);
        
        esito=m1.setVolume(l2, 4);
        if(esito==-1)
            System.out.println("Posizione non valida");
        else if(esito==-2)
            System.out.println("Posizione già occupata");
        else
            System.out.println("Volume aggiunto correttamente in posizione "+esito);
        
        //test: numero di libri presenti nella libreria
        System.out.println("I libri presenti nella libreria sono "+m1.getNumVolumi());
        
        //test: toString()
        System.out.println("Mensola:\n"+m1.toString());
        
        //test: costruttore di copia
        Mensola m2=new Mensola(m1);
        
        m2.rimuoviVolume(4);
        System.out.println("M1:\n "+m1.toString());
        System.out.println("M2:\n "+m2.toString());
        
        //test: presenza titolo
        
        System.out.println("Inserisci il titolo da cercare--> ");
        titoloDaCercare=tastiera.nextLine();
        if(m1.presenzaTitolo(titoloDaCercare))
            System.out.println("Il titolo è presente");
        else
            System.out.println("Il titolo non è presente");
        */
        //test: aggiungere libro allo scaffale
        /*Scaffale s1=new Scaffale();
        /*esito=s1.setLibro(l1, 0, 5);
        if(esito==-3)
            System.out.println("Ripiano insesistente");
        else if(esito==-1)
            System.out.println("Posizione insesistente");
        else if(esito==-2)
            System.out.println("La posizione è già occupata");
        else
            System.out.println("Volume aggiunto con successo");
        
        //test: getLibro
        Libro lib;
        lib=s1.getLibro(0,5);
        if(lib==null)
            System.out.println("Libro non presente nel ripiano/posizione indicati");
        else
            System.out.println("Il libro è: "+lib.toString());
        
  
        
        //test numero massimo di libri
        System.out.println("numero ripiani: "+s1.getNumRipiani());
        System.out.println("numero massimo volumi: "+s1.getNumMaxLibri());
        
        
        //Scaffale s2 copia di s1
        Scaffale s2=new Scaffale(s1);
        //test: rimuovi libro
        esito=s1.rimuoviLibro( 0, 5);
        if(esito==-3)
            System.out.println("Ripiano insesistente");
        else if(esito==-1)
            System.out.println("Posizione insesistente");
        else if(esito==-2)
            System.out.println("La posizione è vuota");
        else
            System.out.println("Volume rimosso con successo");
        
        //test di un libro rimosso e poi non trovato
        lib=s1.getLibro(0,5);
        if(lib==null)
            System.out.println("Libro non presente nel ripiano/posizione indicati");
        else
            System.out.println("Il libro è: "+lib.toString());
        
        
        System.out.println("Scaffale s1: "+s1.toString());
        System.out.println("Scaffale s2: "+s2.toString());*/
        
        
        /*Libro l3=new Libro("Adelchi", "Manzoni", 241);
        
        esito=s1.setLibro(l1, 0, 0);
        if(esito==-3)
            System.out.println("Ripiano insesistente");
        else if(esito==-1)
            System.out.println("Posizione insesistente");
        else if(esito==-2)
            System.out.println("La posizione è già occupata");
        else
            System.out.println("Volume aggiunto con successo");
        
        esito=s1.setLibro(l2, 0, 1);
        if(esito==-3)
            System.out.println("Ripiano insesistente");
        else if(esito==-1)
            System.out.println("Posizione insesistente");
        else if(esito==-2)
            System.out.println("La posizione è già occupata");
        else
            System.out.println("Volume aggiunto con successo");
        
        esito=s1.setLibro(l3, 0,2);
        if(esito==-3)
            System.out.println("Ripiano insesistente");
        else if(esito==-1)
            System.out.println("Posizione insesistente");
        else if(esito==-2)
            System.out.println("La posizione è già occupata");
        else
            System.out.println("Volume aggiunto con successo");
        
        //cerco i libri di Manzoni
        String elencoTitoli[];
        elencoTitoli=s1.elencoTitoliAutore("Manzoni");
        System.out.println("Libri di Manzoni presenti: ");
        if(elencoTitoli==null)
            System.out.println("Nessun libro presente");
        else
        {
            for(int i=0;i<elencoTitoli.length;i++)
            {
                System.out.println(elencoTitoli[i]);
            }
        }
        
        //test costruttore mensola con array di libri
        Libro[] elencoLibri2=new Libro[3];
        elencoLibri2[0]=l1;
        elencoLibri2[1]=l2;
        elencoLibri2[2]=l3;
        
        Mensola m2=new Mensola(elencoLibri2);
        System.out.println("Mensola m2: \n"+m2.toString());*/
        
        String vociMenu[];
        int numeroVoci=7;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Scaffale s1=new Scaffale(); //creo lo scaffale vuoto
        int esito=0;
        Scanner tastiera=new Scanner (System.in);
        String titolo,autore;
        int numeroPagine;
        Libro lib;
        int ripiano,posizione;
        String elencoTitoliAutore[];
        Libro[] libriPresenti;
        
        vociMenu[0]="0\t--> Esci";
        vociMenu[1]="1\t--> Visualizza tutti i volumi presenti";
        vociMenu[2]="2\t--> Aggiungi un volume";
        vociMenu[3]="3\t--> Visualizza volume (ripiano, posizione)";
        vociMenu[4]="4\t--> Elimina volume (ripiano, posizione)";
        vociMenu[5]="5\t--> Mostra libri di un autore";
        vociMenu[6]="6\t--> Mostra libri presenti in ordine alfabetico di titolo";
        
        
        menu=new Menu(vociMenu);
        
        //gestione menu:
        do
        {
            System.out.println("Menu: ");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                
                case 1:
                    System.out.println(s1.toString());
                    break;
                
                case 2:
                    //svuoto buffer input
                    System.out.println("Premi invio per continuare");
                    tastiera.nextLine();
                    System.out.println("Titolo--> ");
                    titolo=tastiera.nextLine();
                    System.out.println("Autore--> ");
                    autore=tastiera.nextLine();
                    System.out.println("Numero pagine--> ");
                    numeroPagine=tastiera.nextInt();
                    System.out.println("Ripiano(0..4)--> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14)--> ");
                    posizione=tastiera.nextInt();
                    
                    
                    esito=s1.setLibro(new Libro(titolo,autore,numeroPagine), ripiano, posizione);
                    if(esito==-3)
                        System.out.println("Ripiano insesistente");
                    else if(esito==-1)
                        System.out.println("Posizione insesistente");
                    else if(esito==-2)
                        System.out.println("La posizione è già occupata");
                    else
                        System.out.println("Volume aggiunto con successo");
                    break;
               
                case 3:
                    System.out.println("Ripiano(0..4)--> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14)--> ");
                    posizione=tastiera.nextInt();
                    lib=s1.getLibro(ripiano, posizione);
                    if(lib==null)
                        System.out.println("Libro non trovato");
                    else
                        System.out.println("Libro cercato: "+lib.toString());
                    break;
                
                case 4:
                    System.out.println("Ripiano(0..4)--> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14)--> ");
                    posizione=tastiera.nextInt();
                    
                    esito=s1.rimuoviLibro(ripiano, posizione);
                    if(esito==-3)
                        System.out.println("Ripiano insesistente");
                    else if(esito==-1)
                        System.out.println("Posizione insesistente");
                    else if(esito==-2)
                        System.out.println("La posizione è già vuota");
                    else
                        System.out.println("Volume rimosso con successo");
                    break;
                    
                case 5:
                    System.out.println("Premi invio per continuare");
                    tastiera.nextLine();
                    System.out.println("Autore--> ");
                    autore=tastiera.nextLine();
                    elencoTitoliAutore=s1.elencoTitoliAutore(autore);
                    if(elencoTitoliAutore==null)
                        System.out.println("Nessun libro presente");
                    else
                    {
                        for(int i=0;i<elencoTitoliAutore.length; i++)
                        {
                            System.out.println(elencoTitoliAutore[i]);
                        }
                    }
                        
                    break;
                case 6:
                    libriPresenti=s1.elencoLibriPresenti();
                    libriPresenti=Ordinatore.selectionSortCrescenteLibri(libriPresenti);
                    for(int i=0;i<libriPresenti.length;i++)
                    {
                        System.out.println(libriPresenti[i].toString());
                    }
                    break;
            
            }

        }while(voceScelta!=0);
                
    }
}
