package ges_absence;

public class Etudiant {
	private int idEtudiant;
	  private String nom;
	  private String prenom;
	  private Classe classe;
	  private int niveau;
	  private int pwd;
	  private String login ;
	  
	  
	  public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Etudiant() {
	    this.nom = "PADNOM";
	  }
	  
	  public Etudiant(int idEtudiant, String nom, String prenom, Classe classe) {
	    this.idEtudiant = idEtudiant;
	    this.nom = nom;
	    this.prenom = prenom;
	    this.classe = classe;
	  }


	  
	  public void setClasse(Classe classe) {
	    this.classe = classe;
	  }
	  public void setNiveau(int niveau) {
	    this.niveau = niveau;
	  }
	  
	  public void setIdEtudiant(int idEtudiant) {
	    this.idEtudiant = idEtudiant;
	  }
	  
	  public void setNom(String nom) {
	    this.nom = nom;
	  }
	  
	  public void setPrenom(String prenom) {
	    this.prenom = prenom;
	  }
	  
	  public Classe getClasse() {
	    return this.classe;
	  }
	  
	  public int getIdEtudiant() {
	    return this.idEtudiant;
	  }
	  public int getNiveau() {
	    return this.niveau;
	  }
	  
	  public String getNom() {
	    return this.nom;
	  }
	  
	  public String getPrenom() {
	    return this.prenom;
	  }
	  
	  public String toString() {
	    return "Nom = " + this.nom + " \nPrenom = " + this.prenom + " \n\n  ";
	  }

}
