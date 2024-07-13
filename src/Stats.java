import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Stats {

    public void writeSurvivalRatesToFile(List<Passenger> passengers, File file) {
        int[] groupCounts = new int[19];
        int[] groupSurvivedCounts = new int[19];

        for (Passenger passenger : passengers) {
            int passengerClass = passenger.getPClass();
            boolean isMale = passenger.isMale();
            double age = passenger.getAge();
            int sibSp = passenger.getSibSp();
            int parch = passenger.getParch();
            double fare = passenger.getFare();
            String embarked = passenger.getEmbarked();

            if (passengerClass == 1) {
                groupCounts[0]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[0]++;
                }
            } else if (passengerClass == 2) {
                groupCounts[1]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[1]++;
                }
            } else if (passengerClass == 3) {
                groupCounts[2]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[2]++;
                }
            }

            if (isMale) {
                groupCounts[3]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[3]++;
                }
            } else {
                groupCounts[4]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[4]++;
                }
            }

            if (age >= 0 && age <= 10) {
                groupCounts[5]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[5]++;
                }
            } else if (age > 10 && age <= 20) {
                groupCounts[6]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[6]++;
                }
            } else if (age > 20 && age <= 30) {
                groupCounts[7]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[7]++;
                }
            } else if (age > 30 && age <= 40) {
                groupCounts[8]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[8]++;
                }
            } else if (age > 40 && age <= 50) {
                groupCounts[9]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[9]++;
                }
            } else if (age > 50) {
                groupCounts[10]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[10]++;
                }
            }

            if (sibSp > 0 || parch > 0) {
                groupCounts[11]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[11]++;
                }
            } else {
                groupCounts[12]++;
                if (passenger.isSurvived()){
                    groupSurvivedCounts[12]++;
                }
            }

            if (fare > 0 && fare <= 10) {
                groupCounts[13]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[13]++;
                }
            } else if (fare > 10 && fare <= 30){
                groupCounts[14]++;
                if (passenger.isSurvived()) {
                    groupSurvivedCounts[14]++;
                }
            } else {
                groupCounts[15]++;
                if (passenger.isSurvived()){
                    groupSurvivedCounts[15]++;
                }
            }

            if (embarked.equals("C")){
                groupCounts[16]++;
                if (passenger.isSurvived()){
                    groupSurvivedCounts[16]++;
                }
            } else if (embarked.equals("Q")) {
                groupCounts[17]++;
                if (passenger.isSurvived()){
                    groupSurvivedCounts[17]++;
                }
            } else {
                groupCounts[18]++;
                if (passenger.isSurvived()){
                    groupSurvivedCounts[18]++;
                }
            }
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            String[] groupLabels = {
                    "First Class",
                    "Second Class",
                    "Third Class",
                    "Male",
                    "Female",
                    "Ages 0-10",
                    "Ages 11-20",
                    "Ages 21-30",
                    "Ages 31-40",
                    "Ages 41-50",
                    "Ages 51+",
                    "Has Sibling/Spouse or Parent/Child",
                    "Has no Sibling/Spouse or Parent/Child",
                    "Fare under $10",
                    "Fare $11-$30",
                    "Fare $31+",
                    "Embarked at C",
                    "Embarked at Q",
                    "Embarked at S"
            };
            for (int i = 0; i < groupCounts.length; i++) {
                double survivalRate = ((double) groupSurvivedCounts[i] / (double) groupCounts[i]) * 100.0;
                writer.println(groupLabels[i] + ": " + String.format("%.2f", survivalRate) + "% survived");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}