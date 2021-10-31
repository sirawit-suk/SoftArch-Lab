import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String>{

    /*
    * Alright, This practice is like the slide lecture almost 99.99 %
    * */
    Set<Flow.Subscriber<? super String>> subscribers = new HashSet<>();

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        subscribers.add(subscriber);
        System.out.println("Subscribed by " + subscriber.toString());
    }

    public void unsubscribe(Flow.Subscriber<? super String> subscriber) {
        subscribers.remove(subscriber);
        System.out.println("UnSubscribed by " + subscriber.toString());
    }

    public void publish(String text){
        this.notifyAll(text); // haha, it's for human understanding propose only this one
                            // In other word, it's "Business Logic"
    }

    private void notifyAll(String text){
       subscribers.iterator().forEachRemaining(subscriber ->{
           if(((StringSubscriber)subscriber).checkType(text)){
               subscriber.onNext(text);
           }
       });
    }
}
