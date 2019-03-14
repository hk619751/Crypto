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
public interface Algo {
    public ArrayList<String> GenererClePublique();
    public ArrayList<String> GenererClePrivee();
    public Message crypter(Message _message, ArrayList<String> cle);
    public Message decrypter(Message _message, ArrayList<String> cle);
}
