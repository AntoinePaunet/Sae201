import java.util.ArrayList;
import inter.IRessource;

public class Plateau implements IRessource
{
	private static final int NB_PIECE_MAX = 15 ;

	private int nbPiece ;

	private int score;

	private String detailScore;

	private Pioche pioche;

	private Epice[][] tabEpices;

	private Piece[] tabPieces;

	public Plateau()
	{
		this.pioche = new Pioche();
		this.tabEpices = new Epice[3][5];
		this.tabPieces = new Piece[8];
	}

	public int getScore() { return this.score;}

	public String getDetailScore() { return this.detailScore;}

	public boolean ajouterRessource( Jeton r )
	{

		if( r.getType() instanceof Epice)
		{
			for(int i = 0 ; i < this.tabEpices[0].length ; i++)
			{
				if((((this.tabEpices[1][i] == null || this.tabEpices[2][i] == null)) || this.tabEpices[0][i] == null) || (!this.tabEpices[0][i].name().equals(((Epice) r.getType()).name())))
				{
					this.tabEpices[nbPiece%3][nbPiece/3] = (Epice) r.getType();
					this.nbPiece++;
					return true;
				}
			}
			return false;
		} else if ( r.getType() instanceof Piece)
		{
		int cpt = ((Piece) r.getType()).getvaleur();
			for(int i = 0 ; (i < this.tabPieces.length) ; i++) {
				if (this.tabPieces[i] == null) {
					this.tabPieces[i] = ((Piece) r.getType());
					cpt--;
				}

				if (cpt == 0) {
					this.nbPiece++;
					return true;
				}
			}
		}
		return false;

	}


	public void score()
	{
		int score;

		score = 0;

		for (int i = tabPieces.length; i > 0; i--)
		{
			if (score == 0 && tabPieces[i] != null)
				score = (i+1)*(i+1);
		}

		for (int col = 0; col < tabEpices.length; col++)
		{
			if      (tabEpices[col][2] != null)
					score+=10;
			else if (tabEpices[col][1] != null)
					score+= 2;
		}

		cptPieceLig = 0;
		for (int lig = 0; col < tabEpices[0].length; col++)
		{
			for (int col=0; col < tabEpices.length; col++)
			{
				if (tabEpices[lig][col] != null)
					cptPieceLig++;
			}
			if (cptPieceLig >=2 && cptPieceLig <= tabEpices.length + 1)
				for (int j=2; j <= cptPieceLig; j++)
					score+=j;
		}

		this.score = score;
		this.detailScore = "Score : " + score + "point" + (score > 1 ? "s" : "");

	}


	public String toString()
	{
		String s = "";
		if(this.nbPiece == 0)
		{
			s = "Etat initial du Plateau\n";
		}else{
			s = "Etat final du Plateau\n";
		}


		for( int i1 = 0 ; i1 < 3 ; i1 ++ )
		{
			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				s += "+-----";
			s += "+\n|";

			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				if(this.tabEpices[i1][i2] != null)
					s += " " + String.format("%3s", this.tabEpices[i1][i2].name().substring(0, 2) ) +  " |" ;
				else
					s+= "     |";
			s += "\n";
		}
		for( int i2 = 0 ; i2 < 5 ; i2 ++ )
			s += "+-----";
		s += "+\n";

		return s;
	}


	public static void main( String[] args )
	{
		Plateau p1 = new Plateau();


		//Début du mode CUI
		System.out.println(p1);
		p1.ajouterRessource(p1.pioche.tirerJeton());
		p1.ajouterRessource(p1.pioche.tirerJeton());
		p1.ajouterRessource(p1.pioche.tirerJeton());
		p1.ajouterRessource(p1.pioche.tirerJeton());
		System.out.println(p1);
	}


}