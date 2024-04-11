/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import eccezioni.FileException;
import java.io.*;


/**
 * Classe che consente di scrivere e leggere su/da un file di testo
 * Attributi:
 * mode--> indica se il file è aperto in lettura o scrittura
 *         'R'=lettura 'W'=scrittura
 * reader--> oggetto che crea il byte stream di input
 * writer--> oggetto che crea il byte stream di output
 * @author Aida
 */
public class TextFile 
{
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    /**
     * Costruttore
     * @param fileName pathname del file di testo
     * @param mode parametro che indica se si vuole aprire il file in lettura o scrittura 'R'=lettura 'W'=scrittura
     * Se mode='W' oppure 'w' il file verrà aperto in scrittura, altrimenti il file verrà aperto in lettura
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public TextFile(String fileName,char mode) throws FileNotFoundException, IOException
    {
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName));
        }
    }
    /**
     * Costruttore con append
     * @param fileName pathname del file di testo
     * @param mode  parametro che indica se si vuole aprire il file in lettura o scrittura 'R'=lettura 'W'=scrittura
     * Se mode='W' oppure 'w' il file verrà aperto in scrittura, altrimenti il file verrà aperto in lettura
     * @param append consente di specificare se il file aperto in scrittura verrà aperto in append o meno
     *               Se append=true viene aperto in append se append=false non viene aperto in append.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public TextFile(String fileName,char mode,boolean append) throws FileNotFoundException, IOException
    {
        this.mode='R';
        if(mode=='W' || mode=='w')
            this.mode='W';
        if(this.mode=='R')
        {
            reader=new BufferedReader(new FileReader(fileName));
        }
        else
        {
            writer=new BufferedWriter(new FileWriter(fileName, append));
        }
    }
    
    public void toFile(String line) throws FileException, IOException
    {
        if(this.mode=='R')
        {
            throw new FileException("File aperto in lettura");
        }
        writer.write(line);
        writer.newLine();
    }
    
    public String fromFile() throws FileException, IOException
    {
        String line;
        if(this.mode=='W')
        {
            throw new FileException("File aperto in scrittura");
        }
        line=reader.readLine();
        if(line==null) //è finito il file
            throw new FileException("Fine del file!");
        return line;
        
    }
    
    public void close() throws IOException
    {
        if(mode=='R')
            reader.close();
        else 
            writer.close();
    }
    
}
