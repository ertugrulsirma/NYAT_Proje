package nyat_1a_b181210062_proje;
/**
 *
 * @author ertug
 */

class Algilayici implements IAlgilayici{
    
    private static Algilayici instance;
    private Algilayici(){}
    public static synchronized Algilayici getInstance(){
        if(instance==null)
            instance = new Algilayici();
        return instance;
    }
    
    static int sicaklik;
    @Override
    public int SicaklikOlc(){
        int max = 40; 
        int min = 10; 
        int range = max - min + 1; 
        sicaklik = (int)(Math.random() * range) + min;     
        return sicaklik;
    }
}
