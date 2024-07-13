import java.util.Objects;

public class Passenger {
    private int passengerId;
    private int survived;
    private int pClass;
    private String name;
    private Boolean male;
    private double age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;

    public Passenger(String line) {
        String[] data = line.split(",");
        try {
            if (Integer.parseInt(data[Constants.PASSENGER_ID]) >= 0) {
                this.passengerId = Integer.parseInt(data[Constants.PASSENGER_ID]);
            }
            if (Integer.parseInt(data[Constants.SURVIVED]) == 0 || Integer.parseInt(data[Constants.SURVIVED]) == 1) {
                this.survived = Integer.parseInt(data[Constants.SURVIVED]);
            }
            if (Integer.parseInt(data[Constants.P_CLASS]) > 0 && Integer.parseInt(data[Constants.P_CLASS]) <= 3) {
                this.pClass = Integer.parseInt(data[Constants.P_CLASS]);
            }
            this.name = getFormattedName(data[Constants.FIRST_NAME], data[Constants.LAST_NAME]);
            this.male = isMale(data[Constants.SEX]);
            if (!Objects.equals(data[Constants.AGE], "")) {
                this.age = Double.parseDouble(data[Constants.AGE]);
            } else this.age = Constants.NULL_AGE;
            if (Integer.parseInt(data[Constants.SIB_SP]) >= 0) {
                this.sibSp = Integer.parseInt(data[Constants.SIB_SP]);
            }
            if (Integer.parseInt(data[Constants.PARCH]) >= 0) {
                this.parch = Integer.parseInt(data[Constants.PARCH]);
            }
            this.ticket = data[Constants.TICKET];
            if (Double.parseDouble(data[Constants.FARE]) >= 0) {
                this.fare = Double.parseDouble(data[Constants.FARE]);
            }
            this.cabin = data[Constants.CABIN];
            if (data.length == 13) {
                this.embarked = data[Constants.EMBARKED];
            } else this.embarked = Constants.NULL_EMBARKED + "";
        } catch (Exception e) {
            System.out.println(this.passengerId + " problem reading file");
            e.fillInStackTrace();
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private String getFormattedName(String firstName, String lastName) {
        final char SUBSTRING_CHAR = '.';
        String output = firstName.substring(firstName.indexOf(SUBSTRING_CHAR) + 1) + lastName;
        output = output.replace('"', ' ');
        return output;

    }

    public int getPClass() {
        return pClass;
    }
    public double getAge() {
        return age;
    }
    public int getSibSp() {
        return sibSp;
    }
    public int getParch() {
        return parch;
    }
    public double getFare() {
        return fare;
    }
    public boolean isMale (){
        return this.male;
    }
    private Boolean isMale(String sex) {
        Boolean result = null;
        if (sex != null) {
            result = sex.equalsIgnoreCase("male");
        }
        return result;
    }
    public String getEmbarked() {
        return embarked;
    }

    @Override
    public String toString() {
        String output = this.passengerId + ",";
        output += this.survived + ",";
        output += this.pClass + ",";
        output += this.name + ",";
        output += (this.male)? "male,": "female,";
        if (this.age==Constants.NULL_AGE) {
            output += ",";
        } else {
            output += this.age + ",";
        }
        output += this.sibSp + "," + this.parch + "," + this.ticket + ",";
        output += this.fare + "," + this.cabin + "," + this.embarked;
        return output;
    }

    public boolean matchesPClass(String pClass) {
        String classNumber = pClass.replaceAll("\\D", ""); // Remove non-digit characters
        return Integer.parseInt(classNumber) == this.pClass;
    }
    public boolean matchesPassengerId(String minId, String maxId) {
        return Integer.parseInt(minId) <= this.passengerId && Integer.parseInt(maxId) >= this.passengerId;
    }
    public boolean matchesPassengerId(String id, boolean isMaxId) {
        boolean result;
        if (isMaxId) {
            result = Integer.parseInt(id) >= this.passengerId;
        } else result = Integer.parseInt(id) <= this.passengerId;
        return result;
    }
    public boolean matchesName(String name) {
        return this.name.contains(name);
    }
    public boolean matchesSex(String sex) {
        boolean compare;
        final String MALE = "male";
        compare = sex.equalsIgnoreCase(MALE);
        return compare == this.male;
    }
    public boolean matchesSibSp(String sibSp) {
        return Integer.parseInt(sibSp) == this.sibSp;
    }
    public boolean matchesParch(String parch) {
        return Integer.parseInt(parch) == this.parch;
    }
    public boolean matchesPassengerFare(String minFare, String maxFare) {
        return Integer.parseInt(minFare) <= this.fare && Integer.parseInt(maxFare) >= this.fare;
    }
    public boolean matchesPassengerFare(String fare, boolean isMaxFare) {
        boolean result;
        if (isMaxFare) {
            result = Integer.parseInt(fare) >= this.fare;
        } else result = Integer.parseInt(fare) <= this.fare;
        return result;
    }
    public boolean matchesTicket(String ticket) {
        return ticket.equalsIgnoreCase(this.ticket);
    }
    public boolean matchesCabin(String cabin) {
        return cabin.equalsIgnoreCase(this.cabin);
    }
    public boolean matchesEmbarked(String embarked) {
        return embarked.equalsIgnoreCase(this.embarked);
    }
    public boolean isSurvived() {
        return this.survived==Constants.SURVIVED;
    }
}