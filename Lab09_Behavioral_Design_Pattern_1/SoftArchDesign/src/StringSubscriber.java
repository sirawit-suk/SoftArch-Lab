import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String>{

    protected  Flow.Subscription subscription; // keep it for nothing :/
    protected String type;

    private String directoryFile = System.getProperty("user.dir") + "\\savefile\\";

    //reference Create file: https://www.w3schools.com/java/java_files_create.asp
    public  StringSubscriber(String type){
        this.type = type;
        try {
            File myObj = new File(directoryFile + type + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void onSubscribe(Flow.Subscription subscription){
        this.subscription = subscription; // Don't know what to do here, Not used
    }

    @Override
    public abstract void onNext(String item);

    @Override
    public void onError(Throwable throwable) { // use for multi threads purpose, Not used here
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() { // use for multi threads purpose, Not used here
        System.out.println("Completed");
    }

    public abstract boolean checkType(String text);

    protected void writeFile(String item){

        String pattern = "HH:mm:ss EEE MMM d yyyy : ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        try {
            FileWriter myWriter = new FileWriter(directoryFile + this.type +".txt", true);
            PrintWriter myPrinter = new PrintWriter(myWriter);
            myPrinter.print(date + item + "\n");
            myPrinter.close();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.type + " Subscriber";
    }
}
