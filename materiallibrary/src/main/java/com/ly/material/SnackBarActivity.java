package com.ly.material;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SnackBarActivity extends AppCompatActivity {
    Button mBtnShowSnackBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        mBtnShowSnackBar = findViewById(R.id.btn_show_snackbar);

        mBtnShowSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar();
            }
        });

        findViewById(R.id.btn_show_snackbar_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBarWithAction();
            }
        });
    }

    private void showSnackBar() {
        Snackbar.make(mBtnShowSnackBar, "simple show sanck bar", Snackbar.LENGTH_INDEFINITE).show();
    }

    private void showSnackBarWithAction() {
        Snackbar.make(mBtnShowSnackBar, "simple show sanck bar", Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Snackbar", "snack bar action trigger!!!");
            }
        }).show();
    }
}
