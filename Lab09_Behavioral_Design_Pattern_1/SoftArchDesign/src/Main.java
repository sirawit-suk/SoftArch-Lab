import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is Observer Behavioral Design Pattern");

        AlphabetSubscriber alphabetSubscriber = new AlphabetSubscriber();
        NumberSubscriber numberSubscriber = new NumberSubscriber();
        SymbolSubscriber symbolSubscriber = new SymbolSubscriber();

        StringPublisher publisher = new StringPublisher();
        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(numberSubscriber);
        publisher.subscribe(symbolSubscriber);

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter String (enter q to exit): ");
            String inputText = scanner.nextLine();  // Read user input
            if(!inputText.equals("q")){
                publisher.publish(inputText);
            }else {
                publisher.unsubscribe(alphabetSubscriber);
                publisher.unsubscribe(numberSubscriber);
                publisher.unsubscribe(symbolSubscriber);
                break;
            }
        }



    }
}
