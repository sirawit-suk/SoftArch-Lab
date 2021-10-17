package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet; // order version of HashSet  //Reference: https://www.geeksforgeeks.org/set-in-java/
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    private Set<HealthcareServiceable> members = new LinkedHashSet<HealthcareServiceable>();

    public void addMember(HealthcareServiceable worker) {
        members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker) {
        members.remove(worker);
    }

    public void service() {
        // print every member's services in team
        for (HealthcareServiceable member : members){
            member.service();
        }
    }

    public double getPrice() {
        // calculate totalPrice of all members in team
        double totalPrice = 0;
        for (HealthcareServiceable member : members){
            totalPrice += member.getPrice();
        }
        return totalPrice;
    }

}
