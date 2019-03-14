/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage.Utilisateurs;

import cryptage.Algorithmes.Algo;
import java.util.ArrayList;

/**
 *
 * @author hk619751
 */
public class Utilisateur {
    
    private ArrayList<String> clePublique;

    private ArrayList<String> clePrivee;
    
    private Algo algo;
    private Message message_clair;
    private Message message_crypte;

    /**
     * Get the value of clePrivee
     *
     * @return the value of clePrivee
     */
    public ArrayList<String> getClePrivee() {
        return clePrivee;
    }

    /**
     * Set the value of clePrivee
     *
     * @param clePrivee new value of clePrivee
     */
    public void setClePrivee(ArrayList<String> clePrivee) {
        this.clePrivee = clePrivee;
    }

    /**
     * Get the value of clePublique
     *
     * @return the value of clePublique
     */
    public ArrayList<String> getClePublique() {
        return clePublique;
    }

    /**
     * Set the value of clePublique
     *
     * @param clePublique new value of clePublique
     */
    public void setClePublique(ArrayList<String> clePublique) {
        this.clePublique = clePublique;
    }

    public Utilisateur(Algo _algo){
        this.algo=_algo;
    }
    
    public void GenererClePublique(){
        this.clePublique=this.algo.GenererClePublique();
    }
    
    public void GenererClePrivee(){
        this.clePrivee=this.algo.GenererClePrivee();
    }

    public void setMessage_clair(Message message_clair) {
        this.message_clair = message_clair;
    }

    public void setMessage_crypte(Message message_crypte) {
        this.message_crypte = message_crypte;
    }

    public Message getMessage_crypte() {
        return message_crypte;
    }
    
    public void AfficherMessageClair(){
        System.out.println(this.message_clair);
    }
    
    public void crypterAvecClePublique(){
        this.message_crypte=this.algo.crypter(message_clair, clePublique);
    }
    
    public void crypterAvecClePrivee(){
        this.message_crypte=this.algo.crypter(message_clair, clePrivee);
    }
    
    public void decrypterAvecClePublique(){
        this.message_clair=this.algo.decrypter(message_crypte, clePublique);
    }
    
    public void decrypterAvecClePrivee(){
        this.message_clair=this.algo.decrypter(message_crypte, clePrivee);
    }
    
}
