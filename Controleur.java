public class Controleur
{
    private Interface ihm;
    private Plateau plateau;

    public Controleur()
    {
        this.ihm = new Interface();
        this.plateau = new Plateau();
    }

    public static void main( String[] args )
    {
        //Début du mode CUI
        System.out.println(p1);

        System.out.print( "\n");

        System.out.println("\nAjout des ressources à partir des jetons de la pioche\n");
        for(int i = 0 ; i < Plateau.NB_PIECE_MAX ; i++)
        {
            System.out.print( this.plateau.ajouterRessource(this.plateau.pioche.tirerJeton()) + "\n" );
        }
        System.out.print( "\n");
        System.out.println(this.plateau);


        toInterface();
    }

    private void toInterface()
    {
        for(int i = 0; i < this.plateau.getTabPieces.length ; i++)
    }

}