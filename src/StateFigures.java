import java.util.ArrayList;

/**
 * Stores a set of Figures for a state.
 *
 * @author Aditya Oberai
 */
public class StateFigures {
    private ArrayList<Figure> mFigures;

    /**
     * Constructs an instance of StateFigures.
     */
    public StateFigures() {
        mFigures = new ArrayList<Figure>();
    }

    /**
     * Stores a Figure for a specific state into a collection.
     *
     * @param figure Figure to be stored.
     */
    public void insert(Figure figure) {
        mFigures.add(figure);
    }

    /**
     * Returns total deaths of all Figures stored in state instance.
     *
     * @return Int representing total deaths.
     */
    public int getTotalDeaths() {
        int deathCount = 0;
        for (Figure figure : mFigures) {
            deathCount += figure.getDeaths();
        }
        return deathCount;
    }
}
