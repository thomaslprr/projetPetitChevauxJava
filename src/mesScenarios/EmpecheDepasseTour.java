package mesScenarios;

import mesClasses.Partie;
import mesExceptions.CasePleineException;
import mesExceptions.PasDeJoueursException;

public class EmpecheDepasseTour {

	public static void main(String[] args) throws PasDeJoueursException, CasePleineException {
		Partie p = new Partie();
		p.getPlateau().deplacerPionA(p.getJoueur().get(0).getPions().get(0), p.getPlateau().getChemin().get(39));
		p.getPlateau().deplacerPionA(p.getJoueur().get(1).getPions().get(0), p.getPlateau().getChemin().get(52));
		p.getPlateau().deplacerPionA(p.getJoueur().get(2).getPions().get(0), p.getPlateau().getChemin().get(10));
		p.getPlateau().deplacerPionA(p.getJoueur().get(3).getPions().get(0), p.getPlateau().getChemin().get(24));

		
		
		Partie.sc.nextLine();
		p.getPlateau().afficher();
		Partie.sc.nextLine();
		
		do {
			p.jouerUnTour();
		}while(p.estPartieTermine()==false);
	System.out.println("La partie est terminée !");
	System.out.println(p.getJoueurCourrant().getNom() + " a gagné la partie. \nFélicitation. ");
	}
}


