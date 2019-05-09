package mesEnum;
/**
 * Enumération des 4 couleurs possibles pour les pions et les cases.
 * @author Thomas Lapierre
 *
 */
public enum Couleur {
	ROUGE ("Rouge","\033[1;41m"),
    JAUNE ("Jaune","\033[01;43m"),
    VERT ("Vert","\033[1;42m"),
    BLEU ("Bleu","\033[1;44m"),
    BLANC ("Blanc","\033[0m");

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


