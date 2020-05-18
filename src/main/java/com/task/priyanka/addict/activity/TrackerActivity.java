package com.task.priyanka.addict.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.task.priyanka.addict.R;
import com.task.priyanka.addict.adapter.AdapterTrackerRecycler;
import com.task.priyanka.addict.utils.SharedPrefController;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TrackerActivity extends BaseActivity {

    RecyclerView rv_tracker;
    AdapterTrackerRecycler adapterTrackerRecycler;
    Context context;
    String[] data;
    int numberOfColumns, pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        activateToolbar(false);
        context = this;

        initUi();
        recyclerSetUp();
    }

    private void initUi() {
        rv_tracker = findViewById(R.id.rv_tracker);
    }

    private void recyclerSetUp() {
        data = new String[]{"A", "D", "D", "I", "C", "T"};
        numberOfColumns = 2;

        rv_tracker.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapterTrackerRecycler = new AdapterTrackerRecycler(context, data);
        rv_tracker.setAdapter(adapterTrackerRecycler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_tracker, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_refresh) {
            adapterTrackerRecycler.notifyDataSetChanged();
            resetTargetCount();
            resetCurrentCount();
            Toast.makeText(context, R.string.target_reset, Toast.LENGTH_SHORT).show();
            return true;
        }

        if (item.getItemId() == R.id.action_setting) {
            Intent intent = new Intent(this, TargetSetupActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void resetCurrentCount() {
        /* DataProcessor dataProccessor = new DataProcessor(context);
        dataProccessor.setInt("key", 0);
        dataProccessor.setInt("key2", 0);*/
    }

    private void resetTargetCount() {
        SharedPrefController.getSharedPreferencesController(context).setString("One", "0");
        SharedPrefController.getSharedPreferencesController(context).setString("Two", "0");
        SharedPrefController.getSharedPreferencesController(context).setString("Three", "0");
        SharedPrefController.getSharedPreferencesController(context).setString("Four", "0");
        SharedPrefController.getSharedPreferencesController(context).setString("Five", "0");
        SharedPrefController.getSharedPreferencesController(context).setString("Six", "0");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recyclerSetUp();
    }
}
