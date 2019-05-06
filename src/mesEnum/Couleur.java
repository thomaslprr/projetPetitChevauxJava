package mesEnum;
/**
 * Enumération des 4 couleurs possibles pour les pions et les cases.
 * @author Thomas Lapierre
 *
 */
public enum Couleur {
	ROUGE ("Rouge","\033[1;31m"),
    JAUNE ("Jaune","\033[01;33m"),
    VERT ("Vert","\033[1;32m"),
    BLEU ("Bleu","\033[34;01m"),
    BLANC ("Blanc","\033[00m");

   private String nom;
   private String code;
   Couleur(String n, String c ) {
	   this.nom=n;
	   this.code=c;
   }
public String getNom() {
	return nom;
}

public String getCode() {
	return code;
}

	
	

			
    		
}


