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
public class Algo_Polybe implements Algo{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
