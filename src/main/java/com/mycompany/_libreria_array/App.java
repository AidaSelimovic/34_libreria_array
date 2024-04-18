/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreria_array;

import eccezioni.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import utilita.*;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) 
    {
        String vociMenu[];
        int numeroVoci=11;
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
        String nomeFile="volumi.csv";
        String nomeFileBinario="Scaffale.bin";
        
        vociMenu[0]="--> Esci";
        vociMenu[1]="--> Visualizza tutti i volumi presenti";
        vociMenu[2]="--> Aggiungi un volume";
        vociMenu[3]="--> Visualizza volume (ripiano, posizione)";
        vociMenu[4]="--> Elimina volume (ripiano, posizione)";
        vociMenu[5]="--> Mostra libri di un autore";
        vociMenu[6]="--> Mostra libri presenti in ordine alfabetico di titolo";
        vociMenu[7]="--> Esporta i volumi su file CSV";
        vociMenu[8]="--> Importa i volumi da file CSV";
        vociMenu[9]="--> Salva dati Scaffale";
        vociMenu[10]="--> Carica dati Scaffale";
        
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
                case 7: //esporta su file csv
                    try 
                    {
                        s1.esportaCSV(nomeFile);
                        System.out.println("Esportazione avvenuta con successo!");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore di scrittura, impossibile accedere al file");
                    } 
                    catch (FileException ex) 
                    {
                        System.out.println("Errore, file aperto in lettura");
                    }
                
                    break;
                case 8:
                    try 
                    {
                        s1.importaCSV(nomeFile);
                        System.out.println("Importazione avvenuta con successo!!");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere dal file");
                    }
                
                    break;
                case 9:
                    try 
                    {
                        s1.salvaScaffale(nomeFileBinario);
                        System.out.println("Salvataggio avvenuto correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile salvare su file");
                    }
                    break;
                case 10:
                    try 
                    {
                        s1=s1.caricaScaffale(nomeFileBinario);
                        System.out.println("Caricamento avvenuto con successo");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("Impossibile leggere i dati dallo scaffale");
                    }
                    break;
            }

        }while(voceScelta!=0);
                
    }
}
