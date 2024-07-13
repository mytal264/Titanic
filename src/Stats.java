import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Stats {

    public void writeSurvivalRatesToFile(List<Passenger> passengers, File file) {
        int[] groupCounts = new int[14];
        int[] groupSurvivedCounts = new int[14];

        for (Passenger passenger : passengers) {
            int passengerClass = passenger.getPClass();
            boolean isMale = passenger.isMale();
            double age = passenger.getAge();
            int sibSp = passenger.getSibSp();
            int parch = passenger.getParch();
            double fare = passenger.getFare();

            if (passengerClass == 1) {
                groupCounts[0]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[0]++;
                }
            } else if (passengerClass == 2) {
                groupCounts[1]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[1]++;
                }
            } else if (passengerClass == 3) {
                groupCounts[2]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[2]++;
                }
            }

            if (isMale) {
                groupCounts[3]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[3]++;
                }
            } else {
                groupCounts[4]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[4]++;
                }
            }

            if (age >= 0 && age <= 10) {
                groupCounts[5]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[5]++;
                }
            } else if (age > 10 && age <= 20) {
                groupCounts[6]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[6]++;
                }
            } else if (age > 20 && age <= 30) {
                groupCounts[7]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[7]++;
                }
            } else if (age > 30 && age <= 40) {
                groupCounts[8]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[8]++;
                }
            } else if (age > 40 && age <= 50) {
                groupCounts[9]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[9]++;
                }
            } else if (age > 50) {
                groupCounts[10]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[10]++;
                }
            }

            if (sibSp > 0 || parch > 0) {
                groupCounts[11]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[11]++;
                }
            }

            if (fare > 0 && fare <= 10) {
                groupCounts[12]++;
                if (passenger.getSurvived() == 1) {
                    groupSurvivedCounts[12]++;
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