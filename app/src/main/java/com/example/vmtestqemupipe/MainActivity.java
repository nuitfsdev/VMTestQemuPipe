package com.example.vmtestqemupipe;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vmtestqemupipe.Utils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.show);


        Button qemu_pipe = (Button)findViewById(R.id.qemupipe);
        qemu_pipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.hasPipes(textView);
            }
        });

    }
}
