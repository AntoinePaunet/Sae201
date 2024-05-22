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

	public Jeton( IRessource type )
	{
		this.type = type;
	}

	public IRessource getType() { return this.type; }

	public String toString() 
	{
		return this.type.toString();
	}

} 