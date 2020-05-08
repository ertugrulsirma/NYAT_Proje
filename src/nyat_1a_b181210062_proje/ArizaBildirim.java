package nyat_1a_b181210062_proje;
/**
 *
 * @author ertug
 */
import java.util.ArrayList;
import java.util.List;

public class ArizaBildirim implements ISubject {

    List<IObserver> arizaliKullanici = new ArrayList<IObserver>(); 
    @Override
    public void attach(IObserver o){
        arizaliKullanici.add(o);   
    }

    @Override
    public void detach(IObserver o) {
        arizaliKullanici.remove(o);
    }

    @Override
    public void notify(String message) {
        for(IObserver observer: arizaliKullanici){
            observer.update(message);
        }
    }
    
}
