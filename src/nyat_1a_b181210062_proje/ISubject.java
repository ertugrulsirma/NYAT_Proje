package nyat_1a_b181210062_proje;
/**
 *
 * @author ertug
 */
public interface ISubject {
    void attach(IObserver o);
    void detach(IObserver o);
    void notify(String message);
}
