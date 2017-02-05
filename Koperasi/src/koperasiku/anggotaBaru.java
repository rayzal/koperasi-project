
package koperasiku;

public class anggotaBaru {
       private String nama,lahir,alamat,kerja;
       private int uangSim,ktp,telpon;
      

 
        public anggotaBaru(String nama, String lahir,int ktp,String alamat,String kerja,int telpon,int uangSim){
           this.nama=nama;
           this.lahir=lahir;
           this.ktp=ktp;
           this.alamat=alamat;
           this.kerja=kerja;
           this.telpon=telpon;
           this.uangSim=uangSim;
                       }
                 
    public String getNama() {
        return nama;
    }

  
    public void setNama(String nama) {
        this.nama = nama;
    }

 
    public String getLahir() {
        return lahir;
    }

 
    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

   
    public int getKtp() {
        return ktp;
    }

   
    public void setKtp(int ktp) {
        this.ktp = ktp;
    }

   
    public String getAlamat() {
        return alamat;
    }

    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


   
    public String getKerja() {
        return kerja;
    }

    public void setKerja(String kerja) {
        this.kerja = kerja;
    }

  
    public int getTelpon() {
        return telpon;
    }

  
    public void setTelpon(int telpon) {
        this.telpon = telpon;
    }


    public int getUangSim() {
        return uangSim;
    }

    public void setUangSim(int uangSim) {
        this.uangSim = uangSim;
    }

}
 
