import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber{

    public SymbolSubscriber() {
        super("Symbol");
    }

    @Override
    public void onNext(String item) {
        System.out.println("Subscriber: Symbol included in: " + item);
        this.writeFile(item);
    }

    @Override
    public boolean checkType(String text) {
        return text.matches(".*[!-/:-@\\[-`{-~].*"); // Typed on my own :/
    }
}