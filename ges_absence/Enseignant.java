package ges_absence;

public class Enseignant {
	private int idEnseignant;
	  private String nom;
	  private String prenom;
	  
	  public Enseignant() {
	    this.nom = "PADNOM";
	  }
	  
	  public Enseignant(int idEnseignant, String nom, String prenom, String login, String pwd) {
	    this.idEnseignant = idEnseignant;
	    this.nom = nom;
	    this.prenom = prenom;
	  }


	  
	  public void setIdEnseignant(int idEnseignant) {
	    this.idEnseignant = idEnseignant;
	  }
	  
	  public void setNom(String nom) {
	    this.nom = nom;
	  }
	  
	  public void setPrenom(String prenom) {
	    this.prenom = prenom;
	  }
	  
	  public int getIdEnseignant() {
	    return this.idEnseignant;
	  }
	  
	  public String getNom() {
	    return this.nom;
	  }
	  
	  public String getPrenom() {
	    return this.prenom;
	  }

	  
	  public String toString() {
	    return "Nom Enseig :  " + this.nom + " \nPrenom : " + this.prenom + " ";
	  }
}
