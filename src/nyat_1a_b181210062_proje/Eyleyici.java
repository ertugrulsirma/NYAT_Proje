package nyat_1a_b181210062_proje;
/**
 *
 * @author ertug
 */
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Eyleyici implements IEyleyici {
    
    private static Eyleyici instance;
    private Eyleyici() {}
    
    public static synchronized Eyleyici getInstance(){
        if(instance==null)
            instance = new Eyleyici();
        return instance;
    }
    
    static int sicaklik;
    @Override
    public void SogutucuAc(){
        System.out.println("Soğutucu çalışmaya başladı.");

    }
    
    @Override
    public void SogutucuDurdur(){
        System.out.println("Soğutucu başarıyla durduruldu.");
    }
}
