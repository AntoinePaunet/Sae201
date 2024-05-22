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
				if(this.tabEpices[1][i] == null || this.tabEpices[2][i] == null || this.tabEpices[0][i] == null)
				{
					if(this.tabEpices[0][i] != null && this.tabEpices[0][i].name().equals(((Epice) r.getType()).name())) //Si on a la même ressource que dans le tableau
					{
						for(int i2 = 0; i2 < tabEpices.length ; i2++)
						{
							if(this.tabEpices[i2][i] == null)
							{
								System.out.println(r.getType() + "         : " + true);
								this.tabEpices[i2][i] = (Epice) r.getType();
								return true;
							}
						}

					}else if(this.tabEpices[0][i] == null) //Si la ressource n'est pas la même
					{
						System.out.println(r.getType() + "         : " + true);
						this.tabEpices[0][i] = (Epice) r.getType();
						return true;
					}
				}
			}

		} else if ( r.getType() instanceof Piece)
		{
			int cpt = ((Piece) r.getType()).getvaleur();
			int nbSlotsLibre = 0;


			for(int i = 0 ; i < this.tabPieces.length ; i++)
			{
				if(this.tabPieces[i] == null)
				{
					nbSlotsLibre++;
				}
			}

			if(nbSlotsLibre < cpt) //Si le nombre de slots de pièce est plus petit que la valeur de la pièce on annule
			{
				System.out.println(r.getType().toString().substring(0,r.getType().toString().length()-2) + "         : " + true);
				return false;
			}



			for(int i = 0 ; i < this.tabPieces.length ; i++)
			{
				if (cpt == 0)
				{
					System.out.println(r.getType().toString().substring(0,r.getType().toString().length()-2) + "         : " + true);
					return true;
				}

				if (this.tabPieces[i] == null)
				{
					this.tabPieces[i] = Piece.BRONZE;
					this.nbPiece++;
					cpt--;
				}
			}
		}

		System.out.println(r.getType() + String.format("%14s", null) + false); //14

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
		if(this.tabEpices[0][0] == null && this.tabPieces[0] == null)
			s = "Etat initial du Plateau\n";
		
		else
			s = "Etat final du Plateau\n";


		for( int i1 = 0 ; i1 < 3 ; i1 ++ )
		{
			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				s += "+-----";
			s += "+\n|";

			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				if(this.tabEpices[i1][i2] != null)
					s += " " + this.tabEpices[i1][i2].getLibCourt() +  " |" ;
				else
					s+= "     |";
			s += "\n";
		}
		for( int i2 = 0 ; i2 < 5 ; i2 ++ )
			s += "+-----";


		if(nbPiece > 1)
			s += "+\n" + nbPiece + " pièces";
		else
			s += "+\n" + nbPiece + " pièce";

		return s;
	}


	public static void main( String[] args )
	{
		Plateau p1 = new Plateau();


		//Début du mode CUI
		System.out.println(p1);
		for(int i = 0 ; i < Plateau.NB_PIECE_MAX ; i++)
		{
			System.out.print( p1.ajouterRessource(p1.pioche.tirerJeton()) + "\n" );
		}

		System.out.println(p1);
	}


}