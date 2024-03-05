/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import com.mycompany._libreria_array.Libro;

/**
 *
 * @author Studente
 */
public class Ordinatore 
{
    /**
     * Scambia un numero in pos1 con un numero in pos2 dell'array a
     * @param a
     * @param pos1
     * @param pos2 
     */
    public static void scambia(int []a,int pos1,int pos2)
    {
        int s;
        s=a[pos1];
        a[pos1]=a[pos2];
        a[pos2]=s;
    }
    
    /**
     * Ordina in modo crescente gli elementi di un array di interi utilizzando l'algoritmo selectionSort
     * @param a array da ordinare
     * @return copia dell'array ordinato
     */
    public static int[] selectionSortCrescente(int[] a)
    {
        //creo una copia di a
        
        int v[]=new int[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
             v[i]=a[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(v[j]<v[i])
                    scambia(v, i, j);
            }
        }
        return v;
    }
    
     /**
     * Ordina in modo decrescente gli elementi di un array di interi utilizzando l'algoritmo selectionSort
     * @param a array da ordinare
     * @return copia dell'array ordinato
     */
    public static int[] selectionSortDecrescente(int[] a)
    {
        //creo una copia di a
        
        int v[]=new int[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(v[j]>v[i])
                    scambia(v, i, j);
            }
        }
        return v;
    }
    
    /**
     * Scambia il valore in pos1 con uno in pos2 dell'array di stringhe a
     * @param a
     * @param pos1
     * @param pos2 
     */
    public static void scambia(String []a,int pos1,int pos2)
    {
        String s;
        s=a[pos1];
        a[pos1]=a[pos2];
        a[pos2]=s;
    }
    
    public static String[] selectionSortCrescente(String[] a)
    {
        //creo una copia di a
        
        String v[]=new String[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(v[j].compareTo(v[i])<0)
                    scambia(v, i, j);
            }
        }
        return v;
    }
    public static String[] selectionSortDecrescente(String[] a)
    {
        //creo una copia di a
        
        String v[]=new String[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(v[j].compareTo(v[i])>0)
                    scambia(v, i, j);
            }
        }
        return v;
    }
    
    public static int [] bubbleSortCrescente(int [] a)
    {
        int v[]=new int[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        boolean scambioAvvenuto=true;
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if(v[i]>v[i+1])
                {
                    scambia(v,i, i+1);
                    scambioAvvenuto=true;
                }
                    
            }
                
        }while(scambioAvvenuto==true);
      return v;  
    }
    
    public static int [] bubbleSortDecrescente(int [] a)
    {
        int v[]=new int[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        boolean scambioAvvenuto=true;
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if(v[i]<v[i+1])
                {
                    scambia(v,i, i+1);
                    scambioAvvenuto=true;
                }
                    
            }
                
        }while(scambioAvvenuto==true);
      return v;  
    }
    
    
    public static String[] bubbleSortCrescente(String[] a)
    {
        //creo una copia di a
        
        String v[]=new String[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        boolean scambioAvvenuto=true;
        for(int i=0;i<lunghezza-1;i++)
        {
            if(v[i].compareTo(v[i+1])>0)
                {
                    scambia(v,i, i+1);
                    scambioAvvenuto=true;
                }
 
        }
        return v;
    }
    
    public static String[] bubbleSortDecrescente(String[] a)
    {
        //creo una copia di a
        
        String v[]=new String[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
            v[i]=a[i];
        }
        boolean scambioAvvenuto=true;
        for(int i=0;i<lunghezza-1;i++)
        {
            if(v[i].compareTo(v[i+1])<0)
                {
                    scambia(v,i, i+1);
                    scambioAvvenuto=true;
                }
 
        }
        return v;
    }
    
    /**
     * Scambia il libro in pos1 con il libro in pos2 dell'array di libri a
     * @param a
     * @param pos1
     * @param pos2 
     */
    public static void scambiaLibri(Libro []a,int pos1,int pos2)
    {
        Libro s;
        s=a[pos1];
        a[pos1]=a[pos2];
        a[pos2]=s;
    }
    
    /**
     * ordina in ordine alfabetico di titolo gli elementi di un array di Libri utilizzando l'algoritmo selection sort
     * @param a
     * @return 
     */
    public static Libro[] selectionSortCrescenteLibri(Libro[] a)
    {
        //creo una copia di a
        
        Libro v[]=new Libro[a.length];
        int lunghezza=v.length;
        for(int i=0;i<v.length;i++)
        {
             v[i]=new Libro (a[i]);
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(v[j].getTitolo().compareToIgnoreCase(v[i].getTitolo())<0)
                    scambiaLibri(v, i, j);
            }
        }
        return v;
    }
    
     
}
