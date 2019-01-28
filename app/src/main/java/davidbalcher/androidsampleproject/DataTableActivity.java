package davidbalcher.androidsampleproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class DataTableActivity extends AppCompatActivity {

    final private String url = "https://gist.githubusercontent.com/ryanneuroflow/370d19311602c091928300edd7a40f66/raw/{token}/names.json";
    private ProgressDialog nDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_table);

        AndroidNetworking.initialize(getApplicationContext());

        initSpinner();


        final ScoreTableModel model = new ScoreTableModel();

        AndroidNetworking.get(url)
                .addPathParameter("token", "1865ae6004142553d8a6c6ba79ccb511028a2cba")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        nDialog.dismiss();

                        model.setWithJson(response);
                        model.sortByDatePerGender();

                        SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();
                        sectionAdapter.addSection(new ScoreSection("Male", model.getStaticDataForGender("m"), DataTableActivity.this));
                        sectionAdapter.addSection(new ScoreSection("Female", model.getStaticDataForGender("f"), DataTableActivity.this));

                        RecyclerView recyclerView = findViewById(R.id.score_data_table);
                        recyclerView.setLayoutManager(new LinearLayoutManager(DataTableActivity.this));

                        recyclerView.setAdapter(sectionAdapter);

                    }
                    @Override
                    public void onError(ANError error) {

                        nDialog.dismiss();

                    }
                });

        }

    public void initSpinner() {

        nDialog = new ProgressDialog(DataTableActivity.this);
        nDialog.setMessage("Loading..");
        nDialog.setTitle("Get Data");
        nDialog.setIndeterminate(false);
        nDialog.setCancelable(true);
        nDialog.show();
    }

}
