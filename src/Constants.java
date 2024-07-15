public class Constants {
    public static final String PATH_TO_DATA_FILE = "src/data/titanic.csv";
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 700;
    public static final String[] PASSENGER_CLASS_OPTIONS = { "All", "1st", "2nd", "3rd"};
    public static final int MARGIN_FROM_TOP = 10;
    public static final int MARGIN_FROM_LEFT = 5;
    public static final int LABEL_WIDTH = 105;
    public static final int LABEL_HEIGHT = 30;
    public static final int COMBO_BOX_WIDTH = 80;
    public static final int COMBO_BOX_HEIGHT = 30;

    public static final int BUTTON_WIDTH = 125;
    public static final int BUTTON_HEIGHT = 30;
    public static final int BUTTON_X = 250;
    public static final int BUTTON_Y= 500;
    public static final int PASSENGER_ID = 0;
    public static final int SURVIVED = 1;
    public static final int P_CLASS = 2;
    public static final int FIRST_NAME = 4;
    public static final int LAST_NAME = 3;
    public static final int SEX = 5;
    public static final int AGE = 6;
    public static final int SIB_SP = 7;
    public static final int PARCH = 8;
    public static final int TICKET = 9;
    public static final int FARE = 10;
    public static final int CABIN = 11;
    public static final int EMBARKED = 12;
    public static final int NULL_AGE = -1;
    public static final char NULL_EMBARKED = 'N';
    public static final int TEXT_FIELD_WIDTH = 40;
    public static final int PASSENGER_NAME_FIELD_WIDTH = 160;
    public static final String[] PASSENGER_SEX_OPTIONS = { "All", "Female", "Male"};
    public static final String CSV_FILE_COLUMN_HEADLINES = "PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked";
    public static final String PATH_TO_CSV_FILE_NUMBER = "src/data/csvFileCounter.txt";
    public static final int PASSENGER_TICKET_FIELD_WIDTH = 100;
    public static final int LABEL_PADDING_RIGHT = 5;
    public static final String[] PASSENGER_EMBARKED_OPTIONS = { "All", "C", "Q","S"};
    public static final String CHOOSE = "Choose";
    public static final String SURVIVED_WORD = "Survived";
    public static final String NOT_SURVIVED = "Not Survived";
    public static final String PCLASS_WORD = "PClass";
    public static final String SEX_WORD = "Sex";
    public static final String AGE_WORD = "Age";
    public static final String HAS_RELATIVES = "Has Relatives";
    public static final String FARE_WORD = "Fare";
    public static final String EMBARKED_WORD = "Embarked";
    public static final String[] DATA_GROUPING_CATEGORIES = {CHOOSE, SURVIVED_WORD, PCLASS_WORD, SEX_WORD, AGE_WORD, HAS_RELATIVES, FARE_WORD, EMBARKED_WORD};
    public static final String[] GROUP_LABELS = {"First Class", "Second Class", "Third Class", "Male", "Female",
            "Ages 0-10", "Ages 11-20", "Ages 21-30", "Ages 31-40", "Ages 41-50", "Ages 51+", "Has Relatives", "Has No Relatives",
            "Fare under $10", "Fare $11-$30", "Fare $31+", "Embarked at C", "Embarked at Q", "Embarked at S"
    };
    public static final int MAX_FILTERS = 12;
    public static final int PCLASS_FILTER = 0;
    public static final int MIN_ID_FILTER = 1;
    public static final int MAX_ID_FILTER = 2;
    public static final int NAME_FILTER = 3;
    public static final int SEX_FILTER = 4;
    public static final int SIBSP_FILTER = 5;
    public static final int PARCH_FILTER = 6;
    public static final int MIN_TICKET_COST_FILTER = 7;
    public static final int MAX_TICKET_COST_FILTER = 8;
    public static final int TICKET_NUM_FILTER = 9;
    public static final int CABIN_FILTER = 10;
    public static final int EMBARKED_FILTER = 11;
    public static final int ALL_OPTION = 0;
    public static final String CSV_FINISHER = ".csv";
    public static final String TXT_FINISHER = ".txt";
    public static final boolean MAX_ID_VALUE = true;
    public static final boolean MAX_TICKET_COST_VALUE = true;
    public static final String FILTER_PATH_NEW_FILE = "src/data/";
    public static final String FILTER_OUTPUT_BASE = "Total Rows:";
    public static final String STATS_NAME = "Statistics";
}