package test;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Algorithm {

    public Algorithm() {
    }

    public static float[] readFile() throws FileNotFoundException, IOException {
        String[] holderArray;
        float[] finalArray;
        try (FileReader fr = new FileReader("INPUT.TXT")) {
            Scanner reader = new Scanner(fr);
            holderArray = reader.nextLine().split("\t");
            finalArray = new float[holderArray.length];
            for (int i = 0; i < holderArray.length; i++) {
                finalArray[i] = Float.parseFloat(holderArray[i]);
            }
        }
        return finalArray;
    }
    public static void swap(int i, int k, float[] arr) {
        float x;
        x = arr[i];
        arr[i] = arr[k];
        arr[k] = x;
    }
    
    public static void writeFile(float[] use, String path, boolean append) throws IOException {
        try {
        FileWriter fw = new FileWriter(path,append);
        BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<use.length;i++) {
               
                bw.write(use[i] + "\t");

        }
        bw.newLine();
        bw.close();
            } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
    }

        public static float[] bubbleSort(float[] bs) throws IOException {
               int i, j;
                boolean haveSwap = false;
                for (i = 0; i < bs.length-1; i++) {
                    haveSwap = false;
                    for (j = 0; j < bs.length-i-1; j++){
                        if (bs[j] > bs[j+1]){
                            swap(j, j + 1, bs);
                            haveSwap = true; // Kiểm tra lần lặp này có swap không
                        }
                    }
                   display(bs);
                    // Nếu không có swap nào được thực hiện => mảng đã sắp xếp. Không cần lặp thêm
                    if(haveSwap == false){
                        break;
                    }
                }
            writeFile(bs, "OUTPUT1.TXT", false);
            return bs;           
        }

    public static float[] selectionSort(float[] bs) throws IOException {
        int i, j,min_idx;
            // Di chuyển ranh giới của mảng đã sắp xếp và chưa sắp xếp
            for (i = 0; i < bs.length-1; i++)
            {
            // Tìm phần tử nhỏ nhất trong mảng chưa sắp xếp
            min_idx = i;
            for (j = i+1; j < bs.length; j++)
                if (bs[j] < bs[min_idx])
                    min_idx = j;
            // Đổi chỗ phần tử nhỏ nhất với phần tử đầu tiên
                swap(min_idx, i,bs);
                display(bs);
            }
                 // Nếu không có swap nào được thực hiện => mảng đã sắp xếp. Không cần lặp thêm
            writeFile(bs, "OUTPUT2.TXT", false);
        return bs;           
    }

    public static float[] insertionSort(float[] bs) throws IOException {
        int i, j;
        float key;
        for (i = 1; i < bs.length; i++)
        {
            key = bs[i];
            j = i-1;
            /* Di chuyển các phần tử có giá trị lớn hơn giá trị 
            key về sau một vị trí so với vị trí ban đầu
            của nó */
            while (j >= 0 && bs[j] > key)
            {
                bs[j+1] = bs[j];
                j = j-1;
            }
            bs[j+1] = key;
            display(bs);
        }
        writeFile(bs, "OUTPUT3.TXT", false);
        return bs;           
    }

    public static float[] insertionSortNoDisplay(float[] bs) throws IOException {
        int i, j;
        float key;
        for (i = 1; i < bs.length; i++)
        {
            key = bs[i];
            j = i-1;
            /* Di chuyển các phần tử có giá trị lớn hơn giá trị 
            key về sau một vị trí so với vị trí ban đầu
            của nó */
            while (j >= 0 && bs[j] > key)
            {
                bs[j+1] = bs[j];
                j = j-1;
            }
            bs[j+1] = key;
        }
        return bs;           
    }

    public static void linearSearch(float value, float[] bs) throws IOException {
        try {
            FileWriter fw = new FileWriter("OUTPUT4.TXT", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<bs.length; i++)
            {
                if(bs[i]>value)
                {
                    System.out.print(i + " ");
                    bw.write(i + "\t");      
                }
            } 
             bw.close();      
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
        System.out.println();    
    }

    public static void writeFileSearch(int a,boolean append) throws IOException {
        try {
            FileWriter fw = new FileWriter("OUTPUT5.TXT", false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a + "\t");      
            bw.close();      
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
        System.out.println();    
    }

    public static int binarySearch(float value, float[] bs,int dau,int cuoi) throws IOException {
        insertionSortNoDisplay(bs);
        if (cuoi >= dau) { 
            int mid = dau + (cuoi - dau) / 2; 
            if (bs[mid] == value) 
                return mid; 
            if (bs[mid] > value) 
                return binarySearch(value, bs, dau, mid - 1); 
            return binarySearch(value,bs, mid + 1, cuoi); 
        } 
        return -1; 
    }

    public static void display(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }



}
