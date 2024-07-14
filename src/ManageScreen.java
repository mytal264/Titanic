import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class ManageScreen extends JPanel {
    private JComboBox<String> survivedComboBox;

    private JComboBox<String> passengerEmbarkedComboBox;
    private JComboBox<String> sexOfPassengerComboBox;
    private JComboBox<String> dataGroupingComboBox;
    private ArrayList<Passenger> allPassengers;
    private JTextField minPassengerIdField;
    private JTextField maxPassengerIdField;
    private JTextField passengerNameField;
    private JTextField sibSpPassengerField;
    private JTextField passengerParchField;
    private JTextField minPassengerTicketFareField;
    private JTextField maxPassengerTicketFareField;
    private JTextField passengerTicketField;
    private JTextField passengerCabinField;

    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        if (file.exists()) {
            allPassengers = readerFromCsv();

            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
            JLabel survivedLabel = new JLabel("Passenger Class: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);
            this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBox);

            JLabel minPassengerIdLabel = new JLabel("Minimum Passenger ID: ");
            minPassengerIdLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, this.survivedComboBox.getY() + Constants.MARGIN_FROM_TOP + this.survivedComboBox.getHeight(),
                    minPassengerIdLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(minPassengerIdLabel);
            this.minPassengerIdField = new JTextField();
            this.minPassengerIdField.setBounds(minPassengerIdLabel.getX() + minPassengerIdLabel.getWidth() + 1, minPassengerIdLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(minPassengerIdField);

            JLabel maxPassengerIdLabel = new JLabel("Maximum Passenger ID: ");
            maxPassengerIdLabel.setBounds(this.minPassengerIdField.getX() + this.minPassengerIdField.getWidth() + Constants.MARGIN_FROM_LEFT, minPassengerIdLabel.getY(), maxPassengerIdLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(maxPassengerIdLabel);
            this.maxPassengerIdField = new JTextField();
            this.maxPassengerIdField.setBounds(maxPassengerIdLabel.getX() + maxPassengerIdLabel.getWidth() + 1, maxPassengerIdLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.maxPassengerIdField);

            JLabel passengerNameLabel = new JLabel("Passenger Name: ");
            passengerNameLabel.setBounds(minPassengerIdLabel.getX(), this.minPassengerIdField.getY() + this.minPassengerIdField.getHeight() + Constants.MARGIN_FROM_TOP, passengerNameLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(passengerNameLabel);
            this.passengerNameField = new JTextField();
            this.passengerNameField.setBounds(minPassengerIdLabel.getX() + passengerNameLabel.getWidth() + 1, passengerNameLabel.getY(), Constants.PASSENGER_NAME_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.passengerNameField);

            JLabel sexOfPassengerLabel = new JLabel("Sex of Passenger: ");
            sexOfPassengerLabel.setBounds(minPassengerIdLabel.getX(), this.passengerNameField.getY() + Constants.COMBO_BOX_HEIGHT + Constants.MARGIN_FROM_TOP, sexOfPassengerLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(sexOfPassengerLabel);
            this.sexOfPassengerComboBox = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
            this.sexOfPassengerComboBox.setBounds(minPassengerIdLabel.getX() + sexOfPassengerLabel.getWidth() + 1, sexOfPassengerLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(sexOfPassengerComboBox);

            JLabel sibSpPassengerLabel = new JLabel("Siblings or Spouses Count: ");
            sibSpPassengerLabel.setBounds(minPassengerIdLabel.getX(), this.sexOfPassengerComboBox.getY() + sexOfPassengerComboBox.getHeight() + Constants.MARGIN_FROM_TOP, sibSpPassengerLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(sibSpPassengerLabel);
            this.sibSpPassengerField = new JTextField();
            this.sibSpPassengerField.setBounds(minPassengerIdLabel.getX() + sibSpPassengerLabel.getWidth() + 1, sibSpPassengerLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(sibSpPassengerField);

            JLabel parchPassengerLabel = new JLabel("Passenger Parch: ");
            parchPassengerLabel.setBounds(minPassengerIdLabel.getX(), sibSpPassengerField.getY() + sibSpPassengerField.getHeight() + Constants.MARGIN_FROM_TOP, parchPassengerLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(parchPassengerLabel);
            this.passengerParchField = new JTextField();
            this.passengerParchField.setBounds(minPassengerIdLabel.getX() + parchPassengerLabel.getWidth() + 1, parchPassengerLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(passengerParchField);

            JLabel minPassengerTicketFareLabel = new JLabel("Minimum Ticket Cost: ");
            minPassengerTicketFareLabel.setBounds(minPassengerIdLabel.getX(), passengerParchField.getY() + passengerParchField.getHeight() + Constants.MARGIN_FROM_TOP, minPassengerTicketFareLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(minPassengerTicketFareLabel);
            this.minPassengerTicketFareField = new JTextField();
            this.minPassengerTicketFareField.setBounds(minPassengerIdLabel.getX() + minPassengerTicketFareLabel.getWidth() + 1, minPassengerTicketFareLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(minPassengerTicketFareField);

            JLabel maxPassengerTicketFareLabel = new JLabel("Maximum Ticket Cost: ");
            maxPassengerTicketFareLabel.setBounds(minPassengerTicketFareField.getX() + minPassengerTicketFareField.getWidth() + Constants.MARGIN_FROM_LEFT, minPassengerTicketFareField.getY(), maxPassengerTicketFareLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(maxPassengerTicketFareLabel);
            this.maxPassengerTicketFareField = new JTextField();
            this.maxPassengerTicketFareField.setBounds(maxPassengerTicketFareLabel.getX() + maxPassengerTicketFareLabel.getWidth() + 1, maxPassengerTicketFareLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(maxPassengerTicketFareField);

            JLabel passengerTicketLabel = new JLabel("Passenger Ticket Number: ");
            passengerTicketLabel.setBounds(minPassengerIdLabel.getX(), maxPassengerTicketFareField.getY() + maxPassengerTicketFareField.getHeight() + Constants.MARGIN_FROM_TOP, passengerTicketLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(passengerTicketLabel);
            this.passengerTicketField = new JTextField();
            this.passengerTicketField.setBounds(passengerTicketLabel.getX() + passengerTicketLabel.getWidth() + 1, passengerTicketLabel.getY(), Constants.PASSENGER_TICKET_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(passengerTicketField);

            JLabel passengerCabinLabel = new JLabel("Passenger cabin number: ");
            passengerCabinLabel.setBounds(minPassengerIdLabel.getX(), passengerTicketField.getY() + passengerTicketField.getHeight() + Constants.MARGIN_FROM_TOP, passengerCabinLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(passengerCabinLabel);
            this.passengerCabinField = new JTextField();
            this.passengerCabinField.setBounds(passengerCabinLabel.getX() + passengerCabinLabel.getWidth() + 1, passengerCabinLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(passengerCabinField);

            JLabel passengerEmbarkedLabel = new JLabel("Passenger Embarked: ");
            passengerEmbarkedLabel.setBounds(minPassengerIdLabel.getX(), passengerCabinField.getY() + passengerCabinField.getHeight() + Constants.MARGIN_FROM_TOP, passengerEmbarkedLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
            this.add(passengerEmbarkedLabel);
            this.passengerEmbarkedComboBox = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
            this.passengerEmbarkedComboBox.setBounds(minPassengerIdLabel.getX() + passengerEmbarkedLabel.getWidth() + 1, passengerEmbarkedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(passengerEmbarkedComboBox);
            JLabel filterOutputLabel = new JLabel();
            filterOutputLabel.setBounds(Constants.BUTTON_X,Constants.BUTTON_Y+50,Constants.LABEL_WIDTH*3,Constants.LABEL_HEIGHT);
            this.add(filterOutputLabel);

            JLabel dataGroupingLabel = new JLabel("Data Grouping: ");
            dataGroupingLabel.setBounds(passengerEmbarkedLabel.getX(), passengerEmbarkedLabel.getY() + this.passengerEmbarkedComboBox.getHeight()+Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(dataGroupingLabel);
            this.dataGroupingComboBox = new JComboBox<>(Constants.DATA_GROUPING_CATEGORIES);
            this.dataGroupingComboBox.setBounds(dataGroupingLabel.getX() + dataGroupingLabel.getWidth() + 1, dataGroupingLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.dataGroupingComboBox);
            dataGroupingComboBox.addActionListener(e -> {
                String selectCategory = (String) dataGroupingComboBox.getSelectedItem();
                dataGroupingPressed(selectCategory);
            });
            JButton filter = new JButton("FILTER");
            filter.setBounds(Constants.BUTTON_X, Constants.BUTTON_Y, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
            this.add(filter);
            filter.addActionListener(e -> {
                boolean [] needFilter=new boolean [Constants.MAX_FILTERS];
                String [] filterBy=new String [Constants.MAX_FILTERS];
                filterButtonPressed(needFilter,filterBy);
                String filterOutput = getFilterResult(allPassengers, needFilter, filterBy);
                printFilterResult(filterOutput,filterOutputLabel);
            });
            JButton stats = new JButton("CREATE STATS");
            stats.setBounds(filter.getX(),filter.getY()-Constants.BUTTON_HEIGHT,Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
            this.add(stats);
            stats.addActionListener(e -> {
                Stats stats1 = new Stats();
                stats1.writeSurvivalRatesToFile(allPassengers,createFile(Constants.TXT_FINISHER));
            });
        }
    }

    private void dataGroupingPressed (String selectCategory){
        Stats stats1 = new Stats();
        Map<String , Float> dataGrouping = stats1.dataGrouping(allPassengers);
        System.out.println();
        switch (selectCategory){
            case Constants.SURVIVED_WORD -> {
                System.out.println("Not Survived: " + dataGrouping.get("Not Survived"));
                System.out.println("Survived: " + dataGrouping.get("Survived"));
            }
            case Constants.PCLASS_WORD -> {
                System.out.println(Constants.GROUP_LABELS[2]+": " + dataGrouping.get(Constants.GROUP_LABELS[2]));
                System.out.println(Constants.GROUP_LABELS[0]+": " + dataGrouping.get(Constants.GROUP_LABELS[0]));
                System.out.println(Constants.GROUP_LABELS[1]+": " + dataGrouping.get(Constants.GROUP_LABELS[1]));
            }
            case Constants.SEX_WORD -> {
                System.out.println(Constants.GROUP_LABELS[3]+": " + dataGrouping.get(Constants.GROUP_LABELS[3]));
                System.out.println(Constants.GROUP_LABELS[4]+": " + dataGrouping.get(Constants.GROUP_LABELS[4]));
            }
            case Constants.AGE_WORD -> {
                System.out.println(Constants.GROUP_LABELS[7]+": " + dataGrouping.get(Constants.GROUP_LABELS[7]));
                System.out.println(Constants.GROUP_LABELS[8]+": " + dataGrouping.get(Constants.GROUP_LABELS[8]));
                System.out.println(Constants.GROUP_LABELS[6]+": " + dataGrouping.get(Constants.GROUP_LABELS[6]));
                System.out.println(Constants.GROUP_LABELS[9]+": " + dataGrouping.get(Constants.GROUP_LABELS[9]));
                System.out.println(Constants.GROUP_LABELS[5]+": " + dataGrouping.get(Constants.GROUP_LABELS[5]));
                System.out.println(Constants.GROUP_LABELS[10]+": " + dataGrouping.get(Constants.GROUP_LABELS[10]));
            }
            case Constants.HAS_RELATIVES -> {
                System.out.println(Constants.GROUP_LABELS[12]+": " + dataGrouping.get(Constants.GROUP_LABELS[12]));
                System.out.println(Constants.GROUP_LABELS[11]+": " + dataGrouping.get(Constants.GROUP_LABELS[11]));
            }
            case Constants.FARE_WORD -> {
                System.out.println(Constants.GROUP_LABELS[13]+": " + dataGrouping.get(Constants.GROUP_LABELS[13]));
                System.out.println(Constants.GROUP_LABELS[14]+": " + dataGrouping.get(Constants.GROUP_LABELS[14]));
                System.out.println(Constants.GROUP_LABELS[15]+": " + dataGrouping.get(Constants.GROUP_LABELS[15]));
            }
            case Constants.EMBARKED_WORD -> {
                System.out.println(Constants.GROUP_LABELS[18]+": " + dataGrouping.get(Constants.GROUP_LABELS[18]));
                System.out.println(Constants.GROUP_LABELS[16]+": " + dataGrouping.get(Constants.GROUP_LABELS[16]));
                System.out.println(Constants.GROUP_LABELS[17]+": " + dataGrouping.get(Constants.GROUP_LABELS[17]));
            }
            case Constants.CHOOSE -> {}
            case null -> {}
            default -> throw new IllegalStateException("Unexpected value: " + selectCategory);
        }
    }

    private void printFilterResult(String filterOutput,JLabel filterOutputLabel) {
        if (!Objects.equals(filterOutput, "")) {
            filterOutputLabel.setText(filterOutput);
            this.add(filterOutputLabel);
        }
    }

    private void filterButtonPressed (boolean [] needFilter,String [] filterBy){
        needFilter[Constants.PCLASS_FILTER]= checkIfPClassFill( (String) Objects.requireNonNull(survivedComboBox.getSelectedItem()));
        filterBy[Constants.PCLASS_FILTER] =  (String)  survivedComboBox.getSelectedItem();
        needFilter[Constants.MIN_ID_FILTER] = checkIfMinIdFill(minPassengerIdField.getText().trim());
        filterBy[Constants.MIN_ID_FILTER] = minPassengerIdField.getText().trim();
        needFilter[Constants.MAX_ID_FILTER] = checkIfMaxIdFill(maxPassengerIdField.getText().trim());
        filterBy[Constants.MAX_ID_FILTER] = maxPassengerIdField.getText().trim();
        needFilter[Constants.NAME_FILTER]=checkIfNameFill(passengerNameField.getText().trim());
        filterBy[Constants.NAME_FILTER] = passengerNameField.getText().trim();
        needFilter[Constants.SEX_FILTER]=checkIfSexFill((String) Objects.requireNonNull(sexOfPassengerComboBox.getSelectedItem()));
        filterBy[Constants.SEX_FILTER] = (String) sexOfPassengerComboBox.getSelectedItem();
        needFilter[Constants.SIBSP_FILTER] = checkIfNumberInTxtBox(sibSpPassengerField.getText().trim());
        filterBy[Constants.SIBSP_FILTER] = sibSpPassengerField.getText().trim();
        needFilter[Constants.PARCH_FILTER] = checkIfNumberInTxtBox(passengerParchField.getText().trim());
        filterBy[Constants.PARCH_FILTER] = passengerParchField.getText().trim();
        needFilter[Constants.MAX_TICKET_COST_FILTER]=checkMaxFareFill(maxPassengerTicketFareField.getText().trim());
        filterBy[Constants.MAX_TICKET_COST_FILTER] = maxPassengerTicketFareField.getText().trim();
        needFilter[Constants.MIN_TICKET_COST_FILTER]=checkMinFareFill(minPassengerTicketFareField.getText().trim());
        filterBy[Constants.MIN_TICKET_COST_FILTER] = minPassengerTicketFareField.getText().trim();
        needFilter[Constants.TICKET_NUM_FILTER] = checkInTicketNumFill(passengerTicketField.getText().trim());
        filterBy[Constants.TICKET_NUM_FILTER] = passengerTicketField.getText().trim();
        needFilter[Constants.CABIN_FILTER] = checkIfCabinFill(passengerCabinField.getText().trim());
        filterBy[Constants.CABIN_FILTER] = passengerCabinField.getText().trim();
        needFilter[Constants.EMBARKED_FILTER]= checkIfEmbarkedFill((String) Objects.requireNonNull(passengerEmbarkedComboBox.getSelectedItem()));
        filterBy[Constants.EMBARKED_FILTER] = (String)  passengerEmbarkedComboBox.getSelectedItem();
    }

    private String getFilterResult(ArrayList<Passenger>allPassengers, boolean[]needFilter, String[]filterBy){
        ArrayList<Passenger> result = new ArrayList<>(allPassengers);
        Passenger current;
        for (int i = 0 ; i < allPassengers.size();i++){
            int filterCounter = 0;
            boolean keepFilteringPassenger = true;
            current = result.get(i);
            if (current !=null) {
                while (keepFilteringPassenger && filterCounter < needFilter.length) {
                    switch (filterCounter) {
                        case Constants.PCLASS_FILTER -> {
                            if (needFilter[Constants.PCLASS_FILTER]) {
                                keepFilteringPassenger = current.matchesPClass(filterBy[Constants.PCLASS_FILTER]);
                            }
                            filterCounter++;
                        }
                        case Constants.MIN_ID_FILTER -> {
                            if (needFilter[Constants.MIN_ID_FILTER] && needFilter[Constants.MAX_ID_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerId(filterBy[Constants.MIN_ID_FILTER], filterBy[Constants.MAX_ID_FILTER]);
                            } else if (needFilter[Constants.MIN_ID_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerId(filterBy[Constants.MIN_ID_FILTER], !Constants.MAX_ID_VALUE);
                            }
                            filterCounter++;
                        }
                        case Constants.MAX_ID_FILTER -> {
                            if (needFilter[Constants.MIN_ID_FILTER] && needFilter[Constants.MAX_ID_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerId(filterBy[Constants.MIN_ID_FILTER], filterBy[Constants.MAX_ID_FILTER]);
                            } else if (needFilter[Constants.MAX_ID_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerId(filterBy[Constants.MAX_ID_FILTER], Constants.MAX_ID_VALUE);
                            }
                            filterCounter++;
                        }
                        case Constants.NAME_FILTER -> {
                            if (needFilter[Constants.NAME_FILTER]) {
                                keepFilteringPassenger = current.matchesName(filterBy[Constants.NAME_FILTER]);
                            }
                            filterCounter++;
                        }
                        case Constants.SEX_FILTER -> {
                            if (needFilter[Constants.SEX_FILTER]) {
                                keepFilteringPassenger = current.matchesSex(filterBy[Constants.SEX_FILTER]);
                            }
                            filterCounter++;
                        }
                        case Constants.SIBSP_FILTER -> {
                            if (needFilter[Constants.SIBSP_FILTER]) {
                                keepFilteringPassenger = current.matchesSibSp(filterBy[Constants.SIBSP_FILTER]);
                            }
                            filterCounter++;
                        }
                        case Constants.PARCH_FILTER -> {
                            if (needFilter[Constants.PARCH_FILTER]) {
                                keepFilteringPassenger = current.matchesParch(filterBy[Constants.PARCH_FILTER]);
                            }
                            filterCounter++;
                        }
                        case Constants.MIN_TICKET_COST_FILTER -> {
                            if (needFilter[Constants.MIN_TICKET_COST_FILTER] && needFilter[Constants.MAX_TICKET_COST_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerFare(filterBy[Constants.MIN_TICKET_COST_FILTER], filterBy[Constants.MAX_TICKET_COST_FILTER]);
                            } else if (needFilter[Constants.MIN_TICKET_COST_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerFare(filterBy[Constants.MIN_TICKET_COST_FILTER], !Constants.MAX_TICKET_COST_VALUE);
                            }
                            filterCounter++;
                        }
                        case Constants.MAX_TICKET_COST_FILTER -> {
                            if (needFilter[Constants.MIN_TICKET_COST_FILTER] && needFilter[Constants.MAX_TICKET_COST_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerFare(filterBy[Constants.MIN_TICKET_COST_FILTER], filterBy[Constants.MAX_TICKET_COST_FILTER]);
                            } else if (needFilter[Constants.MAX_TICKET_COST_FILTER]) {
                                keepFilteringPassenger = current.matchesPassengerFare(filterBy[Constants.MAX_TICKET_COST_FILTER], Constants.MAX_TICKET_COST_VALUE);
                            }
                            filterCounter++;
                        }
                        case Constants.TICKET_NUM_FILTER -> {
                            if (needFilter[Constants.TICKET_NUM_FILTER]) {
                                keepFilteringPassenger = current.matchesTicket(filterBy[Constants.TICKET_NUM_FILTER]);
                            }
                            filterCounter++;
                        }
                        case Constants.CABIN_FILTER -> {
                            if (needFilter[Constants.CABIN_FILTER]) {
                                keepFilteringPassenger = current.matchesCabin(filterBy[Constants.CABIN_FILTER]);
                            }
                            filterCounter++;
                        }
                        case Constants.EMBARKED_FILTER -> {
                            if (needFilter[Constants.EMBARKED_FILTER]) {
                                keepFilteringPassenger = current.matchesEmbarked(filterBy[Constants.EMBARKED_FILTER]);
                            }
                            filterCounter++;
                        }
                    }
                }
                if (!keepFilteringPassenger) {
                    result.remove(i);
                    result.add(i,null);
                }
            }
        }
        ArrayList<Passenger>temp = new ArrayList<>();
        for (Passenger passenger : result) {
            if (passenger != null) {
                temp.add(passenger);
            }
        }
        result=temp;
        String filterOutput = getFilterOutPut(result);
        createCsvFile(result);
        return filterOutput;
    }

    private String getFilterOutPut(ArrayList<Passenger> result) {
        String output = Constants.FILTER_OUTPUT_BASE;
        int survivedCounter=0;
        for (Passenger passenger : result) {
            if (passenger.isSurvived()) {
                survivedCounter++;
            }
        }
        output+=result.size() + "("+survivedCounter+" survived, "+ (result.size()-survivedCounter) + " did not)";
        return output;
    }

    private void createCsvFile(ArrayList<Passenger> result) {
        StringBuilder content = new StringBuilder(Constants.CSV_FILE_COLUMN_HEADLINES);
        for (Passenger passenger : result) {
            content.append("\n").append(passenger.toString());
        }
        File newFile = createFile(Constants.CSV_FINISHER);
        writeToFile(newFile, content.toString());
    }

    private File createFile(String type) {
        String fileName="";
        if (type.equals(Constants.CSV_FINISHER)) {
            fileName = getCsvFileNumber();
        }else if (type.equals(Constants.TXT_FINISHER)){
            fileName=Constants.STATS_NAME;
        }
        File file = new File(Constants.FILTER_PATH_NEW_FILE + " " + fileName + type);
        boolean success = false;
        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error creating the file: " + e.getMessage());
            }
        }
        if (success && type.equals(Constants.CSV_FINISHER)){
            System.out.println("file number:" + fileName + " success");
            int updatedFileNumber = Integer.parseInt(fileName);
            updatedFileNumber++;
            File csvFile = new File(Constants.PATH_TO_CSV_FILE_NUMBER);
            writeToFile(csvFile,updatedFileNumber+"");
        }
        return file;
    }

    private void writeToFile(File file , String content) {
        try {
            if (file != null && file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(content);
                fileWriter.close();
            }
        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private boolean checkIfPClassFill (String pClass){
        return !pClass.equals(Constants.PASSENGER_CLASS_OPTIONS[Constants.ALL_OPTION]);
    }
    private boolean checkIfEmbarkedFill (String embarked){
        return !embarked.equals(Constants.PASSENGER_EMBARKED_OPTIONS[Constants.ALL_OPTION]);
    }
    private boolean checkIfCabinFill(String cabin){
        return !cabin.isEmpty();
    }
    private boolean checkInTicketNumFill (String ticketNum){
        return !ticketNum.isEmpty();
    }
    private boolean checkIfSexFill (String sex){
        return !sex.equals(Constants.PASSENGER_SEX_OPTIONS[Constants.ALL_OPTION]);
    }
    private boolean checkIfNameFill (String name){
        return !name.isEmpty();
    }
    private boolean checkIfMinIdFill (String min){
        boolean result=false;
        boolean minIdNotNull = checkIfNumberInTxtBox(min);
        if (minIdNotNull){
            result = Integer.parseInt(min)>=0;
        }
        return result;
    }
    private boolean checkIfMaxIdFill (String max){
        boolean result=false;
        boolean minIdNotNull = checkIfNumberInTxtBox(max);
        if (minIdNotNull){
            result = Integer.parseInt(max)>=0;
        }
        return result;
    }

    private boolean checkMinFareFill (String min){
        boolean result=false;
        boolean minFareNotNull = checkIfNumberInTxtBox(min);
        if (minFareNotNull){
            result = Double.parseDouble(min)>=0;
        }
        return result;
    }
    private boolean checkMaxFareFill (String max){
        boolean result=false;
        boolean maxFareNotNull = checkIfNumberInTxtBox(max);
        if (maxFareNotNull){
            result = Integer.parseInt(max)>=0;
        }
        return result;
    }
    private boolean checkIfNumberInTxtBox (String num){
        boolean result;
        try {
            double number = Double.parseDouble(num);
            result = number>=0;
        }catch (NumberFormatException e){
            result = false;
        }
        return result;
    }
    public static ArrayList<Passenger> readerFromCsv (){
        String line;
        ArrayList<Passenger>titanicPassengers = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(Constants.PATH_TO_DATA_FILE));
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                titanicPassengers.add(new Passenger(line));
            }
        }
        catch (IOException e)
        {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return titanicPassengers;
    }
    private static String getCsvFileNumber (){
        String number = "";
        File file = new File(Constants.PATH_TO_CSV_FILE_NUMBER);
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            number = br.readLine();
        }
        catch (IOException e)
        {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return number;
    }
}