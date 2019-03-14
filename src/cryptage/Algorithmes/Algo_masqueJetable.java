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
public class Algo_masqueJetable implements Algo{
    
    private String cle;
    
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
        Message res = new Message();
        String coucou="";
        this.cle = cle.get(0);
        for(int i=0;i<_message.taille();i++){
            String m = _message.getCharBinary(i);
            for(int j=0;j<m.length();j++){
                
            }
            if(m.equals(cle)){
                coucou += "0";
            }
            else
            {
                coucou+= "1";
            }
        }
        res.addCharBinary(coucou);
        return res;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        Message res = new Message();
        String coucou="";
        this.cle = cle.get(0);
        for(int i=0;i<_message.taille();i++){
            String m = _message.getCharBinary(i);
            String c = this.cle.substring(i+1, i+2);
            if(m.equals(c)){
                coucou += "0";
            }
            else
            {
                coucou+= "1";
            }
        }
        res.addCharBinary(coucou);
        return res;
    }
    
}
