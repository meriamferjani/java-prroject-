package ges_absence;

public class Responsable {
	 private int idResponsable;
	  private String nomResponsable;
	  private String prenomResponsable;
	  
	  public Responsable() {
	    this.nomResponsable = "PADNOM";
	  }
	  
	  public Responsable(int idResponsable, String nomResponsable, String prenomResponsable) {
	    this.idResponsable = idResponsable;
	    this.nomResponsable = nomResponsable;
	    this.prenomResponsable = prenomResponsable;
	  }
	  
	  public int getIdResponsable() {
	    return this.idResponsable;
	  }
	  
	  public String getNomResponsable() {
	    return this.nomResponsable;
	  }
	  
	  public String getPrenomResponsable() {
	    return this.prenomResponsable;
	  }
	  
	  public void setIdResponsable(int idResponsable) {
	    this.idResponsable = idResponsable;
	  }
	  
	  public void setNomResponsable(String nomResponsable) {
	    this.nomResponsable = nomResponsable;
	  }
	  
	  public void setPrenomResponsable(String prenomResponsable) {
	    this.prenomResponsable = prenomResponsable;
	  }

	  
	  public String toString() {
	    return "Nom : " + this.nomResponsable + " \nPrenom : " + this.prenomResponsable + " \n\n";
	  }

}
