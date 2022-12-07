import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class FileInputPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader("src/demo.txt"));
        String str=bf.readLine();
        String [] splitarray= str.split(" ");
        int [] arr=new int[splitarray.length];
        for(int i=0; i<splitarray.length;i++){
            arr[i]=Integer.parseInt(splitarray[i]);
        }


    }
}
