import inter.IRessource;

/**
 * Cet classe enum recense les Epices contenues dans le jeu. Les Epices sont un type de Jeton, et ont une Couleur coeespondante, définie dans la classe enum Couleur.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
*/

public enum Epice implements IRessource
{
	SESAME	  ( Couleur.BLANC  ),
	CURCUMA	  ( Couleur.JAUNE  ),
	PAPRIKA   ( Couleur.ROUGE  ),
	SAFRAN	  ( Couleur.ORANGE ),
	SUMAC	  ( Couleur.VIOLET ),
	CANNELLE  ( Couleur.BRUN   ),
	CARDAMONE ( Couleur.VERT   ),
	POIVRE	  ( Couleur.NOIR   );

	private Couleur coul;

	private Epice( Couleur coul )
	{
		this.coul = coul;
	}


	/**
	 * Donne les trois premières lettres de l'epice pour l'affichage CUI
	 *
	 * @return Les trois premières lettres de l'Epice
	 */

	public String getLibCourt()
	{
		return this.name().substring(0, 3);
	}

	/**
	 * Donne la couleur de l'Epice
	 *
	 * @return La couleur de l'Epice
	 */

	public Couleur getCouleur()
	{
		return this.coul;
	}


	/**
	 * Donne le type de jeton et son nom.
	 *
	 * @return le mot "Epice" puis le nom de l'Epice
	 */

	public String toString()
	{
		return "Epice " + this.name().toUpperCase();
	}

}