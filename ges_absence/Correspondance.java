package ges_absence;

public class Correspondance {
	private Classe classe;
	  private Enseignant enseignant;
	  private Matiere matiere;
	  
	  public Correspondance(Classe classe, Enseignant enseignant, Matiere matiere) {
	    this.classe = classe;
	    this.enseignant = enseignant;
	    this.matiere = matiere;
	  }
	  
	  public void setClasse(Classe classe) {
	    this.classe = classe;
	  }
	  
	  public void setEnseignant(Enseignant enseignant) {
	    this.enseignant = enseignant;
	  }
	  
	  public void setMatiere(Matiere matiere) {
	    this.matiere = matiere;
	  }
	  
	  public Classe getClasse() {
	    return this.classe;
	  }
	  
	  public Enseignant getEnseignant() {
	    return this.enseignant;
	  }
	  
	  public Matiere getMatiere() {
	    return this.matiere;
	  }
}
