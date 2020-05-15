package com.example.nbaseasonstats.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nbaseasonstats.NBAStatsApplication;
import com.example.nbaseasonstats.R;
import com.example.nbaseasonstats.model.PlayerResponse;
import com.example.nbaseasonstats.presenter.PlayerDetailsPresenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import javax.inject.Inject;

public class PlayerDetailsActivity extends AppCompatActivity implements PlayerDetailsScreen {

    int playerId = 237;
    String playerName;
    @Inject
    PlayerDetailsPresenter playerDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_details);

        NBAStatsApplication.injector.inject(this);

        playerId = (int) getIntent().getLongExtra("ID", 237);
        playerName = getIntent().getStringExtra("NAME");
        this.setTitle(playerName + " season stats");
    }

    @Override
    protected void onStart() {
        super.onStart();
        playerDetailsPresenter.attachScreen(this);
        playerDetailsPresenter.getPlayerStatistics(playerId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        playerDetailsPresenter.detachScreen();
    }

    @Override
    public void showStats(PlayerResponse playerStats) {
        if (!playerStats.getData().isEmpty()) {
            TextView pts = findViewById(R.id.player_pts);
            pts.setText(playerStats.getData().get(0).getPts().toString());
            TextView played = findViewById(R.id.player_gp);
            played.setText(playerStats.getData().get(0).getGamesPlayed().toString());
            TextView reb = findViewById(R.id.player_reb);
            reb.setText(playerStats.getData().get(0).getReb().toString());
            TextView assist = findViewById(R.id.player_assists);
            assist.setText(playerStats.getData().get(0).getAst().toString());
            TextView steal = findViewById(R.id.player_stl);
            steal.setText(playerStats.getData().get(0).getStl().toString());
            TextView blk = findViewById(R.id.player_blk);
            blk.setText(playerStats.getData().get(0).getBlk().toString());
            TextView oreb = findViewById(R.id.player_oreb);
            oreb.setText(playerStats.getData().get(0).getOreb().toString());
            TextView dreb = findViewById(R.id.player_dreb);
            dreb.setText(playerStats.getData().get(0).getDreb().toString());
            TextView fg = findViewById(R.id.player_fg);
            fg.setText(playerStats.getData().get(0).getFgm().toString());
            TextView threefg = findViewById(R.id.player_3fg);
            threefg.setText(playerStats.getData().get(0).getFg3m().toString());
            TextView fgpct = findViewById(R.id.player_fgpct);
            fgpct.setText(playerStats.getData().get(0).getFgPct().toString());
            TextView threepct = findViewById(R.id.player_3fgptc);
            threepct.setText(playerStats.getData().get(0).getFg3Pct().toString());
        }
        BarChart barChart = findViewById(R.id.chartPlayer);
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, Float.valueOf(String.valueOf(playerStats.getData().get(0).getPts()))));
        entries.add(new BarEntry(2f, Float.valueOf(String.valueOf(playerStats.getData().get(0).getAst()))));
        entries.add(new BarEntry(3f, Float.valueOf(String.valueOf(playerStats.getData().get(0).getReb()))));
        entries.add(new BarEntry(4f, Float.valueOf(String.valueOf(playerStats.getData().get(0).getStl()))));

        BarDataSet bardataset = new BarDataSet(entries, "");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("");
        labels.add("Points");
        labels.add("Assists");
        labels.add("Rebounds");
        labels.add("Steals");

        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        barChart.getXAxis().setGranularity(1f);
        barChart.getXAxis().setGranularityEnabled(true);

        BarData data = new BarData(bardataset);
        barChart.setData(data);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(1000);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),
                Toast.LENGTH_SHORT).show();
    }
}
