package com.nk.autoreplaycodetemp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nk.autoreplaycodetemp.services.MyScheduledService;
import com.nk.autoreplaycodetemp.singletons.RunCode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startRunCode();
        moveNextActivity();
    }

    private  void startRunCode() {
        //Code not working, from ChatGPT
//        Intent intent = new Intent(getBaseContext(), MyScheduledService.class);
//        startService(intent);

        RunCode runCode = RunCode.getInstance();

    }

    private void moveNextActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), HomeActivity.class));
                finish();
            }
        }, 1000);
    }
}