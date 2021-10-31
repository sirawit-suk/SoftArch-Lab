import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription{

    /*
    * request not used, it's use for back pressure (for multi threads propose)
    * Reference: https://www.youtube.com/watch?v=_stAxdjx8qk&t=620s&ab_channel=Devoxx
    * */
    @Override
    public void request(long n) {}

    /*
    * implement cancel in publisher using unsubscribe();
    * */
    @Override
    public void cancel() {}

}
