package ges_absence;

import java.sql.Date;

public class Absence {
	 private int id;
	  private Etudiant etudiant;
	  private Enseignant enseignant;
	  private Matiere matiere;
	  private Classe classe;
	  private int numseance;
	  
	  public Absence(int id, Etudiant etudiant, Enseignant enseignant, Matiere matiere, Classe classe, int numseance, Date date, boolean periode1, boolean periode2) {
	    this.id = id;
	    this.etudiant = etudiant;
	    this.enseignant = enseignant;
	    this.matiere = matiere;
	    this.classe = classe;
	    this.numseance = numseance;
	    this.date = date;
	    this.periode1 = periode1;
	    
	  }
	  private Date date; 
	  private boolean periode1; 
	 
	  private String P1; 
	  private String P2;
	  
	  public Absence() {}
	  
	  public void setP1(String P1) {
	    this.P1 = P1;
	  }
	  
	  public void setP2(String P2) {
	    this.P2 = P2;
	  }
	  
	  public String getP1() {
	    return this.P1;
	  }
	  
	  public String getP2() {
	    return this.P2;
	  }

	  
	  public Classe getClasse() {
	    return this.classe;
	  }
	  
	  public void setClasse(Classe classe) {
	    this.classe = classe;
	  }
	  
	  public Date getDate() {
	    return this.date;
	  }
	  
	  public void setDate(Date date) {
	    this.date = date;
	  }
	  
	  public Enseignant getEnseignant() {
	    return this.enseignant;
	  }
	  
	  public void setEnseignant(Enseignant enseignant) {
	    this.enseignant = enseignant;
	  }
	  
	  public Etudiant getEtudiant() {
	    return this.etudiant;
	  }
	  
	  public void setEtudiant(Etudiant etudiant) {
	    this.etudiant = etudiant;
	  }
	  
	  public int getId() {
	    return this.id;
	  }
	  
	  public void setId(int id) {
	    this.id = id;
	  }
	  
	  public Matiere getMatiere() {
	    return this.matiere;
	  }
	  
	  public void setMatiere(Matiere matiere) {
	    this.matiere = matiere;
	  }
	  
	  public int getNumseance() {
	    return this.numseance;
	  }
	  
	  public void setNumseance(int numseance) {
	    this.numseance = numseance;
	  }
	  
	  public boolean isPeriode1() {
	    return this.periode1;
	  }
	  
	  public void setPeriode1(boolean periode1) {
	    this.periode1 = periode1;
	  }
	  
	  

	  
	  public String toString() {
	    return "Id = " + this.id + " \nEtudiant :\n " + this.etudiant + " \nNumero de Seance = : " + this.numseance + " \nPeriode 1 : " + this.periode1 + " \n ";
	  }
	  
	 
}
