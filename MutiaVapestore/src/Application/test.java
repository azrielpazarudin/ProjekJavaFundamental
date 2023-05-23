/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;
import java.io.*;

public class test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Program Mencari ntahun kabisat :  ");
        System.out.println("Masukan Tahun ; ");int th = Integer.parseInt(br.readLine());
        if(th%4==0){
                               System.out.println("Ini Tahun Kabisat");
                }
        else{
            System.out.println("Ini Bukan Tahun Kabisat");
        }
        
    }
}
