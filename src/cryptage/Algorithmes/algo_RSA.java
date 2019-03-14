/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptage.Algorithmes;

import cryptage.Utilisateurs.Message;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hk619751
 */
public class algo_RSA implements Algo{

    long e;
    long N;
    long phiN;
    long p1;
    long p2;
    
    public algo_RSA() {
    }

    @Override
    public ArrayList<String> GenererClePublique() {
        Random r = new Random();
        ArrayList<String> res = new ArrayList<>();
        p1=0;
        p2=0;
        long temp;
        while (!Miller_Rabin(p1,100)){ 
            temp = r.nextLong();
            if(temp<0) temp=-temp;
            p1 = temp+(long)Math.pow(2,17);
            if(p1%2==0) p1++; 
            else p1+=2;
        }
        while(!Miller_Rabin(p2,100)){
            temp = r.nextLong();
            if(temp<0) temp=-temp;
            p2 =temp+(long)Math.pow(2,17);
            if(p2%2==0) p2++;
            else p2+=2;
        }
        N = p1*p2;
        phiN=(p1-1)*(p2-1);
        e = r.nextLong();
        while(PGCD(e,phiN)!=1){
            e = r.nextLong();
            if(e<0) e=-e;
        }
        res.add(Long.toString(e));
        res.add(Long.toString(N));
        
        return res;
    }

    @Override
    public ArrayList<String> GenererClePrivee() {
        ArrayList<String> res = new ArrayList<>();
        long inverse = this.inverse_modulo(e, phiN);
        
        res.add(Long.toString(inverse));
        res.add(Long.toString(p1));
        res.add(Long.toString(p2));
        
        return res;
    }

    @Override
    public Message crypter(Message _message, ArrayList<String> cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message decrypter(Message _message, ArrayList<String> cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private long puissance_modulo(long a, long b, long n){
        long res = 1;
        for(int i=0;i<b;i++){
            res=res*a%n;
        }
        return res;
    }
    /**
     * 
     * @param a un entier > 1
     * @param n un entier impair >= 3
     * @return faux si a n'est pas un témoin de Miller et vrai si a est un témoin de Miller
     */
    public boolean temoin_miller(long a, long n){
        long d;
        long s=0;
        long temp = n-1;
        while(temp%2==0){
            temp=temp/2;
            s++;
        }
        d=temp;
        long x = this.puissance_modulo(a, d, n);
        if(x==1 || x==n-1) return false;
        while(s>1){
            x=this.puissance_modulo(x, 2, n);
            if(x==n-1) return false;
            s--;
        }
        return true;
    }
    
    public boolean Miller_Rabin(long n, long k){
        Random r = new Random();
        for(int i=0;i<k;i++){
            long alea = r.nextLong();
            if(alea < 0) {alea = -alea;}
            long aleaMod = alea%(n-5);
            long a = aleaMod+2;
            //long a = (r.nextLong()%(n-5))+2;
            if(this.temoin_miller(a, n)) return false;
        }
        return true;
    }
    
    public long inverse_modulo(long i, long n){
        long r = i;
        long r2 = n;
        long u=1;
        long u2 = 0;
        long rs;
        long us;
        long q;
        
        while(r2 != 0){
            q = r/r2;
            rs = r;
            us = u;
            r = r2;
            u = u2;
            r2 = rs - q*r2;
            u2 = us - q*u2;
        }
        return u;
    }
    
    public long PGCD(long a, long b){
        while(a*b != 0){
            if(a>b) a=a-b;
            else b = b-a;
        }
        if(a == 0)return b;
        return a;
    }
}
