package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main_Sort 
{
    public static void main(String[] args) throws IOException{
        float[] output;
        int test=0;
        double start, end;
        Scanner a = new Scanner(System.in);
        while(test!=8) {
            System.out.println("* * * *       Menu      * * * *");
            System.out.println("1.Input");
            System.out.println("2.Output");
            System.out.println("3.Bubble sort");
            System.out.println("4.Selection sort");
            System.out.println("5.Insertion sort");
            System.out.println("6.Linear Search : Search > value");
            System.out.println("7.Search = value");
            System.out.println("8.Exit");
            System.out.println("* * * * * * * * * * * * * * * * ");
            int choice = -1;
            try {
                choice = a.nextInt();
            } catch (InputMismatchException ex) {
                a.nextLine();
            }

            switch(choice){
                case 1:
                    System.out.println("Vui long nhap n : ");
                    int n = a.nextInt();    
                    File file = new File("INPUT.TXT");
                    try {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                        for(int i=0;i<n;i++) {
                            float c=a.nextFloat();
                            bw.write(c + "\t");
            
                    }
                    bw.close();
                    } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    }
                case 2:
                    output=Algorithm.readFile();
                    System.out.print("Array : ");
                    Algorithm.display(output);
                    break;
                case 3:
                    float[] bs = Algorithm.readFile();
                    start = System.currentTimeMillis();
                    Algorithm.bubbleSort(bs);
                    end = System.currentTimeMillis();
                    Algorithm.display(bs);
                    System.out.println("Thoi gian Bubble Sort: " + (end-start) +" ms");
                    break;
                case 4:
                    float[] ss = Algorithm.readFile();
                    start = System.currentTimeMillis();
                    Algorithm.selectionSort(ss);
                    end = System.currentTimeMillis();
                    Algorithm.display(ss);
                    System.out.println("Thoi gian Selection Sort: " + (end-start) +" ms");
                    break;
                case 5:
                    float[] is = Algorithm.readFile();
                    start = System.currentTimeMillis();
                    Algorithm.insertionSort(is);
                    end = System.currentTimeMillis();
                    Algorithm.display(is);
                    System.out.println("Thoi gian Insertion Sort: " + (end-start) +" ms");
                    break;
                case 6:
                    System.out.println("Vui long nhap value :");
                    float lValue =a.nextFloat();
                    float[] ls = Algorithm.readFile();  
                    output=Algorithm.readFile();
                    System.out.print("Array : ");
                    Algorithm.display(output); 
                    System.out.print("Vi tri Linear Search > value : ");           
                    Algorithm.linearSearch(lValue,ls);
                    break;
                case 7:
                    System.out.println("Vui long nhap value :");
                    float bValue =a.nextFloat();
                    float[] bis = Algorithm.readFile();  
                    output = Algorithm.readFile();  
                    int m = bis.length;
                    if(Algorithm.binarySearch(bValue,bis,0,m)==-1)
                    {
                        System.out.println("Khong tim thay vi tri Search == value"); 
                    }
                    else
                    { 
                        System.out.print("Array : ");
                        Algorithm.display(output); 
                        System.out.println("Mang sau khi xap xep : ");
                        Algorithm.insertionSortNoDisplay(bis);
                        Algorithm.display(bis);
                        System.out.println("Vi tri Linear Search == value : "+Algorithm.binarySearch(bValue,bis,0,m));  
                        Algorithm.writeFileSearch(Algorithm.binarySearch(bValue,bis,0,m),false); 
                    }        
                    break;
                case 8:
                    System.out.println("The end!");
                    test=8;
                    break;
    }
    }
        }
    }
