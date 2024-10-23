package com.nk.autoreplaycodetemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nk.autoreplaycodetemp.services.MyScheduledService;
import com.nk.autoreplaycodetemp.singletons.RunCode;

public class HomeActivity extends AppCompatActivity {

    private Button startRunCodeBtn, stopRunCodeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        setReferences();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startRunCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code not working, from ChatGPT
//                Intent intent = new Intent(getBaseContext(), MyScheduledService.class);
//                startService(intent);

                RunCode runCode = RunCode.getInstance();
                runCode.startCode();
            }
        });

        stopRunCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code not working, from ChatGPT
//                Intent intent = new Intent(getBaseContext(), MyScheduledService.class);
//                stopService(intent);

                RunCode runCode = RunCode.getInstance();
                runCode.stopCode();
            }
        });
    }

    private void setReferences() {
        startRunCodeBtn = findViewById(R.id.start_run_code_btn);
        stopRunCodeBtn = findViewById(R.id.stop_run_code_btn);
    }
}