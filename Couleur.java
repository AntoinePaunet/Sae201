import java.awt.*;

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

	private Couleur( int r , int v , int b )
	{
		this.r = r;
		this.v = v;
		this.b = b;
	}

	public Color getColor()
	{
		return new Color( this.r, this.v, this.b );
	}

	public String getSymbole()
	{
		return this.name() + ".png";
	}

	public static int getNbCouleur()
	{
		return 8;
	}

	public static Couleur valueOf( int ordinal )
	{
		return Couleur.valueOf(ordinal) ;
	}

}
