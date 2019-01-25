package davidbalcher.androidsampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Score> scores;
    int scoresIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scores = new ArrayList<>();

        scores.add(new Score("Ralph","85%","<~December 9th>"));
        scores.add(new Score("Mike","92%","<~September 5th>"));
        scores.add(new Score("Don","25%","<~November 20th>"));
        scores.add(new Score("Leo","90%","<~May 21st>"));
    }

    public void goToScores(View view) {

        if (scoresIndex >= scores.size()) {
            scoresIndex = 0;
        }

        Intent scoresIntent = new Intent(MainActivity.this, ScoresActivity.class);

        scoresIntent.putExtra("NAME", scores.get(scoresIndex).name);
        scoresIntent.putExtra("VALUE", scores.get(scoresIndex).value);
        scoresIntent.putExtra("DATE", scores.get(scoresIndex).date);

        scoresIndex++;

        startActivity(scoresIntent);
    }
}
