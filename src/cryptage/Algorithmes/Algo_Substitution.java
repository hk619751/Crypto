/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage.Algorithmes;

import cryptage.Utilisateurs.Message;
import java.util.ArrayList;

/**
 *
 * @author hk619751
 */
public class Algo_Substitution implements Algo{

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
        Message rez = new Message();
        for(char c : _message.toString().toCharArray()){
            int lettre = c-97;
            int temp = cle.get(0).charAt(lettre);
            rez.addCharAscii(temp);
        }
        return rez;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        Message rez = new Message();
        for(char c : _message.toString().toCharArray()){
            int temp = cle.get(0).indexOf(c);
            rez.addCharAscii(temp+65);
        }
        return rez;
    }
    
}
