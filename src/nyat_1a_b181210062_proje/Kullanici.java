package nyat_1a_b181210062_proje;
/**
 *
 * @author ertug
 */
public class Kullanici implements IObserver{

    String kullaniciAdi;
    String sifre;

    @Override
    public void update(String message) {
        System.out.println("1 YENİ DUYURU !" +message);
    }
    
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }   
}
