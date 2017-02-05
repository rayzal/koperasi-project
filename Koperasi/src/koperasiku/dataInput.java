
package koperasiku;

/**
 *
 * @author Rayzal
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
public class dataInput {
    

//ARRAY DAN OBJEK
    
    int pilih;
    boolean status;
    
    SimpleDateFormat sdfdate = new SimpleDateFormat("dd-MM-yyyy");
    Scanner sc = new Scanner(System.in);
    BufferedReader data = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<anggotaBaru> anggota = new ArrayList<anggotaBaru>();
    ArrayList<pinjam> pinjam = new ArrayList<pinjam>();
    tabungan tabung = new tabungan(50000000);
   
    
        
      
        // menu utama
        public void menuAwal(){
            System.out.println("###############################################");
            System.out.println("#       SISTEM KOPERASI SIMPAN-PINJAM         #");
            System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
            System.out.println("###############################################");
            System.out.println(" 1. Anggota Baru");
            System.out.println(" 2. List Anggota");
            System.out.println(" 3. Data Koperasi");
            System.out.println(" 4. Pinjam");
            System.out.println(" 5. Bayar Pinjaman");
            System.out.println(" 6. Exit");
            System.out.print(" Pilih Menu :   ");
            pilih = sc.nextInt();
             
        }
        
        //menu login
        public void login(){
            int pin;
            login masuk = new login();
            masuk.setPin(123);
            System.out.println("###############################################");
            System.out.println("#       SISTEM KOPERASI SIMPAN-PINJAM         #");
            System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
            System.out.println("###############################################");
            System.out.print("  Masukkan kata sandi admin : ");
            pin = sc.nextInt();
            System.out.println("###############################################");

            if (masuk.getPin() == pin) {
                menuAwal();
            } else {
                System.out.println("Password salah silahkan login kembali");
                login();
            }
}
        
         //menu anggota baru
        public void anggotaBaru(){
        
            String nama, lahir, alamat, kerja;
            int saldo, ktp, telpon, uangSim, uangPin;

            System.out.println("###############################################");
            System.out.println("#        SISTEM KOPERASI SIMPAN-PINJAM        #");
            System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
            System.out.println("###############################################");
            System.out.println(" Masukkan biodata anggota baru :");
            int x = 0;
        try{
 do{
             System.out.println(" ");
             System.out.println(" Biodata Anggota " + (x + 1));
             System.out.print(" Nama : ");
             nama = data.readLine();
             System.out.print(" Tanggal Lahir :");
             lahir = data.readLine();
             System.out.print(" ktp :");
             ktp = Integer.parseInt(data.readLine());
             System.out.print(" Alamat :");
             alamat = data.readLine();
             System.out.print(" Pekerjaan :");
             kerja = data.readLine();
             System.out.print(" Nomor telepon :");
             telpon = Integer.parseInt(data.readLine());
             System.out.print(" Tabungan : Rp.");
             uangSim = Integer.parseInt(data.readLine());

             tabung.simpanUang(uangSim);
             anggota.add(new anggotaBaru(nama, lahir, ktp, alamat, kerja, telpon, uangSim));
        //         pinjam.add(new pinjam(uangPin));
             System.out.print("Tambah Data ? (Y / N) :: ");
             if (sc.next().equals("N")) {
                 x++;
                   break;
                  
            }else{
               x++;
            }
           
            }while(true);
        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();
            
        }

            //bioadata Anggota
        public void biodata(){
        System.out.println("###############################################");
        System.out.println("#        SISTEM KOPERASI SIMPAN-PINJAM        #");
        System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
        System.out.println("###############################################");
                 
        System.out.println("Biodata Anggota :");
        
        for (int i=0 ; i < anggota.size(); i++) {
        
        System.out.println("");        
        
        System.out.println(" Biodata Anggota "+(i+1));  
        System.out.println(" Nama : "+anggota.get(i).getNama());
        
        System.out.println(" Tanggal Lahir : "+anggota.get(i).getLahir()); 
   
        System.out.println(" ktp : "+anggota.get(i).getKtp()); 
 
        System.out.println(" Alamat : "+anggota.get(i).getAlamat()); 
  
        System.out.println(" Pekerjaan : "+anggota.get(i).getKerja()); 

        System.out.println(" Nomor telepon :  "+anggota.get(i).getTelpon()); 
        
        System.out.println(" Jumlah Tabungan : Rp."+anggota.get(i).getUangSim()); 
        
            }
     
       menuAwal();
}
      
      

        public void pinjam() {
        System.out.println("###############################################");
        System.out.println("#        SISTEM KOPERASI SIMPAN-PINJAM        #");
        System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
        System.out.println("###############################################");
                 
        System.out.println("MENU PEMINJAMAN ");
       
      
            
                 for (int k = 0; k < anggota.size(); k++) {
                
                if (anggota.get(k).getNama() != null) {
                    System.out.println(k+" )"+anggota.get(k).getNama());
                   
                }
                
            }
           
            System.out.print(" \nPilih Indeks Anggota  : ");
            pilih = sc.nextInt();
          
            if(pilih == 0 ){
             try{
                       for (int i = 0; i < anggota.size(); i++) {
                           int uangPin;
                          
                            System.out.println("");

                           

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pinjaman : Rp.");
                           uangPin = Integer.parseInt(data.readLine());
                           tabung.ambilUang(uangPin);
                            pinjam.add(new pinjam(uangPin));
                            notaPinjam(i);
 		
                               }            
                        
                         
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
            } else if(pilih == 1){
                try{
                       for (int i = 1; i < anggota.size(); i++) {
                           int uangPin;
                       
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pinjaman : Rp.");
                           uangPin = Integer.parseInt(data.readLine());
                           tabung.ambilUang(uangPin);
                           pinjam.add(new pinjam(uangPin));
                             
                         notaPinjam(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
                } else if(pilih == 2){
                  try{
                       for (int i = 2; i < anggota.size(); i++) {
                           int uangPin;
                      
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pinjaman : Rp.");
                           uangPin = Integer.parseInt(data.readLine());
                           tabung.ambilUang(uangPin);
                           pinjam.add(new pinjam(uangPin));

                         notaPinjam(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
                
            }else if(pilih == 3){
                  try{
                       for (int i = 3; i < anggota.size(); i++) {
                           int uangPin;
                           
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pinjaman : Rp.");
                           uangPin = Integer.parseInt(data.readLine());
                           tabung.ambilUang(uangPin);
                           pinjam.add(new pinjam(uangPin));
                             
                         notaPinjam(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
            }else if(pilih==4){
                  try{
                       for (int i = 4; i < anggota.size(); i++) {
                           int uangPin;
      
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pinjaman : Rp.");
                           uangPin = Integer.parseInt(data.readLine());
                           tabung.ambilUang(uangPin);
                           pinjam.add(new pinjam(uangPin));
                             
                         notaPinjam(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
            } else{
                System.out.println(" Pilihan anda salah, Pilih lagi");
                pinjam();
            }
          
            }
        
       
        public void bayar(){
                System.out.println("###############################################");
                System.out.println("#        SISTEM KOPERASI SIMPAN-PINJAM        #");
                System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
                System.out.println("###############################################");
                System.out.println(" PEMBAYARAN");
                
                 for (int k = 0; k < anggota.size(); k++) {
                
                if (anggota.get(k).getNama() != null) {
                    System.out.println(k+" )"+anggota.get(k).getNama());
                   
                }
                
            }
           
            System.out.print(" Pilih Indeks Anggota  : ");
            pilih = sc.nextInt();
          
            if(pilih == 0 ){
             try{
                       for (int i = 0; i < anggota.size(); i++) {
                           int uangPin= pinjam.get(i).getUangPin();
                           int uangSim;
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pembayaran : Rp.");
                           uangSim = Integer.parseInt(data.readLine());
                           tabung.simpanUang(uangSim);
                           pinjam.add(new pinjam(uangPin-uangSim));
                           
                             
                         notaBayar(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
                
            }  else if(pilih == 1){
            try{
                       for (int i = 0; i < anggota.size(); i++) {
                           int uangPin= pinjam.get(i).getUangPin();
                           int uangSim;
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pembayaran : Rp.");
                           uangSim = Integer.parseInt(data.readLine());
                           tabung.simpanUang(uangSim);
                           pinjam.add(new pinjam(uangPin-uangSim));
                           
                             
                         notaBayar(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
                               
            }  else if(pilih == 2){
            try{
                       for (int i = 0; i < anggota.size(); i++) {
                           int uangPin= pinjam.get(i).getUangPin();
                           int uangSim;
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pembayaran : Rp.");
                           uangSim = Integer.parseInt(data.readLine());
                           tabung.simpanUang(uangSim);
                           pinjam.add(new pinjam(uangPin-uangSim));
                           
                             
                         notaBayar(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
                
                
            }else if(pilih == 3){
                  try{
                       for (int i = 0; i < anggota.size(); i++) {
                           int uangPin= pinjam.get(i).getUangPin();
                           int uangSim;
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pembayaran : Rp.");
                           uangSim = Integer.parseInt(data.readLine());
                           tabung.simpanUang(uangSim);
                           pinjam.add(new pinjam(uangPin-uangSim));
                           
                             
                         notaBayar(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
                
            }else if(pilih==4){
                  try{
                       for (int i = 0; i < anggota.size(); i++) {
                           int uangPin= pinjam.get(i).getUangPin();
                           int uangSim;
                           System.out.println("");

                           System.out.println(" Biodata Anggota " + (i + 1));
                           System.out.println(" Nama : " + anggota.get(i).getNama());

                           System.out.println(" Tanggal Lahir : " + anggota.get(i).getLahir());

                           System.out.println(" ktp : " + anggota.get(i).getKtp());

                           System.out.println(" Alamat : " + anggota.get(i).getAlamat());

                           System.out.println(" Pekerjaan : " + anggota.get(i).getKerja());

                           System.out.println(" Nomor telepon :  " + anggota.get(i).getTelpon());

                           System.out.println(" Jumlah Tabungan : Rp. " + anggota.get(i).getUangSim());
                           System.out.print(" Pembayaran : Rp.");
                           uangSim = Integer.parseInt(data.readLine());
                           tabung.simpanUang(uangSim);
                           pinjam.add(new pinjam(uangPin-uangSim));
                           
                             
                         notaBayar(i);
                         
            }
                        }catch(IOException e){
                 System.out.println("Error!");
                              } 
              menuAwal();  
                
            } else{
                System.out.println(" Pilihan anda salah, Pilih lagi");
                pinjam();
            }
        }
        
      
        public void koperasi(){
                System.out.println("###############################################");
                System.out.println("#        SISTEM KOPERASI SIMPAN-PINJAM        #");
                System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
                System.out.println("###############################################");
                System.out.println(" DATA KOPERASI");
                System.out.println(" ");
                System.out.println(" Saldo awal Koperasi     : Rp.50000000 ");
                System.out.println(" Saldo Koperasi saat ini : Rp."+tabung.getSaldo());
         menuAwal();
             }
        
            public void notaPinjam(int i){
                System.out.println("###############################################");
                System.out.println("#        SISTEM KOPERASI SIMPAN-PINJAM        #");
                System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
                System.out.println("###############################################");
                System.out.println(" Nota Pinjaman");
                System.out.println(" Nama : " + anggota.get(i).getNama());
                System.out.println(" Jumlah Pinjaman : " + pinjam.get(i).getUangPin());
                
                Date tanggal = new Date();
                System.out.println(" Tangga peminjaman: " + sdfdate.format(tanggal));

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, 3); //menghitung 3 bulan kemudian
                Date tigabulanlagi = cal.getTime(); //membuat variabel yang bertipe Date yang menyimpan 3 bulan kemudian
                System.out.println(" Batas tenggang waktu : " + sdfdate.format(tigabulanlagi));
                menuAwal();
            }
        
            
            public void notaBayar(int i){
                System.out.println("###############################################");
                System.out.println("#        SISTEM KOPERASI SIMPAN-PINJAM        #");
                System.out.println("#      Jl. Sanggam No.08 Samarinda Ilir       #");
                System.out.println("###############################################");
                System.out.println(" Nota Pembayaran");
                System.out.println(" Nama : " + anggota.get(i).getNama());
                System.out.println(" Jumlah Pinjaman : " + pinjam.get(i+1).getUangPin());
                
                Date tanggal = new Date();
                System.out.println(" Tangga peminjaman: " + sdfdate.format(tanggal));

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, 3); //menghitung 3 bulan kemudian
                Date tigabulanlagi = cal.getTime(); //membuat variabel yang bertipe Date yang menyimpan 3 bulan kemudian
                System.out.println(" Batas tenggang waktu : " + sdfdate.format(tigabulanlagi));
                menuAwal();
            }
       
      public void transaksiLagi() {
          String warn;
          Scanner scan = new Scanner(System.in);
          System.out.println("=======================================================");
          System.out.print("Apakah Anda ingin melakukan transaksi lagi ? [y/n] ");
          warn = scan.nextLine();
          System.out.println();
          if (warn.equalsIgnoreCase("y")) {
              login();
          } else if (warn.equalsIgnoreCase("n")) {
              System.out.println("=======================================================");
              System.out.println("\tTerimakasih telah menggunakan layanan kami.");

          }
    }    
         
}
