package ca.cours5b5.philippechevry.global;

public final class GConstantes {

    private GConstantes(){}

    public static final int LARGEUR_MIN = 4;
    public static final int LARGEUR_MAX = 10;
    public static final int LARGEUR_PAR_DEFAUT = 7;

    public static final int HAUTEUR_MIN = 4;
    public static final int HAUTEUR_MAX = 10;
    public static final int HAUTEUR_PAR_DEFAUT = 6;

    public static final int POUR_GAGNER_MIN = 3;
    public static final int POUR_GAGNER_PAR_DEFAUT = 4;

    public static final String EXTENSION_PAR_DEFAUT=".json";
    public static final String FIXME_JSON_PARTIE_RESEAU = "{\"listeCoups\":[],\"parametres\":{\"largeur\":\"7\",\"pourGagner\":\"4\",\"hauteur\":\"6\"},\"idJoueurInvite\":\"Du5ORtg1N0baUpC8nn5t7l2GucA2\",\"idJoueurHote\":\"bxIfyak79LMxLgNmhd985sf2izr1\"}";
    public static final int LIMITE_MAX = 10;

    public static final String CLE_COUPS_JOUEUR_HOTE = "coupsJoueurHote";
    public static final String CLE_COUPS_JOUEUR_INVITE = "coupsJoueurInvite";

}
