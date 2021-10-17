package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator {

    TaxPayingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+ worker.getName() +" with TaxPaying");
    }

    public double getPrice() {
         // Add *110% charges
         // need to use super.method() to use "worker variable" inside HealthcareWorkerDecorator
        return super.getPrice() * 1.1;
    }
}
