package com.hhxfindingjob.practicebinary.calculatebinarytree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText preEditText;
    EditText midEditText;
    EditText postEditText;
    EditText nearestClicedText; //pre or post
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "正在跳转到作者的本文博客", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Uri uri = Uri.parse("https://github.com/freedomofme");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        init();
    }

    private void init() {
        preEditText  = (EditText) findViewById(R.id.et_preorder);
        midEditText  = (EditText) findViewById(R.id.et_midorder);
        postEditText  = (EditText) findViewById(R.id.et_postorder);
    }

    private void initListener() {
        preEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postEditText.setText("");
                nearestClicedText = preEditText;
            }
        });
        postEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preEditText.setText("");
                nearestClicedText = postEditText;
            }
        });

    }

    public void doCalculateOrder(View view) {

    }

    public void doClearInput(View view) {

    }




}
