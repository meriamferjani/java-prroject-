package ges_absence;
import ges_absence.Etudiant;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class test {

	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub
		boolean var=true;
		while(var) {
		System.out.println("*************************Gestion Absence***************************");
		
		System.out.println("Menu Principal");
		System.out.println("1- Etudiant");
		System.out.println("2- Prof");
		System.out.println("3- Admine");
		System.out.println("4- Quitter ");
		
		System.out.println("Choix :");
		
		Scanner scanner = new Scanner(System.in);
		
		int choix=scanner.nextInt();
		switch(choix) {
		
		case 1:
			boolean ok=false;
			boolean var1=true;
			while(var1) {
			System.out.println("*************************Gestion Etudiant***************************");
			
				System.out.println("***s'authentifier***");
				while(ok==false) {
				System.out.println("donner le login :");
				String logine=scanner.next();
				System.out.println("donner le mot de passe :");
				String pwd=scanner.next();
				Connection  cnx=null;
				ResultSet res=null;
				PreparedStatement prepared=null;
				cnx=testcon.ConnectDb();
				String sql="select login,pwd from etudiant";
                try {
					prepared=cnx.prepareStatement(sql);
					res=prepared.executeQuery();
					while(res.next()) {
						String log=res.getString("login");
						String pass=res.getString("pwd");
						if( log.equals(logine) && pass.equals(pwd)) {
							ok= true;
							System.out.println("vous avez authentifier avec succes!");
							break;
						}
					}
                }catch(Exception e) {
        			System.out.println(e);
                }
				}		
						
						
			System.out.println("1- Consulter les absences");
			System.out.println("2- Quitter");
			System.out.println("Choix :");
			int choixEtudiant = scanner.nextInt();
			switch(choixEtudiant) {
			case 1:
				System.out.println("***Consulter les absences***");
				
				System.out.println("donner votre ID :");
				int IDE=scanner.nextInt();
				Connection  cnx=null;
				ResultSet res=null;
				PreparedStatement prepared=null;
				cnx=testcon.ConnectDb();
				String sql="SELECT * FROM (absence INNER JOIN enseignant ON (absence.idEnseingant=enseignant.idEnseignant)) INNER JOIN matiere ON (matiere.idMatiere=absence.idMatiere);";
                try {
					prepared=cnx.prepareStatement(sql);
					res=prepared.executeQuery();
					while(res.next()) {
						if(res.getInt("idEtudiant")== IDE) {
						System.out.println("date d abcence : "+res.getString("date")+"  matiere :"+res.getString("libelle")+" enseignant : "+res.getString("nom")+" "+res.getString("prenom"));
						if(res.getBoolean("periode1")) {
						System.out.print("  periode 1 : Absent(e)");
						}else {
							System.out.print("  periode 1 : present(e)");
						}
						
						}}
					
					
                }catch(Exception e) {
        			System.out.println(e);
                }
						
				
			case 2:
				System.out.println("***bye bye !***");
				var1=false;
				var=true;
				break;
			default:
				System.out.println("choix invalide!!!!");
				break;
		
			}}
			break;
		case 2:
			
			System.out.println("*************************Gestion prof***************************");
			System.out.println("***s'authentifier***");
			boolean ok1=false;
			while(ok1==false) {
				System.out.println("donner le login :");
				String logine=scanner.next();
				System.out.println("donner le mot de passe :");
				String pwd=scanner.next();
				Connection  cnx=null;
				ResultSet res=null;
				PreparedStatement prepared=null;
				cnx=testcon.ConnectDb();
				String sql="select login,pwd from enseignant";
                try {
					prepared=cnx.prepareStatement(sql);
					res=prepared.executeQuery();
					while(res.next()) {
						String log=res.getString("login");
						String pass=res.getString("pwd");
						if( log.equals(logine) && pass.equals(pwd)) {
							ok1= true;
							System.out.println("vous avez authentifier avec succes!");
							break;
						}
					}
                }catch(Exception e) {
        			System.out.println(e);
                }
				}		
			boolean var2=true;
			while(var2) {
			System.out.println("1- remplire liste de presence");
			System.out.println("2- Consulter les absences");
			System.out.println("3- Quitter");
			System.out.println("Choix :");
			int choixProf = scanner.nextInt();
			switch(choixProf) {
			
			case 1:
				System.out.println("***remplire liste de presence***");
				System.out.println("id classe :");
				int IDC=scanner.nextInt();
				System.out.println("ID enseignant :");
    			int IDen=scanner.nextInt();
    			System.out.println("id matiere :");
    			int IDM=scanner.nextInt();
    			System.out.println("num Seance :");
   				int nb=scanner.nextInt();
				Connection  cnx=null;
				ResultSet res=null;
				PreparedStatement prepared=null;
				cnx=testcon.ConnectDb();
				String sql="SELECT * FROM `etudiant` WHERE idClasse= "+IDC+";";
					try {
					prepared=cnx.prepareStatement(sql);
					res=prepared.executeQuery();
					while(res.next()) {
						System.out.println(res.getString("idEtudiant")+" - "+res.getString("nom")+" "+res.getString("prenom")) ;
					}
					
					}catch(Exception e) {
        			System.out.println(e);
        			}
				int p1=0 ;	
				while(p1!=-1) {
					System.out.println("donner les ID des eleves absent (ou -1 pour terminer): ");
					 p1=scanner.nextInt();	
					String sql1 = "INSERT INTO absence (idAbsence, idEtudiant , idEnseingant, idMatiere, idClasse, numSeance,  periode1) VALUES ( NULL, " + p1 + "," + IDen + "," + IDM + "," + IDC + "," + nb + "," + 1 +")";
					if(p1!=-1) {
						try {
							cnx=testcon.ConnectDb();
							PreparedStatement statement1 = cnx.prepareStatement(sql1);
							statement1.executeUpdate();	
							statement1.close();
							cnx.close();
						}catch(Exception e) {
		        			System.out.println(e);
	        			}
					}
				}
				
        		
        		
                break;
				
			case 2:
				System.out.println("***Consulter les absences***");
				System.out.println("donner l'ID de classe demander :");
				IDC=scanner.nextInt();
				System.out.println("donner votre ID  :");
				IDen=scanner.nextInt();
				System.out.println("donner le numero de seance  :");
				int nums=scanner.nextInt();
				cnx=null;
				res=null;
				prepared=null;
				cnx=testcon.ConnectDb();
				String sql6="SELECT * FROM ((absence INNER JOIN etudiant ON (etudiant.idEtudiant=absence.idEtudiant)) INNER JOIN matiere ON (matiere.idMatiere=absence.idMatiere)) INNER JOIN classe ON (absence.idClasse=classe.idClasse);";
                try {
					prepared=cnx.prepareStatement(sql6);
					res=prepared.executeQuery();
					while(res.next()) {
						if(res.getInt("idclasse")== IDC && res.getInt("idEnseingant")== IDen && res.getInt("numSeance")== nums ) {
						System.out.print("date d abcence : "+res.getString("date")+"  matiere :"+res.getString("libelle")+" etudiant : "+res.getString("nom")+" "+res.getString("prenom")+"  filiere :"+ res.getString("filiere"));
						if(res.getBoolean("periode1")) {
						System.out.println(" Absent(e)");
						}else {
							System.out.print(" present(e)");
						}
						
						}}
					
					
                }catch(Exception e) {
        			System.out.println(e);
                }
				
                break;

			case 3:
				System.out.println("***bye bye !***");
				var2=false;
				var=true;
				break;
			default:
				System.out.println("choix invalide!!!!");
				break;
			}}break;
		case 3:
			boolean var3=true;
			boolean ok2=false;
			while(var3) {
			System.out.println("*************************Gestion Admine***************************");
			System.out.println("*** s'authentifier ***");
			while(ok2==false) {
				System.out.println("donner le login :");
				String logine=scanner.next();
				System.out.println("donner le mot de passe :");
				String pwd=scanner.next();
				Connection  cnx=null;
				ResultSet res=null;
				PreparedStatement prepared=null;
				cnx=testcon.ConnectDb();
				String sql="select login,pwd from responsable";
                try {
					prepared=cnx.prepareStatement(sql);
					res=prepared.executeQuery();
					while(res.next()) {
						String log=res.getString("login");
						String pass=res.getString("pwd");
						if( log.equals(logine) && pass.equals(pwd)) {
							ok2= true;
							System.out.println("vous avez authentifier avec succes!");
							break;
						}
					}
                }catch(Exception e) {
        			System.out.println(e);
                }
				}		
						
			
			System.out.println("1- gerer les absences");
			System.out.println("2- Quitter");
			System.out.println("Choix :");
			int choixAdmin = scanner.nextInt();
			switch(choixAdmin) {
			case 1:
				boolean var4=true;
				while(var4) {
				System.out.println("***gerer les absences***");
				System.out.println("1- Consulter les absences");
				System.out.println("2- Annuler absence(s)");
				System.out.println("3- Generer graphes");
				System.out.println("4- Envoyer des mails d alertes aux étudiants");
				System.out.println("5- Quitter");
				System.out.println("Choix :");
				int choixAdmin1 = scanner.nextInt();
				switch(choixAdmin1) {
				case 1:
					System.out.println("***Consulter les absences***");
					System.out.println("donner class ID :");
					int IDC=scanner.nextInt();
					Connection  cnx=null;
					ResultSet res=null;
					PreparedStatement prepared=null;
					cnx=testcon.ConnectDb();
					String sql="SELECT * FROM ((absence INNER JOIN enseignant ON (absence.idEnseingant=enseignant.idEnseignant)) INNER JOIN matiere ON (matiere.idMatiere=absence.idMatiere)) INNER JOIN etudiant ON ( etudiant.idEtudiant=absence.idEtudiant)";
					try {
						prepared=cnx.prepareStatement(sql);
						res=prepared.executeQuery();
						while(res.next()) {
							if(res.getInt("idClasse")== IDC) {
							System.out.print(res.getInt("idAbsence")+" - "+"date d abcence : "+res.getString("date")+"  matiere :"+res.getString("libelle")+" enseignant : "+res.getString("nom")+" "+res.getString("prenom")+ "  etudiant : "+res.getString(17)+" "+res.getString(18));
							if(res.getBoolean("periode1")) {
							System.out.println("   Absent(e)");
							}else {
								System.out.println("   present(e)");
							}
							
							}}
						
						
	                }catch(Exception e) {
	        			System.out.println(e);
	                }
	                break;

				case 2:
					System.out.println("***Annuler absence(s)***");
					cnx=null;
					res=null;
					prepared=null;
					cnx=testcon.ConnectDb();
					String sql6="SELECT * FROM ((absence INNER JOIN etudiant ON (etudiant.idEtudiant=absence.idEtudiant)) INNER JOIN matiere ON (matiere.idMatiere=absence.idMatiere)) INNER JOIN classe ON (absence.idClasse=classe.idClasse);";
						try {
						prepared=cnx.prepareStatement(sql6);
						res=prepared.executeQuery();
						while(res.next()) {
							System.out.println(res.getString("idAbsence")+" - "+res.getString("nom")+" "+res.getString("prenom")+" filiere : "+res.getString("filiere")+"date d abcence : "+res.getString("date")+"  matiere :"+res.getString("libelle")+"  num seance : "+res.getString("numSeance")) ;
						}
						
						}catch(Exception e) {
	        			System.out.println(e);
	        			}
					int p1=0 ;	
					while(p1!=-1) {
						System.out.println("donner les ID de l absnece que vous voulez annuler (ou -1 pour terminer): ");
						 p1=scanner.nextInt();	
						if(p1!=-1) {
							String sql4 = "DELETE FROM `absence` WHERE idAbsence="+p1;
							try {
								cnx=testcon.ConnectDb();
								PreparedStatement statement1 = cnx.prepareStatement(sql4);
								statement1.executeUpdate();	
								statement1.close();
								cnx.close();
							}catch(Exception e) {
			        			System.out.println(e);
		        			}
						}
					}
					
	                break;

		

					
				case 3:
					System.out.println("***Generer graphes***");
					int nbab1=0;
					int nbab2=0;
					int nbab3=0;
					int nbab11=0;
					int nbab22=0;
					int nbab33=0;
					int nbab14=0;
					int nbab25=0;
					int nbab36=0;
					Connection  cnx2=null;
					ResultSet res2=null;
					PreparedStatement prepared2=null;
					cnx=testcon.ConnectDb();
					String sql2="SELECT * FROM ((absence INNER JOIN enseignant ON (absence.idEnseingant=enseignant.idEnseignant)) INNER JOIN matiere ON (matiere.idMatiere=absence.idMatiere)) INNER JOIN etudiant ON ( etudiant.idEtudiant=absence.idEtudiant)";
						try {
							prepared=cnx.prepareStatement(sql2);
							res2=prepared.executeQuery();
						while(res2.next()) {
							if(res2.getInt("niveau")== 1 &&res2.getInt("periode1")== 1) {
								nbab1++;
							}if(res2.getInt("niveau")== 2 &&res2.getInt("periode1")== 1) {
								nbab2++;
							}else {
								nbab3++;
							}
							if(res2.getInt("idClasse")== 1 &&res2.getInt("periode1")== 1) {
								nbab11++;
							}if(res2.getInt("idClasse")== 2 &&res2.getInt("periode1")== 1) {
								nbab22++;
							}if(res2.getInt("idClasse")== 3 &&res2.getInt("periode1")== 1) {
								nbab33++;
							}if(res2.getInt("idClasse")== 4 &&res2.getInt("periode1")== 1) {
								nbab14++;
							}if(res2.getInt("idClasse")== 5 &&res2.getInt("periode1")== 1) {
								nbab25++;
							}else {
								nbab36++;
							}
							}
						
						
	                }catch(Exception e) {
	        			System.out.println(e);
	                }
						System.out.println("******graphe de nombre d absence en premiere annee *******");
						System.out.println("  ");
						System.out.println("         _________");
					for (int i=nbab1 - 1 ; i>=0 ; i--) {
							  System.out.println(i+"        |       |");
					}
					System.out.println("  ");
					System.out.println("******graphe de nombre d absence en 2eme annee *******");
					System.out.println("  ");
					System.out.println("         _________");
				for (int i=nbab2 - 1 ; i>=0 ; i--) {
						  System.out.println(i+"        |       |");
				}
				System.out.println("  ");
				System.out.println("******graphe de nomre d absence en 3eme annee *******");
				System.out.println("  ");
				System.out.println("         _________");
			for (int i=nbab3 - 1 ; i>=0 ; i--) {
					  System.out.println(i+"        |       |");
			}
			System.out.println("******graphe de nombre d absence en LCS1 A *******");
			System.out.println("  ");
			System.out.println("         _________");
		for (int i=nbab11 - 1 ; i>=0 ; i--) {
				  System.out.println(i+"        |       |");
		}
		System.out.println("  ");
		System.out.println("******graphe de nombre d absence en LCS1 B *******");
		System.out.println("  ");
		System.out.println("         _________");
	for (int i=nbab22 - 1 ; i>=0 ; i--) {
			  System.out.println(i+"        |       |");
	}
	System.out.println("  ");
	System.out.println("******graphe de nomre d absence en LCS2 A *******");
	System.out.println("  ");
	System.out.println("         _________");
for (int i=nbab33 - 1 ; i>=0 ; i--) {
		  System.out.println(i+"        |       |");
}
System.out.println("******graphe de nombre d absence en LCS2 4 *******");
System.out.println("  ");
System.out.println("         _________");
for (int i=nbab14 - 1 ; i>=0 ; i--) {
	  System.out.println(i+"        |       |");
}
System.out.println("  ");
System.out.println("******graphe de nombre d absence en bigdata 3 *******");
System.out.println("  ");
System.out.println("         _________");
for (int i=nbab25 - 1 ; i>=0 ; i--) {
  System.out.println(i+"        |       |");
}
System.out.println("  ");
System.out.println("******graphe de nomre d absence en Data Mining 3 *******");
System.out.println("  ");
System.out.println("         _________");
for (int i=nbab36 - 1 ; i>=0 ; i--) {
System.out.println(i+"        |       |");
}
					break;
				case 4:
					System.out.println("***Envoyer des mails d’alertes aux étudiants***");
					
					 String toID = "meriemferjani0@gmail.com";
				        //Sender's email ID:
				        String fromID = "ferjani.meriam@etudiant-fst.utm.tn";
				        //Sender's Email Password:
				        String password = "13511802";
				        //Subject of the Email:
				        String subject = "This is the subject";
				        //Body of the Email:
				        String bodyText = "This is the text of the body";
				        // Host is Gmail's SMTP
				        String host = "smtp.gmail.com";
				        //Getting system properties
				        Properties pr = System.getProperties();
				        
				        //Setting up Email server
				        pr.put("mail.smtp.host", host);
				        pr.put("mail.smtp.port", "465");
				        pr.put("mail.smtp.ssl.enable", "true");
				        pr.put("mail.smtp.auth", "true");
				        //pass the Email and password to the session object
				        Session ss = Session.getInstance(pr, new javax.mail.Authenticator() {
				            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				                return new javax.mail.PasswordAuthentication(fromID, password);
				            }
				        });
				        try {
				            MimeMessage mm = new MimeMessage(ss);
				            //Set the 'From:' header field
				            mm.setFrom(new InternetAddress(fromID));
				            //Set the 'To:' header field
				            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(toID));
				            //Set the 'Subject:' header field
				            mm.setSubject(subject);
				            
				            MimeBodyPart text = new MimeBodyPart();
				            
				            //Set the actual message of the Email:
				            text.setText(bodyText);
				            Multipart mp = new MimeMultipart();
				            mp.addBodyPart(text);
				   
				            mm.setContent(mp);
				            
				            System.out.println("sending the Email...");
				            //send the mail:
				            Transport.send(mm);
				            System.out.println("\nEmail sent successfully!!");
				            
				        } 
				        catch (MessagingException e) {
				            e.printStackTrace();
				        }
				    
				
				  
				
				case 5:
					System.out.println("***bye bye !***");
					var4=false;
					var=true;
					break;
				default:
					System.out.println("choix invalide!!!!");
					break;
				}}break;
			case 2:
				System.out.println("***bye bye !***");
				var3=false;
				var=true;
				break;
			default:
				System.out.println("choix invalide!!!!");
				break;
			}}break;
			
		case 4:
			System.out.println("*************************bye bye !!!***************************");
			System.exit(0);
			break;
		default:
			System.out.println("choix invalide!!!!");
			break;
		}


	}
	}

}
