import java.io.File;

/**
 * Tests pandemic data parsing and filtering.
 * @author Aditya Oberai
 */
public class Tester {
    /**
     * Runs test cases for a variety of methods.
     * @param args Provides input when run through terminal (not used).
     */
    public static void main(String[] args) {
        File pandemicData = new File("resources/PandemicData.txt");
        CSVParser.parseFromFile(pandemicData); //parses all the data from file

        PandemicData.printPandemicData(PandemicData.sPandemicData); //prints out all the data parsed from file

        PandemicData.printPandemicData(PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.STATE, "washington")); //prints out all the figures regarding washington

        PandemicData.printPandemicData(PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.DAY_FROM_START, 60)); //prints out all the figures on day 60

        PandemicData.printPandemicData(PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.CASES, 50000)); //prints out all the figures where cases are more than 50000

        PandemicData.printPandemicData(PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.DEATHS, 800)); //prints out all the figures where deaths are more than 800

        PandemicData.printPandemicData(PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.FIPS, 17)); //prints out all the figures where fips is 17

        PandemicData.printPandemicData(PandemicData.findData(PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.STATE, "new york"), PandemicData.TypeFilter.CASES, 45000)); //runs a chained command where it prints out all the figures where cases are more than 45000 and the state is New York

        PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.STATE, "california").forEach(figure -> System.out.print(figure.getDeaths() + " ")); //prints out all the deaths by day separated by spaces in California

//        new ScatterPlot("California",  "Utah", "Washington", "New Jersey");
        new ScatterPlot("California", "New York", "Utah", "Washington", "New Jersey", "Illinois", "Arizona", "Colorado"); //Plots the cases for each of the states listed in visual scatter plot
    }
}
