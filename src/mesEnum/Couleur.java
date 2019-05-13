package mesEnum;
/**
 * Enumération des 4 couleurs possibles pour les pions et les cases.
 * @author Thomas Lapierre
 *
 */
public enum Couleur {
	ROUGE ("Rouge","\033[1;41m","\033[34;31m"),
    JAUNE ("Jaune","\033[01;43m","\033[34;33m"),
    VERT ("Vert","\033[1;42m","\033[34;32m"),
    BLEU ("Bleu","\033[1;44m","\033[34;34m"),
    BLANC ("Blanc","\033[0m","\033[00m");

   private String nom;
   private String code;
   private String ecriture;
   Couleur(String n, String c, String e ) {
	   this.nom=n;
	   this.code=c;
	   this.ecriture=e;
   }
public String getNom() {
	return nom;
}

public String getCode() {
	return code;
}

public String getEcriture() {
	return ecriture;
}
			
    		
}


