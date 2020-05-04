import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * @author Aditya Oberai
 */
public class ScatterPlot extends JFrame {
    private JFreeChart mScatterPlot;
    private Set<String> mStatesToPlot;
    private int mSeriesCount;

    //Constants for scatter plot aesthetics
    private final String FONT = "SanSerif";
    private final int FONT_SIZE = 14;
    private final Color FADED_LIGHT_BLUE = new Color(250, 250, 255);


    /**
     * Creates a new window which is to display a scatter plot of the cases in each state.
     * @param statesToPlot String representing the name of the states whose cases should be plotted on the graph.
     */
    public ScatterPlot(String... statesToPlot) {
        setSize(ChartPanel.DEFAULT_WIDTH, ChartPanel.DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mStatesToPlot = Set.of(statesToPlot);
        setVisible(true);
    }

    /**
     * Calls a set of methods which generate and display a scatter plot which shows the cases by state over time.
     * @param g Required Graphics object (not used in method body)
     */
    @Override
    public void paint(Graphics g) {
        generateDataset();
        beautify();
        displayScatterPlot();
    }

    /**
     * Generates the dataset and scatter plot which is to be displayed on the window.
     */
    private void generateDataset() {
        XYSeriesCollection stateCaseData = new XYSeriesCollection();
        for (String state : mStatesToPlot) {
            XYSeries stateCases = new XYSeries(state);
            for (Figure figure : PandemicData.findData(PandemicData.sPandemicData, PandemicData.TypeFilter.STATE, state)) {
                stateCases.add(figure.getDay(), figure.getCases());
            }
            stateCaseData.addSeries(stateCases);
            mSeriesCount = stateCaseData.getSeriesCount();
        }

        mScatterPlot = ChartFactory.createScatterPlot("Cases by State over Time",
                "Days since January 1, 2020", "Case Count", stateCaseData);
    }

    /**
     * Sets aesthetics of scatter plot.
     */
    private void beautify() {
        mScatterPlot.getTitle().setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        mScatterPlot.getXYPlot().getDomainAxis().setLabelFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        mScatterPlot.getXYPlot().getRangeAxis().setLabelFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        XYPlot plot = (XYPlot) mScatterPlot.getPlot();
        plot.setBackgroundPaint(FADED_LIGHT_BLUE);
        Shape cross = ShapeUtilities.createDiagonalCross(2, 2);
        plot = (XYPlot) mScatterPlot.getPlot();
        XYItemRenderer renderer = plot.getRenderer();
        for (int i = 0; i < mSeriesCount; i++) renderer.setSeriesShape(i, cross);

    }

    /**
     * Displays scatter plot on JFrame.
     */
    private void displayScatterPlot() {
        ChartPanel panel = new ChartPanel(mScatterPlot);
        getContentPane().add(panel);
        pack();
    }

}