import inter.IRessource;

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