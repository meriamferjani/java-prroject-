package ges_absence;
import java.sql.*;
import java.text.SimpleDateFormat;

import ges_absence.Etudiant;

import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class testcon {
	Connection cnx=null;
	
	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost/gesabsences","root", "");
			return cnx;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	     }
	    
	  }
	
		
