package davidbalcher.androidsampleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoresActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("NAME");
        String value = extras.getString("VALUE");
        String date = extras.getString("DATE");

        TextView nameView = findViewById(R.id.name_text_view);
        TextView scoreView = findViewById(R.id.score_text_view);
        TextView dateView = findViewById(R.id.date_text_view);

        nameView.setText(name);
        scoreView.setText(value);
        dateView.setText(date);
    }
}
