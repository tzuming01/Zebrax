/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.regex.*;  

/**
 *
 * @author tzuming
 */
public class User {
    public static String email;
    public static String password;
    public static String firstname;
    public static String lastname;
    public static String mobilenumber;
    public static String icnumber;
    
    public User getUser() {
        return this;
    }

    public void setUser (String email, String password, String firstname, String lastname, String mobilenumber, String icnumber) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilenumber = mobilenumber;
        this.icnumber = icnumber;
    }
    
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public String validateInsert () {
        String errormsg = "";
        
        String regex = "^(.+)@(.+)$";  
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(email);  
        
        if (!matcher.matches()) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Invalid email format.";
        }
        
        if (password.length()<8) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Password must be at least 8 characters.";
        }
        
        if (!isNumeric(mobilenumber)) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Mobile number must be numeric only.";
        }
        
        if (icnumber.length()!=12) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "IC Number must be 12 digit numbers only.";
        }
        
        return errormsg;
    }
    
    public String validateUpate (String mobilenumber, String icnumber, String passwordtxt, String newpasswordtxt, String newpassword2txt) {
        String errormsg = "";
        if (passwordtxt.isEmpty()) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Please fill in existing password in order to proceed update.";
        } else if(!passwordtxt.equals(this.password)) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Existing password incorrect.";
        } else {
            if (!newpasswordtxt.isEmpty()) {
                if (newpasswordtxt.length()<8) {
                    errormsg += (!errormsg.isEmpty())? "\n" :"" + "Password must be at least 8 characters.";
                }

                if (!newpasswordtxt.equals(newpassword2txt)) {
                    errormsg += (!errormsg.isEmpty())? "\n" :"" + "New password not matched.";
                }
            }
        }
        
        if (!isNumeric(mobilenumber)) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Mobile number must be numeric only.";
        }
        
        if (icnumber.length()!=12) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "IC Number must be 12 digit numbers only.";
        }
        
        return errormsg;
    }
    
    public boolean VerifyLogin(String emailtxt, String passwordtxt) {
        boolean found = false;
  
        try {
            BufferedReader br = new BufferedReader(new FileReader("user.txt"));
            String s="";
            while ((s=br.readLine()) != null && !found) {
                String data[] = new String[7];
                data = s.split(",");
                
                if (data[0].trim().equals(emailtxt.trim()) && data[1].trim().equals(passwordtxt.trim())) {
                    found = true;
                    this.setUser(data[0], data[1], data[2], data[3], data[4], data[5]);
                }
            }
            
        } catch (Exception e) {    
        }
        return found;
    }
    
    private boolean InsertFile (String email, String password, String firstname, String lastname, String mobilenumber, String icnumber) {
        Scanner sc = new Scanner(System.in);
        try
        {
            File f =new File("user.txt");
            PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
            pw.append(email+","+password+","+firstname+","+lastname+","+mobilenumber+","+icnumber+"\n");
            pw.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    private boolean UpdateFile (String email, String password, String firstname, String lastname, String mobilenumber, String icnumber) {
        boolean successful = false;
        try
        {
            File inputFile = new File("user.txt");
            File tempFile = new File("tempuser.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                String data[] = new String[7];
                data = trimmedLine.split(",");
                System.out.println(data[0]+"\n"+email);
                if(data[0].equals(email)) { 
                    writer.write(email+","+password+","+firstname+","+lastname+","+mobilenumber+","+icnumber+"\n");
                }else{
                    writer.write(currentLine + "\n");
                }
                System.out.println(currentLine+"\n");
            }
            writer.close(); 
            reader.close(); 
            successful = tempFile.renameTo(inputFile);
            
        } catch (IOException ex) {
            
        }
        
        return successful;
    }
    
    public String updateUser (String email, String oldpassword, String firstname, String lastname, String mobilenumber, String icnumber, String password, String password2) {
        String errormsg = "";
       
        errormsg = validateUpate(mobilenumber, icnumber, oldpassword, password, password2);
        
        if (errormsg.isEmpty()) {
            if (password.isEmpty()) {
                password = oldpassword;
            }
            if (UpdateFile(email, password, firstname, lastname, mobilenumber, icnumber)==false) {
                errormsg += (!errormsg.isEmpty())? "\n" :"" + "Update Failed.";
            } else {
                this.setUser(email, password, firstname, lastname, mobilenumber, icnumber);
            }
        }
        
        return errormsg;
    }
     
    public String insertUser () {
        String errormsg = "";
       
        errormsg = validateInsert();
        
        boolean found = false;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("user.txt"));
            String s="";
            while ((s=br.readLine()) != null && !found) {
                String data[] = new String[7];
                data = s.split(",");
                
                if (data[0].trim().equals(email.trim())) {
                    found = true;
                }
            }
            if (found == true) {
                errormsg += (!errormsg.isEmpty())? "\n" :"" + "Same email has been registered before.";
            }
            br.close();
        } catch (Exception e) {
            errormsg += (!errormsg.isEmpty())? "\n" :"" + "Unknow error.";
        }
        
        if (errormsg.isEmpty()) {
            if (InsertFile(email, password, firstname, lastname, mobilenumber, icnumber)==false) {
                errormsg += (!errormsg.isEmpty())? "\n" :"" + "Registration Failed.";
            }
        }
        
        return errormsg;
    }

}
