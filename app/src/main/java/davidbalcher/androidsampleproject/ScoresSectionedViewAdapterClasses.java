package davidbalcher.androidsampleproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;


class ScoreSection extends StatelessSection {

    private Context mContext;
    private ArrayList<Score> itemList;
    String title;

    public ScoreSection(String title, ArrayList<Score> data, Context context) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.cell_score)
                .headerResourceId(R.layout.section_header)
                .build());

        this.mContext = context;

        this.title = title;
        this.itemList = data;
    }

    @Override
    public int getContentItemsTotal() {
        return itemList.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ScoreItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ScoreItemViewHolder itemHolder = (ScoreItemViewHolder) holder;

        itemHolder.countTextView.setText(String.valueOf(position+1));
        String name = itemList.get(position).getName();
        itemHolder.nameTextView.setText(name);
        final String score = itemList.get(position).getValue();
        itemHolder.scoreTextView.setText(score);
        String date = itemList.get(position).getDateString();
        itemHolder.dateTextView.setText(date);

        if (position % 2 == 0) {
            itemHolder.rowLayout.setBackgroundColor(Color.parseColor("#d6dfe2"));
        }

        itemHolder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoresIntent = new Intent(mContext, ScoresActivity.class);

                scoresIntent.putExtra("NAME", itemList.get(position).name);
                scoresIntent.putExtra("VALUE", itemList.get(position).value);
                scoresIntent.putExtra("DATE", itemList.get(position).getDateString());

                mContext.startActivity(scoresIntent);

            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

        headerHolder.sectionTitle.setText(title);
    }
}


class HeaderViewHolder extends RecyclerView.ViewHolder {

    final TextView sectionTitle;

    HeaderViewHolder(View view) {
        super(view);

        sectionTitle = (TextView) view.findViewById(R.id.section_header_text);
    }
}


class ScoreItemViewHolder extends RecyclerView.ViewHolder {
    final LinearLayout rowLayout;
    final TextView countTextView;
    final TextView nameTextView;
    final TextView scoreTextView;
    final TextView dateTextView;

    public ScoreItemViewHolder(View itemView) {
        super(itemView);

        rowLayout = itemView.findViewById(R.id.row_layout);
        countTextView = itemView.findViewById(R.id.row_count_text);
        nameTextView = itemView.findViewById(R.id.row_name_text);
        scoreTextView = itemView.findViewById(R.id.row_score_text);
        dateTextView = itemView.findViewById(R.id.row_date_text);
    }
}

