package davidbalcher.androidsampleproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreTableModel {

    private ArrayList<Score> scores;

    public ScoreTableModel() {
        scores = new ArrayList<>();
    }

    public void loadStaticData() {

        scores.add(new Score("Ryan",63,1546341851000L, "m"));
        scores.add(new Score("Sam",86,1536442851000L, "m"));
        scores.add(new Score("Joey",78,1546442992000L, "m"));
        scores.add(new Score("Melissa",91,1540341851000L, "f"));
        scores.add(new Score("Jess",93,1540341751000L, "f"));
        scores.add(new Score("Carly",89,1540341651000L, "f"));
    }

    public void sortByDatePerGender() {

        Collections.sort(scores, new Comparator<Score>() {
            public int compare(Score o1, Score o2) {
                int stringResult = o2.getGender().compareTo(o1.getGender());
                if (stringResult == 0) {
                    return o1.getDate().compareTo(o2.getDate());
                }
                else {
                    return stringResult;
                }
            }
        });

    }

    public ArrayList<Score> getStaticDataForGender(String gender) {
        ArrayList<Score> result = new ArrayList<>();
        for (Score score : scores) {
            if (score.getGender().equals(gender)) {
                result.add(score);
            }
        }
        return result;
    }

}
