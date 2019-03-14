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
import cryptage.Modules.module_transposition;
import cryptage.Modules.Module_substitution;

/**
 *
 * @author hk619751
 */
public class Cryptage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Module_substitution module = new Module_substitution("bonjourcommentcavawakanda");
        module.Start();
        
    }
    
}
