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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText preEditText;
    EditText midEditText;
    EditText postEditText;
    boolean isPreOrder;

    OrderModel orderModel = new OrderModel();
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
        initListener();
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
                isPreOrder = false;
            }
        });
        postEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preEditText.setText("");
                isPreOrder = true;
            }
        });

    }

    public void doCalculateOrder(View view) {
        String pre = preEditText.getText().toString();
        String mid = midEditText.getText().toString();
        String post = postEditText.getText().toString();

        if (isPreOrder) {
            int checkedCode = orderModel.securityCheck(post, mid);
            if (checkedCode != 0)
                toast(checkedCode);
            else {
                orderModel.calculateOrderList(post, mid, isPreOrder);
                System.out.println(orderModel.resultArrayList);
                preEditText.setText(orderModel.resultArrayList.toString() + "");
            }
        } else {
            int checkedCode = orderModel.securityCheck(pre, mid);
            if (checkedCode != 0)
                toast(checkedCode);
            else {
                orderModel.calculateOrderList(pre, mid, isPreOrder);
                System.out.println(orderModel.resultArrayList);
                postEditText.setText(orderModel.resultArrayList.toString() + "");
            }
        }

    }

    private void toast(int code) {
        String wroneMSG = Const.get(code);
        Toast.makeText(this, wroneMSG, Toast.LENGTH_SHORT).show();
    }

    public void doClearInput(View view) {
        preEditText.setText("");
        midEditText.setText("");
        postEditText.setText("");
    }




}
