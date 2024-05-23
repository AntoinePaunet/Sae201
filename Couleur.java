import java.awt.*;

/**
 * Cet classe enum recense les Couleurs correspondantes aux Epices. Les couleurs sont implémentées sous format RGB.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
*/

public enum Couleur
{
	BLANC  ( 255, 255, 255 ),
	JAUNE  ( 255, 255, 0   ),
	ROUGE  ( 255, 0  , 0   ),
	ORANGE ( 255, 100, 0   ),
	VIOLET ( 255, 255, 255 ),
	BRUN   ( 88 , 41 , 0   ),
	VERT   ( 0  , 255, 0   ),
	NOIR   ( 0  , 0  , 0   );

	private int r, v, b;

	/**
	 * Crée un objet de la classe Couleur avec les paramètres r v b
	 *
	 * @return un nouvel objet de la classe Couleur.
	 */
	private Couleur( int r , int v , int b )
	{
		this.r = r;
		this.v = v;
		this.b = b;
	}

	/**
	 * Donne la couleur qui correspond à l'instance qui utilise cette méthode
	 *
	 * @return un objet de la class Couleur correspondant à l'instance.
	 */
	public Color getColor()
	{
		return new Color( this.r, this.v, this.b );
	}



	/**
	 * Renvoie un nom d'image d'épice
	 *
	 * @return le nom de l'épice.png afin d'être utilisée dans l'interface
	 */
	public String getSymbole()
	{
		String res = "";
		switch(this.name()) //Selon la couleur de l'épice
		{
			case "BLANC" 	: res = "sesame"; 	break;
			case "JAUNE" 	: res = "curcuma"; 	break;
			case "ROUGE" 	: res = "paprika"; 	break;
			case "ORANGE" 	: res = "safran"; 	break;
			case "VIOLET" 	: res = "sumac";  	break;
			case "BRUN" 	: res = "canelle"; 	break;
			case "VERT" 	: res = "cardamone";break;
			case "NOIR" 	: res = "poivre";   break;
		}
		return res+".png";
	}

	/**
	 * Donne le nombre d'instance de Couleur
	 *
	 * @return l'entier correpondant au nombre d'instance de Couleur.
	 */
	public static int getNbCouleur()
	{
		return Couleur.values().length;
	}

	/**
	 * Donne une couleur selon un entier
	 *
	 * @return un objet de la classe Couleur, pas utilisé jusqu'a maintenant.
	 */
	public static Couleur valueOf( int ordinal )
	{
		return Couleur.valueOf(ordinal);
	}

}
