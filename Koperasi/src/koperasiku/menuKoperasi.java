/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasiku;



public class menuKoperasi extends dataInput {
    @Override
    public void menuAwal(){
                
            super.menuAwal();
        switch (pilih) {
            case 1:
                anggotaBaru();
                break;
            case 2:
                biodata();
                break;
            case 3:
                koperasi();
                break;
            case 4:
                pinjam();
                break;
            case 5:
                bayar();
                break;
            case 6:
                System.out.println("###############################################");
                System.out.println("===============================================");
                System.out.println("\t\t Terima Kasih");
                
                    ;
                break;
            default:
                System.out.println("#     Menu yang anda pilih tidak ada     #");
                menuAwal();
        }
    }   
 }

