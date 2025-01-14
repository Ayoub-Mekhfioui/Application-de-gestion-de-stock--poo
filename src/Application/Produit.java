package Application;

public class Produit {
    int code;
    String nom;
    double prix;
    int quantite;

    public Produit(int code, String nom, double prix, int quantite) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';

    }
    public double calculer() {
        double Totale = quantite * prix;
        return Totale;
    }
}
