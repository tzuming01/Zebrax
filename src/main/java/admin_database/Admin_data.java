/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package admin_database;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aunir
 */
public class Admin_data {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            try (FileWriter writer = new FileWriter("D:\\OODJ_ASSIGNMENT\\Zebrax\\src\\main\\java\\admin_database\\admin_profile.txt")) {
                writer.write("aunishah");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
  
    }
    
}
