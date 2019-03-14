/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage.Modules;

import cryptage.Algorithmes.Algo_Cesar;
import cryptage.Algorithmes.Algo_Substitution;
import cryptage.Utilisateurs.Message;
import cryptage.Utilisateurs.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author hk619751
 */
public class Module_substitution implements Module{
    private String message;

    public Module_substitution(String message) {
        this.message = message;
    }
    @Override
    public void Start() {
        Algo_Substitution algo = new Algo_Substitution();
        Utilisateur Bob = new Utilisateur(algo);
        Utilisateur Alice = new Utilisateur(algo);
        Message messageClair = new Message(this.message);
        Alice.setMessage_clair(messageClair);
        ArrayList<String> clePrivee = new ArrayList();
        clePrivee.add("abcdefghijklmnopqrstuvwxyz");
        Alice.setClePrivee(clePrivee);
        Bob.setClePrivee(clePrivee);
        Alice.crypterAvecClePrivee();
        System.out.println(Alice.getMessage_crypte());
        Bob.setMessage_crypte(Alice.getMessage_crypte());
        Bob.decrypterAvecClePrivee();
        Bob.AfficherMessageClair();
    }
    
}
