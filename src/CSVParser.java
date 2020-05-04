import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVParser {
    /**
     * Parses file, extracts Figure, and stores it in pandemicData var inside Data class.
     * @param file File to parse.
     */
    public static void parseFromFile(File file) {
        Scanner parser = null;
        try {
            parser = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert parser != null;
        parser.useDelimiter("[-,|\\n]");
        while(parser.hasNextLine()) {
                PandemicData.sPandemicData.add(new Figure(PandemicDurationFinder.daysPassedFrom2020(Integer.parseInt(parser.next()), Integer.parseInt(parser.next()), Integer.parseInt(parser.next())), parser.next(), Integer.parseInt(parser.next()), Integer.parseInt(parser.next()), Integer.parseInt(parser.next())));
        }
    }

}
