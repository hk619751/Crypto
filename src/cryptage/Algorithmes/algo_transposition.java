/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage.Algorithmes;

import cryptage.Utilisateurs.Message;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hk619751
 */
public class algo_transposition implements Algo{
    private ArrayList<String> cle;
    private int nbLignes;
    private int nbColonnes;
    private char[] tableauCle;
    private String mot;
    
    public algo_transposition() {
        this.cle = new ArrayList<>();
    }

    @Override
    public ArrayList<String> GenererClePublique() {
        return null;
    }

    @Override
    public ArrayList<String> GenererClePrivee() {
        return null;
    }

    @Override
    public Message crypter(Message _message, ArrayList<String> cle) {
        Message rez= new Message();
        init(cle, _message.toString());
        //On rajoute la ligne incomplète qui n'est pas comptée
        if(mot.length()%cle.get(0).length() != 0){
            nbLignes++;
        }
        char[][] tableauCodage = new char[nbLignes][nbColonnes];
        tableauCodage = remplissage(mot);
        int[] tableau = traitement();
        for(int i=0;i<nbColonnes;i++){
            for(int j=0;j<nbLignes;j++){
                rez.addCharAscii(tableauCodage[j][tableau[i]]);
            }
        }
        return rez;
        
        
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        Message rez=new Message();
        init(cle, _message.toString());
        char[][] tableauDecodage = new char[nbLignes][nbColonnes];
        int nb=0;
        
        for(int num : traitement()){
            for(int i=0;i<nbLignes;i++){
                tableauDecodage[i][num]=mot.charAt(nb);
                nb++;
            }
        }
        for(int i=0;i<nbLignes;i++){
            for(int j=0;j<nbColonnes;j++){
                rez.addCharAscii(tableauDecodage[i][j]);
            }
        }
        return rez;
    }
    
    private void init(ArrayList<String> _cle, String chaine){
        cle = _cle;
        nbColonnes=0;
        nbLignes=0;
        tableauCle=new char[cle.get(0).length()];
        mot = chaine.replace(" ", "");
        mot = mot.toLowerCase();
        nbLignes=mot.length()/cle.get(0).length();
        nbColonnes=cle.get(0).length();
        for(int i=0;i<nbColonnes;i++){
            tableauCle[i]=cle.get(0).charAt(i);
        }
    }
    
    private char[][] remplissage(String chaine){
        char[][] tableauCodage = new char[nbLignes][nbColonnes];
        int nb=0;
        
        for(int i=0;i<nbLignes;i++){
            for(int j=0;j<nbColonnes;j++){
                if(nb<chaine.length()){
                    tableauCodage[i][j]=chaine.charAt(nb);
                    nb++;
                }
                else{
                    Random r = new Random();
                    int valeur = 97+r.nextInt(122-97);
                    tableauCodage[i][j]=(char) valeur;
                }
            }
        }
        return tableauCodage;
    }

    private int[] traitement(){
        int nb=-1;
        int[] rez = new int[cle.get(0).length()];
        for(int i=0;i<cle.get(0).length();i++){
            char c = tableauCle[0];
            for(int j=0;j<cle.get(0).length();j++){
                if(c>tableauCle[j]){
                    c=tableauCle[j];
                }
            }
            for(int j=0;j<cle.get(0).length();j++){
                if(c==tableauCle[j]){
                    nb=j;
                }
            }
            tableauCle[nb]=(char) 255;
            rez[i]=nb;
        }
        return rez;
    }
}
