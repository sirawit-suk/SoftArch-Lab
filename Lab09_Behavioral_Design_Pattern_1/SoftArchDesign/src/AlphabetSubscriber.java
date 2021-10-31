import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber{

    public AlphabetSubscriber() {
        super("Alphabet");
    }

    @Override
    public void onNext(String item) {
        System.out.println("Subscriber: Alphabet included in: " + item);
        this.writeFile(item);
    }

    @Override
    public boolean checkType(String text) {
        return text.matches(".*[a-zA-Z].*");
    }
}
