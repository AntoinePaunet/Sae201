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

	private Piece( int valeur )
	{
		this.valeur = valeur;
	}

	public int getvaleur()
	{
		return this.valeur;
	}

	public String toString()
	{
		return "Piece " + this.name();
	}

}