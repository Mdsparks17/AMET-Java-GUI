/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaguiapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class JDBCTest { public static void main(String[] args) {   
    AMETForm form = new AMETForm();
    Test test = new Test();  
    test.run(form);  
    form = null;

}}

class Test {
    public void run(AMETForm form) {
           String str = "hello.w-orld_ob";
           str = str.replace("-", "_");
           str = str.replace(".", "_");
           str = str.replace("_ob", "");
           System.out.println(str);
    }
    
    public void stop(AMETForm form) {
        
    }
}