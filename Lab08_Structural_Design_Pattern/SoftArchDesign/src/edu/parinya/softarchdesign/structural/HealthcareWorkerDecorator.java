package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker {

    // This class when you're implementing about time and tax will go to this class
    // Such as Surgeon class will go in and keep in variable worker
    protected HealthcareServiceable worker;

    HealthcareWorkerDecorator(HealthcareWorker worker){
        super(worker);
        this.worker = worker;
    }

    /* If subclass don't have these methods below,
     * it will use "that" method instead.
     *
     * but... If subclass already override these methods below,
     * it will only use method in subclass of it own.
     */

    @Override
    public void service() {
        /* Decorator method for service();
         * ex. if Time -> ignore this method
         *     if Tax -> use this method
         * */
        worker.service();
    }

    @Override
    public double getPrice() {
        /* Decorator method for getPrice();
         * ex. if Tax -> ignore this method
         *     if Time -> use this method
         * */
        return worker.getPrice();
    }


}
