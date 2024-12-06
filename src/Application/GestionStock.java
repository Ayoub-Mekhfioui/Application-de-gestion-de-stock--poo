package Application;

import java.awt.event.MouseAdapter;
import java.util.Scanner;

public class GestionStock {


    public static void main(String[] args) {
        Produit produit= new Produit(1,"DELL",1000,10);
        Produit produit1= new Produit(11,"DELL1",2000,20);
        Produit produit2= new Produit(111,"DELL2",3000,20);
        Produit produit3= new Produit(11111,"DELL3",4000,30);
        Produit produit4= new Produit(111111,"DELL4",5000,140);
        ProduitMang.ajouterProduit(produit);
        ProduitMang.ajouterProduit(produit1);
        ProduitMang.ajouterProduit(produit2);
        ProduitMang.ajouterProduit(produit3);
        ProduitMang.ajouterProduit(produit4);
        ProduitMang.Afficher();
        int code;
        String nom;
        double prix;
        int qte;
        Scanner sc = new Scanner(System.in);
        int choix;

        System.out.println("-----------------Gestion de stock------------------");


        do {
           ProduitMang.printMenu();
            System.out.println("Choisisszer une option :");
            choix = sc.nextInt();
            switch(choix){
                case 1:
                    boolean testint=false;
                    System.out.println("--------------------Ajouter un produit------------------------");
                    System.out.println("Ajouter un Code");
                    code = sc.nextInt();
                    do{
                        for (int i=0 ;i<ProduitMang.p.length;i++){
                            if((ProduitMang.p[i] != null && ProduitMang.p[i].getCode()==code)){
                                testint=false;
                                break;
                            }else testint=true; break;


                        }
                        System.out.println("code exist déjé donner un code  :");
                        code = sc.nextInt();

                    }while (!testint);
                    System.out.println("Ajouter le nom de produite");
                    nom = sc.next();
                    do{
                        System.out.println("Ajouter un prix");
                        prix = sc.nextDouble();
                        for (int i=0 ;i<ProduitMang.p.length;i++){
                            if (ProduitMang.p[i] != null && prix<0){
                                testint=false;
                                break;
                            }else testint=true; break;
                        }

                    }while(!testint);
                    do{
                        System.out.println("Ajouter un quantite");
                        qte = sc.nextInt();
                        for (int i=0 ;i<ProduitMang.p.length;i++){
                            if (ProduitMang.p[i] != null && qte<0){
                                testint=false;
                                break;
                            }else testint=true; break;
                        }
                    }while(!testint);

                    Produit p1=new Produit(code,nom,prix,qte);
                    ProduitMang.ajouterProduit(p1);
                    break;
                case 2:
                    boolean produitModifie = false;
                    int test=0;
                    do {

                        System.out.println("--------------------modifier un produit------------------------");
                        System.out.println("donner le code de prouduit a modifier");
                        code = sc.nextInt();
                        for (int i = 0; i < ProduitMang.p.length; i++) {
                            if (ProduitMang.p[i] != null && ProduitMang.p[i].code == code) {
                                System.out.println("donner un nouveau nom");
                                nom = sc.next();
                                System.out.println("donner un nouveau prix");
                                prix = sc.nextDouble();
                                System.out.println("donner un nouveau quantite");
                                qte = sc.nextInt();
                                ProduitMang.modifierProduit(code, nom, qte, prix);
                                System.out.println("Produit modifié avec succès !");
                                produitModifie = true;
                                test=1;
                                break;
                            }

                        }if (!produitModifie) {
                            System.out.println("Code produit introuvable. Veuillez réessayer avec un code valide.");
                            test=0;
                        }



                    }while (test!=1);

                    break;
                case 3:
                    produitModifie = false;
                    test=0;
                    do {

                        System.out.println("--------------------supprimer un produit------------------------");
                        System.out.println("donner le code de prouduit a supprimer");
                        code = sc.nextInt();
                        for (int i = 0; i < ProduitMang.p.length; i++) {
                            if (ProduitMang.p[i] != null && ProduitMang.p[i].code == code) {
                                ProduitMang.supprimerProduit(code);
                                System.out.println("Produit supprimer avec succès !");
                                produitModifie = true;
                                test=1;
                                break;
                            }

                        }if (!produitModifie) {
                            System.out.println("Code produit introuvable. Veuillez réessayer avec un code valide.");
                            test=0;
                        }



                    }while (test!=1);

                    break;
                case 4:
                    System.out.println("--------------------Afficher un produit------------------------");
                    ProduitMang.Afficher();

                     break;
                case 5:
                    test=0;
                    do{
                        System.out.println("--------------------chercher un produit------------------------");
                        System.out.println("Donner le nom de produit a rechercher");
                        nom = sc.next();
                        for (int i = 0; i < ProduitMang.p.length; i++) {
                            if (ProduitMang.p[i] != null && ProduitMang.p[i].getNom().equals(nom)) {
                                ProduitMang.rechercherProduit(nom);
                                test=1;
                                break;
                            }
                        }
                        if (test==0) {
                            System.out.println("donner un nom exist a rachercher");
                        }


                    }while (test!=1);
                    break;
                case 6:
                    System.out.println("--------------------calculer la Valeur total de Stock------------------------");
                    System.out.println("la valeur totale de stock et :"+ ProduitMang.calculerValeurStock());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ERROR");


            }
        }while(choix!=0);
        System.out.println("Session terminée");
    }

    }

