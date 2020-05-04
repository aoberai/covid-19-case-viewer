/**
 * Represents status of virus.
 *
 * @author Aditya Oberai
 */
public class Figure {
    private int mDay, mFips, mCases, mDeaths;
    private String mState;

    /**
     * Constructor to initialize private params.
     * @param day Date of figure int
     * @param fips Unidentified meaning int
     * @param cases Number of cases int
     * @param deaths Number of deaths int
     */
    Figure(int day, String state, int fips, int cases, int deaths) {
        this.mDay = day;
        this.mFips = fips;
        this.mCases = cases;
        this.mDeaths = deaths;
        this.mState = state;
    }

    /**
     * Represents all vars in object in string format.
     * @return String with value of every variable.
     */
    @Override
    public String toString() {
        return "Figure{" +
                "day=" + mDay +
                ", state='" + mState + '\'' +
                ", fips=" + mFips +
                ", cases=" + mCases +
                ", deaths=" + mDeaths +
                '}';
    }

    /**
     * Gets cases private var.
     * @return Int representing case count of figure.
     */
    public int getCases() {
        return mCases;
    }

    /**
     * Gets day private var.
     * @return Int representing day count of figure.
     */
    public int getDay() {
        return mDay;
    }

    /**
     * Gets deaths private var.
     * @return Int representing death count in figure.
     */
    public int getDeaths() {
        return mDeaths;
    }

    /**
     * Get fips private var.
     * @return Int representing fips var in figure.
     */
    public int getFips() {
        return mFips;
    }

    /**
     * Gets state private var.
     * @return String representing state var in figure.
     */
    public String getState() {
        return mState;
    }
}
