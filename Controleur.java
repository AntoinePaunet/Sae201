public class Controleur
{
    private Interface ihm;
    private Plateau plateau;

    public Controleur(Plateau plateau)
    {
        this.ihm = new Interface();
        this.plateau = plateau;
    }

}