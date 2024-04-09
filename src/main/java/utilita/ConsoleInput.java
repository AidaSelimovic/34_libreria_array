/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *Rappresenta un dispositivo per acquisisre dati ei input di ciascun tipo nativo e di tipo String dalla console
 * di input, ossia dalla tastiera.
 * Esempio:
 * ConsoleInput tastiera=new ConsoleInput();
 * tastiera.readString--> restituisce una stringa inserita con la tastiera
 * tastiera.readInt--> restituisce un numero intero inserito con la tastiera
 * @author Studente
 */
public class ConsoleInput 
{
    private InputStreamReader reader;
    private BufferedReader tastiera;
    
    /**
     * Costruttore
     */
    public ConsoleInput()
    {
        reader=new InputStreamReader(System.in);
        tastiera=new BufferedReader(reader);
        
    }
    
    /**
     * Legge una stringa da tastiera
     * @return la stringa letta
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     */
    public String readString() throws IOException, NumberFormatException
    {
        return tastiera.readLine();
    }
    
    /**
     * Legge un intero da tastiera
     * @return l'intero letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     * se viene inserito un valore che non è intero, ad esempio "3.2" o "ciao".
     */
    public int readInt() throws IOException, NumberFormatException
    {
        String s=tastiera.readLine();
        int x=Integer.parseInt(s);
        return x;
    }
    
    /**
     * Legge uno short da tastiera
     * @return lo short letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     * se viene inserito un valore che non è short, ad esempio numero troppo grande,"10.2" o "ciao".
     */
    public short readShort() throws IOException, NumberFormatException
    {
        return Short.parseShort(tastiera.readLine());
    }
    
    /**
     * Legge un carattere da tastiera, se vengono inseriti più caratteri restiuisce solo il primo dei caratteri letti
     * @return solo il primo carattere della stringa letta
     * @throws IOException Errore di input
     */
    public char readChar() throws IOException, NumberFormatException
    {
        return tastiera.readLine().charAt(0);
    }
    
     /**
     * Legge un long da tastiera
     * @return il long letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     * se viene inserito un valore che non è long, ad esempio numero troppo grande, "10.2" o "ciao"
     */
    public Long readLong() throws IOException, NumberFormatException
    {
        return Long.parseLong(tastiera.readLine());
    }
    
     /**
     * Legge un float da tastiera
     * @return il float letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     * ad esempio "ciao"
     */
    public float readFloat() throws IOException, NumberFormatException
    {
        return Float.parseFloat(tastiera.readLine());
    }
    
    /**
     * Legge un double da tastiera
     * @return il double letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     * ad esempio "ciao"
     */
    public double readDouble() throws IOException, NumberFormatException
    {
        return Double.parseDouble(tastiera.readLine());
    }
    
     /**
     * Legge un booleano da tastiera
     * @return true se il valore letto è true, false se il valore è qualsiasi cosa diverso da true
     * @throws IOException Errore di input
     */
    public Boolean readBoolean() throws IOException, NumberFormatException
    {
        return Boolean.parseBoolean(tastiera.readLine());
    }
    
     /**
     * Legge un byte da tastiera
     * @return il byte letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     * ad esempio "ciao" o -129 o 128 perchè sfora il range
     */
    public byte readByte() throws IOException, NumberFormatException
    {
        return Byte.parseByte(tastiera.readLine());
    }
    
    
}
