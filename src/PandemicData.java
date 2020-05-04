import java.util.ArrayList;

/**
 * Stores data parsed from File and provides methods to interface and filter with the data.
 *
 * @author Aditya Oberai
 */
public class PandemicData {
    public static ArrayList<Figure> sPandemicData = new ArrayList<Figure>(); //stores all Figures.

    public enum TypeFilter {
        STATE, DAY_FROM_START, FIPS, CASES, DEATHS;
    }

    /**
     * Prints all the figures in the ArrayList provided.
     * @param pandemicData ArrayList storing Figure 's to be printed.
     */
    public static void printPandemicData(ArrayList<Figure> pandemicData) {
        if (!pandemicData.isEmpty()) {
            for (Figure figure : pandemicData) {
                System.out.println(figure.toString());
            }
            System.out.println("\n----------------------------------------------------------------\n");
        }
    }

    /**
     * Returns a subArrayList of the original data with given filters.
     * @param typeSearch TypeFilter enum representing category to search for. Options are [DAYFROMSTART, STATE, FIPS, CASES, DEATHS]
     * - dayFromStart
     *      Filters for information from specific day count starting at January 1, 2020
     *      @param dataSearch Integer representing day to search for.
     * - state
     *      Filters for information from specific state.
     *      @param dataSearch String representing state to search for.
     * - fips
     *     Filters for information with same fips.
     *      @param dataSearch Int representing fips to search for.
     * - cases
     *      Filters for information with more than or equal to cases.
     *      @param dataSearch Int representing minimum case count filter.
     * - death
     *      Filters for information with more than or equal to deaths.
     *      @param dataSearch Int representing minimum death count filter.

     * @return ArrayList storing Figures that fit provided filters.
     */
    public static ArrayList<Figure> findData(ArrayList<Figure> pandemicData, TypeFilter typeSearch, Object dataSearch) {
        ArrayList<Figure> searchResults = new ArrayList<>();
        switch (typeSearch) {
            case DAY_FROM_START:
                if (dataSearch instanceof Integer) {
                    for (Figure figure : pandemicData) {
                        if (Integer.valueOf(figure.getDay()).equals(dataSearch)) {
                            searchResults.add(figure);
                        }
                    }
                }
                else {
                    throw new IllegalArgumentException("dataSearch must be an Integer if typeSearch is DAY_FROM_START");
                }
                break;
            case STATE:
                if (dataSearch instanceof String) {
                    for (Figure figure : pandemicData) {
                        if (figure.getState().equalsIgnoreCase(((String) dataSearch))) {
                            searchResults.add(figure);
                        }
                    }
                }
                else {
                    throw new IllegalArgumentException("dataSearch must be an String if typeSearch is STATE");
                }
                break;
            case FIPS:
                if (dataSearch instanceof Integer) {
                    for (Figure figure : pandemicData) {
                        if (Integer.valueOf(figure.getFips()).equals(dataSearch)) {
                            searchResults.add(figure);
                        }
                    }
                }
                else {
                    throw new IllegalArgumentException("dataSearch must be an Integer if typeSearch is FIPS");
                }
                break;
            case CASES:
                if (dataSearch instanceof Integer) {
                    for (Figure figure : pandemicData) {
                        if (Integer.valueOf(figure.getCases()).compareTo((Integer)dataSearch) >= 0) {
                            searchResults.add(figure);
                        }
                    }
                }
                else {
                    throw new IllegalArgumentException("dataSearch must be an Integer if typeSearch is CASES");
                }
                break;
            case DEATHS:
                if (dataSearch instanceof Integer) {
                    for (Figure figure : pandemicData) {
                        if (Integer.valueOf(figure.getDeaths()).compareTo((Integer)dataSearch) >= 0) {
                            searchResults.add(figure);
                        }
                    }
                }
                else {
                    throw new IllegalArgumentException("dataSearch must be an Integer if typeSearch is DEATHS");
                }
                break;
            default:
                throw new IllegalArgumentException("typeSearch \"" + typeSearch + "\" does not exist: Options are [DAY_FROM_START, STATE, FIPS, CASES, DEATHS]");
        }
        return searchResults;
    }
}
