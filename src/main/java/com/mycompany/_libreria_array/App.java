/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreria_array;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.Ordinatore;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) 
    {
        String vociMenu[];
        int numeroVoci=7;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Scaffale s1=new Scaffale(); //creo lo scaffale vuoto
        int esito=0;
        //Scanner tastiera=new Scanner (System.in);
        ConsoleInput tastiera=new ConsoleInput();
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
                case 0: //esci
                    System.out.println("Arrivederci!");
                    break;
                
                case 1: //visualizza tutti i volumi
                    System.out.println(s1.toString());
                    break;
                
                case 2: //aggiungi volume
                    try
                    {
                        System.out.println("Titolo--> ");
                        titolo=tastiera.readString();
                        System.out.println("Autore--> ");
                        autore=tastiera.readString();
                        
                        do
                        {
                            try
                            {
                                System.out.println("Numero pagine--> ");
                                numeroPagine=tastiera.readInt();
                                break; //se input ok esce dal ciclo
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto, inserisci un numero");
                            }
                        }while(true);

                        do
                        {
                            try
                            {
                                System.out.println("Ripiano(0..4)--> ");
                                ripiano=tastiera.readInt();
                                break; //se input ok esce dal ciclo
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto, inserisci un numero");
                            }
                        }while(true);
                        
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..14)--> ");
                                posizione=tastiera.readInt();
                                break; //se input ok esce dal ciclo
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto, inserisci un numero");
                            }
                        }while(true);
                        
                        try 
                        {
                            s1.setLibro(new Libro(titolo,autore,numeroPagine), ripiano, posizione);
                            System.out.println("Volume aggiunto con successo");
                        } 
                        catch (EccezioneRipianoNonValido e) 
                        {
                            System.out.println("Ripiano insesistente");
                        } 
                        catch (EccezionePosizioneNonValida e) 
                        {
                           System.out.println("Posizione insesistente");
                        } 
                        catch (EccezionePosizioneOccupata e) 
                        {
                            System.out.println("La posizione è già occupata");
                        }

                        
                    }
                    catch(IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera");
                    }
                    break;
                    
                case 3: //visualizza volume
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano(0..4)--> ");
                                ripiano=tastiera.readInt();
                                break; //se input ok esce dal ciclo
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto, inserisci un numero");
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Impossibile leggere da tastiera");
                            }
                        }while(true);

                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..14)--> ");
                                posizione=tastiera.readInt();
                                break; //se input ok esce dal ciclo
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto, inserisci un numero");
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Impossibile leggere da tastiera");
                            }
                        }while(true);
                        
                        lib=s1.getLibro(ripiano, posizione);
                        System.out.println("Libro cercato: "+lib.toString());
                    } 
                    catch (EccezioneRipianoNonValido e)
                    {
                       System.out.println("Ripiano insesistente");
                    } 
                    catch (EccezionePosizioneNonValida e) 
                    {
                        System.out.println("Posizione insesistente");
                    } 
                    catch (EccezionePosizioneVuota e) 
                    {
                        System.out.println("Libro non trovato");
                    }

                    break;

                
                case 4: //elimina volume
                    do
                    {
                        try
                        {
                            System.out.println("Ripiano(0..4)--> ");
                            ripiano=tastiera.readInt();
                            break; //se input ok esce dal ciclo
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("Formato non corretto, inserisci un numero");
                        }
                        catch (IOException ex) 
                        {
                            System.out.println("Impossibile leggere da tastiera");
                        }
                    }while(true);

                    do
                    {
                        try
                        {
                            System.out.println("Posizione (0..14)--> ");
                            posizione=tastiera.readInt();
                            break; //se input ok esce dal ciclo
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("Formato non corretto, inserisci un numero");
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Impossibile leggere da tastiera");
                        }
                    }while(true);
        
                    try 
                    {
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("Volume rimosso con successo");
                    } 
                    catch (EccezioneRipianoNonValido e) 
                    {
                         System.out.println("Ripiano insesistente");
                    } 
                    catch (EccezionePosizioneNonValida e) 
                    {
                       System.out.println("Posizione insesistente");
                    }
                    catch (EccezionePosizioneVuota e) 
                    {
                        System.out.println("La posizione è già vuota");
                    }
                
                    break;

                    
                case 5: //mostra libri autore
                   
                    try 
                    {
                        System.out.println("Autore--> ");
                        autore=tastiera.readString();
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

                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da tastiera");
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
