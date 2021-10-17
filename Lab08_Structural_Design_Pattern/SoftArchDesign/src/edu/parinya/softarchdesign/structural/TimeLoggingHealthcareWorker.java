package edu.parinya.softarchdesign.structural;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{

    TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+ worker.getName() +" with TimeLogging");
    }

    public void service() {
        //References: http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
        //            https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

        //Thu Oct 14 00:57:26 ICT 2021:
        String pattern = "EEE MMM d HH:mm:ss z yyyy: ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        //Add timeLogging here
        System.out.print(date);

        // need to use super.method() to use "worker variable" inside HealthcareWorkerDecorator
        super.service();
    }
}
