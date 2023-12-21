package ges_absence;

public class Classe {
	 private int idClasse;
	  private String libelleClasse;
	  private int niveau;
	  private String filiere;
	  
	  public Classe() {}
	  
	  public Classe(int idClasse, String libelleClasse, int niveau, String filiere) {
	    this.idClasse = idClasse;
	    this.libelleClasse = libelleClasse;
	    this.niveau = niveau;
	    this.filiere = filiere;
	  }


	  
	  public String getFiliere() {
	    return this.filiere;
	  }
	  
	  public void setFiliere(String filiere) {
	    this.filiere = filiere;
	  }
	  
	  public int getNiveau() {
	    return this.niveau;
	  }
	  
	  public void setNiveau(int niveau) {
	    this.niveau = niveau;
	  }
	  
	  public void setIdClasse(int idClasse) {
	    this.idClasse = idClasse;
	  }
	  
	  public void setLibelleClasse(String libelleClasse) {
	    this.libelleClasse = libelleClasse;
	  }
	  
	  public int getIdClasse() {
	    return this.idClasse;
	  }
	  
	  public String getLibelleClasse() {
	    return this.libelleClasse;
	  }

	  
	  public String toString() {
	    return "Libelle : " + this.libelleClasse + " \n Niveau = " + this.niveau + "  \n";
	  }
	

}
