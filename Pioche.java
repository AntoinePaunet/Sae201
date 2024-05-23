import inter.IRessource;
import java.util.ArrayList;

/**
 * Cet classe créé la Pioche utilisée dans le jeu. Elle est composée de Jetons.
 * Ces Jetons sont placés dans un ordre donné par les professeurs pour être capable de démontrer des scénarios précis du jeu.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
*/

public class Pioche implements IRessource
{
	private ArrayList<Jeton> pioche ;

	public Pioche()
	{
		this.initPioche();
	}

	public static int taillePioche; //Permet de connaitre la taille de la pioche à la fin de sa création


	/**
	 * Permet de retrouner le jeton en haut de pile tout en l'enlevant de celle-ci
	 * @return retourne le jeton en haut de la pile
	 */
	public Jeton tirerJeton()
	{
		Jeton res = this.pioche.get(this.pioche.size()-1);
		this.pioche.remove(this.pioche.size()-1);
		Pioche.taillePioche -= 1;
		return res;
	}

	/**
	 * Prépare la pioche de manière non aléatoire en créant des jetons
	 */
	private void initPioche() 
	{
		this.pioche = new ArrayList<Jeton>();
		this.pioche.size();

		this.pioche.add(new Jeton(Epice.CANNELLE ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Epice.PAPRIKA  ));
		this.pioche.add(new Jeton(Piece.ARGENT   ));
		this.pioche.add(new Jeton(Piece.ARGENT   ));
		this.pioche.add(new Jeton(Epice.POIVRE   ));
		this.pioche.add(new Jeton(Epice.SESAME   ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Piece.OR       ));
		this.pioche.add(new Jeton(Epice.CARDAMONE));
		this.pioche.add(new Jeton(Epice.CURCUMA  ));
		this.pioche.add(new Jeton(Epice.SUMAC    ));
		this.pioche.add(new Jeton(Epice.POIVRE   ));

		Pioche.taillePioche = this.pioche.size();
	}
}