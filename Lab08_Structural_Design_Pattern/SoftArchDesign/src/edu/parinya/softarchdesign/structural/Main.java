package edu.parinya.softarchdesign.structural;


public class Main {

    public static void main(String[] args) {

        // Composite Structural Design Pattern

        // New 1st HealthcareWorkerTeam
        HealthcareWorkerTeam teamMedicalDragon = new HealthcareWorkerTeam();
        // New 4 HealthcareWorkers
        Surgeon ryutarou = new Surgeon("Ryutarou Asada", 0);
        Nurse miki = new Nurse("Miki Satohara", 1000);
        Cardiologist keisuke = new Cardiologist("Keisuke Fujiyoshi", 1000);
        Anesthesiologist monji = new Anesthesiologist("Monji Arase", 10000);
        // Add 4 HealthcareWorkers in 1st team
        teamMedicalDragon.addMember(ryutarou);
        teamMedicalDragon.addMember(miki);
        teamMedicalDragon.addMember(keisuke);
        teamMedicalDragon.addMember(monji);

        System.out.println("================================");
        monji.service();
        System.out.println("Monji's price is " + monji.getPrice());
        teamMedicalDragon.service();
        System.out.println("Before Monji leaves, the total price of the Team Medical Dragon is " + teamMedicalDragon.getPrice());
        teamMedicalDragon.removeMember(monji);
        System.out.println("After Monji leaves, The total price of the Team Medical Dragon is " + teamMedicalDragon.getPrice());
        System.out.println("================================");

        // Decorator Structural Design Pattern

        // New 2nd HealthcareWorkerTeam
        HealthcareWorkerTeam theGoodDoctor = new HealthcareWorkerTeam();

        // New 2 HealthcareWorkers
        Surgeon freddie = new Surgeon("Freddie Highmore", 500);
        Surgeon nicholas = new Surgeon("Nicholas Gonzalez", 2000);
        // Time and Tax for Nicholas
        HealthcareWorkerDecorator timeNicholas = new TimeLoggingHealthcareWorker(nicholas);
        HealthcareWorkerDecorator taxNicholas = new TaxPayingHealthcareWorker(timeNicholas);

        // New 1 HealthcareWorkers
        Surgeon antonia = new Surgeon("Antonia Thomas", 500);
        // Time for Antonia
        HealthcareWorkerDecorator timeAnotonia = new TimeLoggingHealthcareWorker(antonia);

        // New 1 HealthcareWorkers
        Surgeon chuku = new Surgeon("Chuku Modu", 500);

        // Add 4 HealthcareWorkers in 2st team
        theGoodDoctor.addMember(freddie);
        theGoodDoctor.addMember(taxNicholas);
        theGoodDoctor.addMember(timeAnotonia);
        theGoodDoctor.addMember(chuku);

        System.out.println("================================");
        theGoodDoctor.service();
        System.out.println("The total price of the Good Doctor Team is " + theGoodDoctor.getPrice());

        System.out.println("================================");
        HealthcareWorkerTeam healthcareSeries = new HealthcareWorkerTeam();
        healthcareSeries.addMember(teamMedicalDragon);
        healthcareSeries.addMember(theGoodDoctor);
        System.out.println("The total price of the healthcare series is " + healthcareSeries.getPrice());
    }
}
