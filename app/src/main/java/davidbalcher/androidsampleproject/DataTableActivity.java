package davidbalcher.androidsampleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class DataTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_table);

        ScoreTableModel model = new ScoreTableModel();
        model.loadStaticData();
        model.sortByDatePerGender();

        SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(new ScoreSection("Male", model.getStaticDataForGender("m"), this));
        sectionAdapter.addSection(new ScoreSection("Female", model.getStaticDataForGender("f"), this));

        RecyclerView recyclerView = findViewById(R.id.score_data_table);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(sectionAdapter);

    }

}
