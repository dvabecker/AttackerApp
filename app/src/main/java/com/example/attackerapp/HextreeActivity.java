package com.example.attackerapp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class HextreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hextree);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_screen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.hextree_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Flag 8
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag8Activity"));
                startActivityForResult(intent, 1);
                 */

                /* Flag 9
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag9Activity"));
                startActivityForResult(intent, 1);
                 */
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Flag 9", Objects.requireNonNull(data.getStringExtra("flag")));
    }
}