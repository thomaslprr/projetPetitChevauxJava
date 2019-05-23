package mesScenarios;

import mesClasses.Partie;
import mesExceptions.CasePleineException;
import mesExceptions.PasDeJoueursException;

public class FinDeJeu {

	public static void main(String[] args) throws PasDeJoueursException, CasePleineException {
		Partie p = new Partie();
			p.getPlateau().deplacerPionA(p.getJoueur().get(0).getPions().get(0), p.getPlateau().getEchelles().get(0).get(5));
			p.getPlateau().deplacerPionA(p.getJoueur().get(0).getPions().get(1), p.getPlateau().getEchelles().get(0).get(4));
			p.getPlateau().deplacerPionA(p.getJoueur().get(0).getPions().get(2), p.getPlateau().getEchelles().get(0).get(3));
			p.getPlateau().deplacerPionA(p.getJoueur().get(0).getPions().get(3), p.getPlateau().getEchelles().get(0).get(1));
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


