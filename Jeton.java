import inter.*;

/**
 * Cet classe correspond aux Jetons du joueur. Ils peuvent être de type Epice ou Piece.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
*/

public class Jeton
{
	private IRessource type ;


	/**
	 * Constructeur pour créer un Jeton
	 * @param type IRessource
	 */
	public Jeton( IRessource type )
	{
		this.type = type;
	}


	/**
	 * Retourne le type du Jeton ( Epice ou Piece )
	 *
	 * @return IRessource type de jeton
	 */
	public IRessource getType() { return this.type; }


	/**
	 * Permet de donner sous Forme de String les infos sur le Jeton
	 *
	 * @return String avec le toString dy type ( Piece ou Epice )
	 */
	public String toString() 
	{
		return this.type.toString();
	}

} 