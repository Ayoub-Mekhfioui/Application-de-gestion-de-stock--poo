    package Application;

    import javax.swing.plaf.synth.SynthTextAreaUI;

    public class ProduitMang {
        static Produit[] p = new Produit[100];
        static int nombreProduit=0;
        static void printMenu(){

            System.out.println("1. Ajouter un produit");
            System.out.println("2. Modifier un produit");
            System.out.println("3. Supprimer un produit");
            System.out.println("4. Afficher la liste des produits");
            System.out.println("5. Recherche de produit");
            System.out.println("6. Calcul de la valeur totale du stock");
            System.out.println("0. Quitter");

        }
        static void testCodeiIfIsNumber(){

        }
        static void ajouterProduit(Produit produit){
            if (p.length>nombreProduit){
                p[nombreProduit]=produit;
                nombreProduit++;
            }
            else System.out.println("Impossible d'ajouter : le tableau est plein.");
        }
        static void Afficher(){
            for(int i=0;i<nombreProduit;i++){
                if (p[i] != null) {
                    System.out.println("le code : " + p[i].getCode() + " est : " + p[i].getNom() + " est : " + p[i].getPrix() + " est : " + p[i].getQuantite());
                    System.out.println("----------------------------------------------------------------");
                }
            }
        }
        static void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix){
            for(int i=0;i<nombreProduit;i++){
                if(p[i].getCode()==code){
                    p[i].setNom(nouveauNom);
                    p[i].setQuantite(nouvelleQuantite);
                    p[i].setPrix(nouveauPrix);
                    break;
                }
            }
        }
        static void supprimerProduit(int code){
            int i=0;
            for(Produit pro : p){
                if(pro != null && pro.code==code){
                    p[i]=null;
                    nombreProduit--;
                    return;
                }
                i++;
            }

        }
        static void rechercherProduit(String nom){
            int i=0;
            for(Produit pro:p){
                if (pro != null && pro.getNom().equals(nom)){
                    System.out.println("le code : " + p[i].getCode() + " est : " + p[i].getNom() + " est : " + p[i].getPrix()+" est :" + p[i].quantite);
                    break;
                }
                i++;
            }
        }
        static double calculerValeurStock(){
            double valeur=0;
            for (Produit pro :p){
                if (pro != null) {
                    valeur = pro.calculer()+valeur;
                }
            }
            return valeur;
        }


    }

