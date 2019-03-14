/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage;

import cryptage.Algorithmes.algo_RSA;
import cryptage.Modules.Module_Cesar;
import cryptage.Modules.Module_Vigenere;
import cryptage.Modules.Module_masqueJetable;

/**
 *
 * @author hk619751
 */
public class Cryptage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Module_masqueJetable module = new Module_masqueJetable("Bonjour, comment ca va ? Wakanda !");
        //module.Start();
        algo_RSA a = new algo_RSA();
        /*System.out.println(a.temoin_miller(2, 561));
        System.out.println(a.temoin_miller(3, 561));
        System.out.println(a.temoin_miller(50, 561));
        System.out.println(a.Miller_Rabin(1213, 100));
        System.out.println(a.inverse_modulo(120, 23));*/
        System.out.println(a.GenererClePublique());
        System.out.println(a.GenererClePrivee());
    }
    
}
