/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasiku;


public class tabungan  {

   
	int saldo;
       

    public tabungan(int initsaldo) {
    	saldo=initsaldo;
    }

  
    public int getSaldo(){
        return saldo;
    }
      public void simpanUang(int jumlah){
     	saldo+=jumlah;
      }
     public boolean ambilUang(int jumlah){
     boolean cek=false;
      if(saldo>=jumlah){
         cek=true;
         saldo-=jumlah; 
         
     }
      return cek;
} 
}


