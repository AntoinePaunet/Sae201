import inter.IRessource;
import java.awt.color.*;

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

	public String getLibCoul()
	{
		return this.coul.getSymbole();
	}

	public Couleur getCouleur()
	{
		return this.coul;
	}

	public String toString()
	{
		return "Epice " + this.name().toUpperCase();
	}

}