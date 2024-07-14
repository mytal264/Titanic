import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stats {

    private int[] groupCounter (List<Passenger> passengers,boolean isSurvived){
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
                if (passenger.isSurvived()) groupSurvivedCounts[0]++;
            } else if (passengerClass == 2) {
                groupCounts[1]++;
                if (passenger.isSurvived()) groupSurvivedCounts[1]++;
            } else if (passengerClass == 3) {
                groupCounts[2]++;
                if (passenger.isSurvived()) groupSurvivedCounts[2]++;
            }

            if (isMale) {
                groupCounts[3]++;
                if (passenger.isSurvived()) groupSurvivedCounts[3]++;
            } else {
                groupCounts[4]++;
                if (passenger.isSurvived()) groupSurvivedCounts[4]++;
            }

            if (age >= 0 && age <= 10) {
                groupCounts[5]++;
                if (passenger.isSurvived()) groupSurvivedCounts[5]++;
            } else if (age > 10 && age <= 20) {
                groupCounts[6]++;
                if (passenger.isSurvived()) groupSurvivedCounts[6]++;
            } else if (age > 20 && age <= 30) {
                groupCounts[7]++;
                if (passenger.isSurvived()) groupSurvivedCounts[7]++;
            } else if (age > 30 && age <= 40) {
                groupCounts[8]++;
                if (passenger.isSurvived()) groupSurvivedCounts[8]++;
            } else if (age > 40 && age <= 50) {
                groupCounts[9]++;
                if (passenger.isSurvived()) groupSurvivedCounts[9]++;
            } else if (age > 50) {
                groupCounts[10]++;
                if (passenger.isSurvived()) groupSurvivedCounts[10]++;
            }

            if (sibSp > 0 || parch > 0) {
                groupCounts[11]++;
                if (passenger.isSurvived()) groupSurvivedCounts[11]++;
            } else {
                groupCounts[12]++;
                if (passenger.isSurvived()) groupSurvivedCounts[12]++;
            }

            if (fare > 0 && fare <= 10) {
                groupCounts[13]++;
                if (passenger.isSurvived()) groupSurvivedCounts[13]++;
            } else if (fare > 10 && fare <= 30) {
                groupCounts[14]++;
                if (passenger.isSurvived()) groupSurvivedCounts[14]++;
            } else {
                groupCounts[15]++;
                if (passenger.isSurvived()) groupSurvivedCounts[15]++;
            }

            if (embarked.equals("C")) {
                groupCounts[16]++;
                if (passenger.isSurvived()) groupSurvivedCounts[16]++;
            } else if (embarked.equals("Q")) {
                groupCounts[17]++;
                if (passenger.isSurvived()) groupSurvivedCounts[17]++;
            } else {
                groupCounts[18]++;
                if (passenger.isSurvived()) groupSurvivedCounts[18]++;
            }
        }
        if (isSurvived){
            return groupSurvivedCounts;
        }
        return groupCounts;
    }

    public void writeSurvivalRatesToFile(List<Passenger> passengers, File file) {
        int[] groupCounts = groupCounter(passengers,false);
        int[] groupSurvivedCounts = groupCounter(passengers,true);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < groupCounts.length; i++) {
                double survivalRate = ((double) groupSurvivedCounts[i] / (double) groupCounts[i]) * 100.0;
                writer.println(Constants.GROUP_LABELS[i] + ": " + String.format("%.2f", survivalRate) + "% survived");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public Map<String , Float> dataGrouping (List<Passenger> passengers){
        int[] groupCounts = groupCounter(passengers,false);
        Map<String , Float> dataGrouping = new HashMap<>();
        int totalPassengers = passengers.size();
        int survived=0;
        int notSurvived=0;
        for (Passenger passenger : passengers){
            if (passenger.isSurvived()){
                survived++;
            } else notSurvived++;
        }
        dataGrouping.put("Not Survived", ((float) notSurvived / totalPassengers * 100));
        dataGrouping.put("Survived", ((float) survived / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[0], ((float) groupCounts[0] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[1], ((float) groupCounts[1] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[2], ((float) groupCounts[2] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[3], ((float) groupCounts[3] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[4], ((float) groupCounts[4] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[5], ((float) groupCounts[5] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[6], ((float) groupCounts[6] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[7], ((float) groupCounts[7] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[8], ((float) groupCounts[8] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[9], ((float) groupCounts[9] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[10], ((float) groupCounts[10] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[11], ((float) groupCounts[11] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[12], ((float) groupCounts[12] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[13], ((float) groupCounts[13] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[14], ((float) groupCounts[14] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[15], ((float) groupCounts[15] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[16], ((float) groupCounts[16] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[17], ((float) groupCounts[17] / totalPassengers * 100));
        dataGrouping.put(Constants.GROUP_LABELS[18], ((float) groupCounts[18] / totalPassengers * 100));
        return dataGrouping;
    }
}