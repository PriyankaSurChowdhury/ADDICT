package com.task.priyanka.addict.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.task.priyanka.addict.R;
import com.task.priyanka.addict.utils.SharedPrefController;

import androidx.core.widget.NestedScrollView;

public class TargetSetupActivity extends BaseActivity implements View.OnClickListener {

    Context context;
    TextView tv_saveBtn;

    EditText et_targetCountOne, et_targetCountTwo, et_targetCountThree,
            et_targetCountFour, et_targetCountFive, et_targetCountSix;
    String t1, t2, t3, t4, t5, t6;

    NestedScrollView nested_scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_setup);
        activateToolbar(true);

        context = this;
        initUi();
        smoothScroll();
    }

    private void smoothScroll() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nested_scroll.setNestedScrollingEnabled(false);
                nested_scroll.fullScroll(View.FOCUS_UP);
                nested_scroll.smoothScrollTo(0, 0);

            }
        }, 2000);
    }

    private void dataSet() {
        t1 = et_targetCountOne.getText().toString();
        t2 = et_targetCountTwo.getText().toString();
        t3 = et_targetCountThree.getText().toString();
        t4 = et_targetCountFour.getText().toString();
        t5 = et_targetCountFive.getText().toString();
        t6 = et_targetCountSix.getText().toString();
    }

    private void initUi() {
        et_targetCountOne = findViewById(R.id.et_targetCountOne);
        et_targetCountTwo = findViewById(R.id.et_targetCountTwo);
        et_targetCountThree = findViewById(R.id.et_targetCountThree);
        et_targetCountFour = findViewById(R.id.et_targetCountFour);
        et_targetCountFive = findViewById(R.id.et_targetCountFive);
        et_targetCountSix = findViewById(R.id.et_targetCountSix);

        tv_saveBtn = findViewById(R.id.tv_saveBtn);
        tv_saveBtn.setOnClickListener(this);

        nested_scroll = findViewById(R.id.nested_scroll);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.tv_saveBtn) {
            dataSet();

            if((!t1.equals("")) || (!t2.equals("")) ||  (!t3.equals("")) ||  (!t4.equals("")) ||
                    (!t5.equals("")) ||  (!t6.equals(""))) {
                SharedPrefController.getSharedPreferencesController(context).setString("One", t1);
                SharedPrefController.getSharedPreferencesController(context).setString("Two", t2);
                SharedPrefController.getSharedPreferencesController(context).setString("Three", t3);
                SharedPrefController.getSharedPreferencesController(context).setString("Four", t4);
                SharedPrefController.getSharedPreferencesController(context).setString("Five", t5);
                SharedPrefController.getSharedPreferencesController(context).setString("Six", t6);
            }else{
                SharedPrefController.getSharedPreferencesController(context).setString("One", "0");
                SharedPrefController.getSharedPreferencesController(context).setString("Two", "0");
                SharedPrefController.getSharedPreferencesController(context).setString("Three", "0");
                SharedPrefController.getSharedPreferencesController(context).setString("Four", "0");
                SharedPrefController.getSharedPreferencesController(context).setString("Five", "0");
                SharedPrefController.getSharedPreferencesController(context).setString("Six", "0");
            }
            Toast.makeText(context, R.string.target_is_set, Toast.LENGTH_SHORT).show();
            Intent trackerScreen = new Intent(this, TrackerActivity.class);
            startActivity(trackerScreen);

        }
    }
}
