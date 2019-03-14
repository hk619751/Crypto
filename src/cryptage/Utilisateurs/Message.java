/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage.Utilisateurs;

/**
 *
 * @author hk619751
 */
public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public Message() {
        this.message="";
    }
    
    public int taille(){
        int res;
        res=this.message.length();
        return res;
    }
    
    public void AffichageAscii(){
        for(int i=0;i<this.taille();i++){
            System.out.print(this.getCharAscii(i)+" ");
        }
        System.out.println("");
    }
    /**
     * Renvoie le code ASCII du ième caractere du mesage
     * @param i
     * @return 
     */
    public int getCharAscii(int i){
        int res;
        res=message.charAt(i);
        return res;
    }
    /**
     * 
     * @param codeAscii 
     */
    public void addCharAscii(int codeAscii){
        this.message+=(char)codeAscii;
    }

    @Override
    public String toString() {
        return this.message;
    }
    /**
     * renvoie une chaine ayant exactement 8 caractères représentant le code 
     * ascii en binaire du i-ème caractère du message
     * @param i
     * @return 
     */
    public String getCharBinary(int i){
        String res="";
        String temp = Integer.toBinaryString(this.message.charAt(i));
        if(temp.length()<=8){
            for(int j=0;j<(8-temp.length());j++){
                res+="0";
            }
        }
        res+=temp;
        return res;
    }
    /**
     * renvoit le message en binaire sous forme d’une chaine de caractère
     * @param binary
     * @return 
     */
    public String toBinaryString(String binary){
        String res="";
        for(int i=0;i<(binary.length());i+=8){
            int x=0;
            String temp = binary.substring(i+1, i+9);
            int puissanceDe2 = 7;
            for(int j=0;j<8;j++){
                x += temp.charAt(i+1)*(int) Math.pow(2, puissanceDe2);
                puissanceDe2--;
            }
            res+=(char)x;
        }
        return res;
    }
    
    public void addCharBinary(String b){
        this.message = this.message.concat(this.toBinaryString(b));
    }
}
