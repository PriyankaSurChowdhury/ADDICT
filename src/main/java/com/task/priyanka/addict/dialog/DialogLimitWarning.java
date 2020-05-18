package com.task.priyanka.addict.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.task.priyanka.addict.R;

import java.io.IOException;

import androidx.annotation.NonNull;
import pl.droidsonroids.gif.GifDrawable;

public class DialogLimitWarning extends Dialog implements View.OnClickListener {
    Context context;
    TextView tv_okay;
    ImageView iv_Header;

    public DialogLimitWarning(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_limit_warning);

        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
        }

        initUi();
    }

    private void initUi() {
        iv_Header = findViewById(R.id.iv_Header);
        try {
            GifDrawable gifFromResource = new GifDrawable( context.getResources(), R.drawable.ic_warning);
            iv_Header.setImageDrawable(gifFromResource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tv_okay = findViewById(R.id.tv_okay);
        tv_okay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tv_okay){
            dismiss();
        }
    }
}
