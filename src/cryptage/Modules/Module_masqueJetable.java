package cryptage.Modules;

import cryptage.Algorithmes.Algo_masqueJetable;
import cryptage.Utilisateurs.Message;
import cryptage.Utilisateurs.Utilisateur;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hk619751
 */
public class Module_masqueJetable implements Module{

    private String message;

    public Module_masqueJetable(String message) {
        this.message = message;
    }
    
    @Override
    public void Start() {
        Algo_masqueJetable algo = new Algo_masqueJetable();
        Utilisateur Bob = new Utilisateur(algo);
        Utilisateur Alice = new Utilisateur(algo);
        Message messageClair = new Message(this.message);
        Alice.setMessage_clair(messageClair);
        ArrayList<String> clePrivee = new ArrayList();
        clePrivee.add("010010100110010100100000011100110111010101101001011100110010000001000010011011110110001000100000011001010111010000100000011101000111010100100000011001010111001100100000010000010110110001101001011000110110010100100000001000010010000001100011011000010010000001110110011000010010000001100010011010010110010101101110");
        Alice.setClePrivee(clePrivee);
        Bob.setClePrivee(clePrivee);
        Alice.crypterAvecClePrivee();
        System.out.println(Alice.getMessage_crypte());
        Bob.setMessage_crypte(Alice.getMessage_crypte());
        Bob.decrypterAvecClePrivee();
        Bob.AfficherMessageClair();
    }
}
