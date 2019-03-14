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
public class Algo_Vigenere implements Algo{
    
    public Algo_Vigenere(){
        
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
    public Message crypter(Message _message, ArrayList<String> _cle) {
        Message res = new Message();
        String cle = _cle.get(0);
        cle=cle.replace(" ", "");
        char c;
        for(int i=0;i<_message.taille();i++){
            if(_message.getCharAscii(i)>64 && _message.getCharAscii(i)<91){
                c = cle.charAt((i+1)%cle.length());
                int valC = c - 65;
                int temp = _message.getCharAscii(i)-65+valC;
                res.addCharAscii(temp%26+65);
            }
            else if(_message.getCharAscii(i)>96 && _message.getCharAscii(i)<123){
                c = cle.charAt((i+1)%cle.length());
                int valC = c - 97;
                int temp = _message.getCharAscii(i)-97+valC;
                res.addCharAscii(temp%26+97);
            }
            else{
                res.addCharAscii(_message.getCharAscii(i));
            }
        }
        return res;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> _cle) {
        Message res = new Message();
        String cle = _cle.get(0);
        cle=cle.replace(" ", "");
        char c;
        for(int i=0;i<_message.taille();i++){
            if(_message.getCharAscii(i)>64 && _message.getCharAscii(i)<91){
                c = cle.charAt((i+1)%cle.length());
                int valC = c - 65;
                int temp = _message.getCharAscii(i)-65-valC;
                while(temp<0) temp+=26;
                res.addCharAscii(temp%26+65);
            }
            else if(_message.getCharAscii(i)>96 && _message.getCharAscii(i)<123){
                c = cle.charAt((i+1)%cle.length());
                int valC = c - 97;
                int temp = _message.getCharAscii(i)-97-valC;
                while(temp<0) temp+=26;
                res.addCharAscii(temp%26+97);
            }
            else{
                res.addCharAscii(_message.getCharAscii(i));
            }
        }
        return res;
    }
    
}
