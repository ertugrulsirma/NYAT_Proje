package nyat_1a_b181210062_proje;
/**
 *
 * @author ertug
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class VeritabaniBaglantisi implements IVeritabaniBaglantisi {
    
    private static VeritabaniBaglantisi instance;
    private VeritabaniBaglantisi(){}
    
    public static synchronized VeritabaniBaglantisi getInstance(){
        if(instance==null)
            instance = new VeritabaniBaglantisi();
        return instance;
    }

    @Override
    public Connection Baglan() {
    String DB_URL = "jdbc:postgresql://localhost:5432/nyatProje";
    String USER = "postgres";
    String PASS = "pCorseosi#3l";
    
    Connection conn = null;
    
    try{
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        if(conn!=null)
            System.out.println("Veritabanı bağlantısı başarılı.");
        else
            System.out.println("Veritabanı bağlantısı başarısız.");
    } catch(Exception e){
        e.printStackTrace();
    }
        return conn;      
    }   
}
