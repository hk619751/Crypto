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
public class Algo_Cesar implements Algo{
    private ArrayList<String> cle;

    public Algo_Cesar() {
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
        for(int i=0;i<_message.taille();i++){
            //if(_message.getCharAscii(i)>64 && _message.getCharAscii(i)<91){
                int temp = _message.getCharAscii(i)-32+Integer.valueOf(_cle.get(0));
                res.addCharAscii(temp%(127-32)+32);
            /*}
            /*else if(_message.getCharAscii(i)>96 && _message.getCharAscii(i)<123){
                int temp = _message.getCharAscii(i)-97+Integer.valueOf(_cle.get(0));
                res.addCharAscii(temp%26+97);
            }
            else{
                res.addCharAscii(_message.getCharAscii(i));
            }*/
        }
        return res;
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> _cle) {
        Message res = new Message();
        for(int i=0;i<_message.taille();i++){
            //if(_message.getCharAscii(i)>64 && _message.getCharAscii(i)<91){
                int temp = _message.getCharAscii(i)-32-Integer.valueOf(_cle.get(0));
                while(temp<0) temp+=32;
                res.addCharAscii(temp%(127-32)+32);
            /*}
            else if(_message.getCharAscii(i)>96 && _message.getCharAscii(i)<123){
                int temp = _message.getCharAscii(i)-97-Integer.valueOf(_cle.get(0));
                while(temp<0) temp+=26;
                res.addCharAscii(temp%26+97);
            }
            else{
                res.addCharAscii(_message.getCharAscii(i));
            }*/
        }
        return res;
    }
    
}
