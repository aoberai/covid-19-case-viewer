import java.util.Scanner;

/**
 * Finds number of days since start of 2020.
 * @author Aditya Oberai
 */
public class PandemicDurationFinder {
    private static int[] sDaysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int sLeapYearCount = 29;
    private static int sPandemicStartingYear = 2020;
    private static int sDaysInYear = 365;
    private static int sDaysInLeapYear = 366;

    /**
     * Gives numbers of days that have passed from start of pandemic (Start of 2020) to case status date
     * @param cases String that represents pandemic status in following format "year-month-day,state,#mystery,casecount,deathcount"
     * @return Int that stores number of days passed from start of pandemic (Start of 2020) to case status date
     */
    public static int daysPassedFrom2020(String cases) {
        int[] daysInMonthsCountingLeapYears = sDaysInMonths.clone();
        int dayCount = getDay(cases);

        //Accounts for duration day count between multiple years
        for (int i = sPandemicStartingYear; i < getYear(cases); i++) {
            if (isLeapYear(i)) {
                dayCount += sDaysInLeapYear;
            }
            else {
                dayCount += sDaysInYear;
            }
        }

        //Fixes days in months array to accurately depict number of days in February based on whether or not it is a leap year.
        if (isLeapYear(getYear(cases))) {
            daysInMonthsCountingLeapYears[1] = sLeapYearCount;
        }

        //Accounts for days passed from previous months based upon the number of days in said previous months.
        for (int i = 0; i < getMonth(cases) - 1; i++) {
            dayCount += daysInMonthsCountingLeapYears[i];
        }

        return dayCount;
    }

    /**
     * Gives numbers of days that have passed from start of pandemic (Start of 2020) to case status date
     * @param year Int representing year of figure
     * @param month Int representing month of figure
     * @param day Int representing day of figure
     * @return Int that stores number of days passed from start of pandemic (Start of 2020) to case status date
     */
    public static int daysPassedFrom2020(int year, int month, int day) {
        int[] daysInMonthsCountingLeapYears = sDaysInMonths.clone();
        int dayCount = day;

        //Accounts for duration day count between multiple years
        for (int i = sPandemicStartingYear; i < year; i++) {
            if (isLeapYear(i)) {
                dayCount += sDaysInLeapYear;
            }
            else {
                dayCount += sDaysInYear;
            }
        }

        //Fixes days in months array to accurately depict number of days in February based on whether or not it is a leap year.
        if (isLeapYear(year)) {
            daysInMonthsCountingLeapYears[1] = sLeapYearCount;
        }

        //Accounts for days passed from previous months based upon the number of days in said previous months.
        for (int i = 0; i < month - 1; i++) {
            dayCount += daysInMonthsCountingLeapYears[i];
        }

        return dayCount;
    }

    /**
     * Gets day from case status string.
     * @param cases String that represents pandemic status in following format "year-month-day,state,#mystery,casecount,deathcount"
     * @return Int representing day from case status string.
     */
    public static int getDay(String cases) {
        Scanner stringParser = new Scanner(cases);
        stringParser.useDelimiter("[-,]");
        stringParser.nextInt();
        stringParser.nextInt();
        return stringParser.nextInt();
    }

    /**
     * Gets month from case status string.
     * @param cases String that represents pandemic status in following format "year-month-day,state,#mystery,casecount,deathcount"
     * @return Int representing month from case status string.
     */
    public static int getMonth(String cases) {
        Scanner stringParser = new Scanner(cases);
        stringParser.useDelimiter("[-,]");
        stringParser.nextInt();
        return stringParser.nextInt();
    }

    /**
     * Gets year from case status string.
     * @param cases String that represents pandemic status in following format "year-month-day,state,#mystery,casecount,deathcount"
     * @return Int representing year from case status string.
     */
    public static int getYear(String cases) {
        Scanner stringParser = new Scanner(cases);
        stringParser.useDelimiter("[-,]");
        return stringParser.nextInt();
    }

    /**
     * Given a year, states if it is a leap year.
     * @param year Year to check
     * @return true if it is leap year, false if not leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
