import inter.IRessource;

/**
 * Cet classe enum recense les Pieces contenues dans le jeu. Les Pieces sont un type de Jeton, et ont une valeur coeespondante.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
*/

public enum Piece implements IRessource
{
	BRONZE ( 1 ),
	ARGENT ( 2 ),
	OR	   ( 5 );

	private int valeur;


	/**
	 * Constructeur pour créer un objet de type pièce
	 * @param valeur de la pièce
	 */

	private Piece( int valeur )
	{
		this.valeur = valeur;
	}


	/**
	 * Retourne la valeur d'une pièce
	 *
	 * @return valeur de la pièce
	 */
	public int getvaleur()
	{
		return this.valeur;
	}


	/**
	 * Donne sous forme de string Piece et le nom de la pièce
	 *
	 * @return String Piece + nom de la pièce
	 */
	public String toString()
	{
		return "Piece " + this.name();
	}

}