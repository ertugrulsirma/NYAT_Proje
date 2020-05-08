package nyat_1a_b181210062_proje;
/**
 *
 * @author ertug
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NYAT_1A_B181210062_Proje {   
    static String  kullaniciAdi;
    static String  sifre;
    static Scanner girdi = new Scanner(System.in);
    static int secim;
    static Connection conn;
    public static void main(String[] args) throws SQLException { 
        conn = VeritabaniBaglantisi.getInstance().Baglan();
        do{
            System.out.print("Hoşgeldiniz, lütfen kullanıcı adınızı giriniz: ");
            kullaniciAdi= girdi.next();
       
            System.out.print("Lütfen şifrenizi giriniz: ");
            sifre = girdi.next();
       
            if(CheckUser(kullaniciAdi,sifre) == true)
                System.out.println("Kullanıcı girişi başarılı, hoşgeldiniz.");
            else
                System.out.println("Kullanıcı adı veya şifre hatalı.");
        }while(CheckUser(kullaniciAdi,sifre) == false);
       
        MenuAndOptions();       
    }
    public static  boolean  CheckUser(String _kullaniciAdi,String _sifre) throws SQLException {
        Statement stmt = null;
        stmt = conn.createStatement();
        String sql = "SELECT * FROM kullanicilar";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
                String kullaniciAdi = rs.getString("kullaniciAdi");
                String sifre = rs.getString("sifre");
               
                if((kullaniciAdi).equals(_kullaniciAdi) && (sifre).equals(_sifre))
                   return true;   
        }
        rs.close();
        return false; 
    } 
    
    public static void MenuAndOptions(){
        System.out.println("Lütfen yapmak istediğiniz işlemi seçin:"  + "\n" +
                         "1-) Cihazın son sıcaklığını göster." + "\n" +
                         "2-) Soğutucuyu çalıştır." + "\n" +
                         "3-) Soğutucuyu kapat." + "\n" +
                         "4-) Çıkış yap.");
        secim=girdi.nextInt();

        switch (secim) {           
            case 1 :
                    Algilayici.getInstance().SicaklikOlc();
                    System.out.println("Cihazınızın anlık sıcaklığı " + Algilayici.getInstance().sicaklik +"°C'dir.");
                    MenuAndOptions();    
                break;

            case 2 :
                    Eyleyici.getInstance().SogutucuAc();
                    MenuAndOptions();
                break;
            
            case 3 :
                    Eyleyici.getInstance().SogutucuDurdur();
                    MenuAndOptions();
                break;
                
            case 4 :
                System.out.println("Sistemden çıkış yapılıyor.");
                System.exit(0);
                break;
        }
    }
}

