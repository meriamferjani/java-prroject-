package ges_absence;

public class Matiere {
	private int idMatiere;
	  private String libelleMatiere;
	  
	  public Matiere(String libelleMatiere) {
	    this.libelleMatiere = libelleMatiere;
	  }

	  
	  public Matiere() {}
	  
	  public void setIdMatiere(int idMatiere) {
	    this.idMatiere = idMatiere;
	  }
	  
	  public void setLibelleMatiere(String libelleMatiere) {
	    this.libelleMatiere = libelleMatiere;
	  }
	  
	  public int getIdMatiere() {
	    return this.idMatiere;
	  }
	  
	  public String getLibelleMatiere() {
	    return this.libelleMatiere;
	  }

	  
	  public String toString() {
	    return "Matiere :  " + this.libelleMatiere + " \n ";
	  }
}
