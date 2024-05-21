import java.util.ArrayList;
import inter.IRessource;

public class Plateau implements IRessource
{
	private static final int NB_PIECE_MAX = 15 ;

	private int nbPiece ;

	private Pioche pioche;

	private Epice[][] tabEpices;

	private Piece[] tabPieces;

	public Plateau()
	{
		this.pioche = new Pioche();
		this.tabEpices = new Epice[3][5];
		this.tabPieces = new Piece[8];
	}

	public boolean ajouterRessource( Jeton r )
	{
		if( r.getType() instanceof Piece)
		{
			for(int i = 0 ; i < this.tabEpices[0].length ; i++)
			{
				if(		(this.tabEpices[0][i] == r.name() &&
						(this.tabEpices[1][i] == null || this.tabEpices[3][i] == null))
						|| this.tabEpices[0][i] == null)
				{
					this.tabEpices[nbPiece%3][nbPiece/3] = r.getType();
					return true;
				}
			}
			return false;
		}
		


		for(int i = 0 ; i < this.tabEpices[0].length ; i++)
		{
			if(		(this.tabEpices[0][i] == r.getType() &&
					(this.tabEpices[1][i] == null || this.tabEpices[3][i] == null))
					|| this.tabEpices[0][i] == null)
			{
				this.tabEpices[nbPiece%3][nbPiece/3] = r.getType();
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		String s = "Etat du plateau" ;

		for( int i1 = 0 ; i1 < 3 ; i1 ++ )
		{
			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				s += "+-----";
			s += "+";

			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				s += "+ " + String.format("%3s", this.tabEpices[i1][12].name().substring(0, 2) ) +  " | " ;
			s += "|";
		}
		return s;
	}


	public static void main( String[] args )
	{
		new Plateau();
	}


}