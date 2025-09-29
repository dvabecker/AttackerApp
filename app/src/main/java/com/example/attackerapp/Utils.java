package com.example.attackerapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

/* loaded from: classes.dex */
public class Utils {
    public static String dumpIntent(Context context, Intent intent) {
        return dumpIntent(context, intent, 0);
    }

    public static void writeFile(Context context, String str, String str2) {
        File parentFile = new File(context.getFilesDir(), str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile2(Context context, String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir() + "/../", str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String dumpIntent(Context context, Intent intent, int i) {
        if (intent == null) {
            return "Intent is null";
        }
        StringBuilder sb = new StringBuilder();
        String replace = new String(new char[i]).replace("\u0000", "    ");
        sb.append(replace).append("[Action]    ").append(intent.getAction()).append("\n");
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            for (String str : categories) {
                sb.append(replace).append("[Category]  ").append(str).append("\n");
            }
        }
        sb.append(replace).append("[Data]      ").append(intent.getDataString()).append("\n");
        sb.append(replace).append("[Component] ").append(intent.getComponent()).append("\n");
        sb.append(replace).append("[Flags]     ").append(getFlagsString(intent.getFlags())).append("\n");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str2 : extras.keySet()) {
                Object obj = extras.get(str2);
                if (obj instanceof Intent) {
                    sb.append(replace).append("[Extra:'").append(str2).append("'] -> Intent\n");
                    sb.append(dumpIntent(context, (Intent) obj, i + 1));
                } else if (obj instanceof Bundle) {
                    sb.append(replace).append("[Extra:'").append(str2).append("'] -> Bundle\n");
                    sb.append(dumpBundle((Bundle) obj, i + 1));
                } else {
                    sb.append(replace).append("[Extra:'").append(str2).append("']: ").append(obj).append("\n");
                }
            }
        }
        return sb.toString();
    }

    private static String getFlagsString(int i) {
        StringBuilder sb = new StringBuilder();
        if ((i & 1) != 0) {
            sb.append("GRANT_READ_URI_PERMISSION | ");
        }
        if ((i & 2) != 0) {
            sb.append("GRANT_WRITE_URI_PERMISSION | ");
        }
        if ((i & 64) != 0) {
            sb.append("GRANT_PERSISTABLE_URI_PERMISSION | ");
        }
        if ((i & 128) != 0) {
            sb.append("GRANT_PREFIX_URI_PERMISSION | ");
        }
        int i2 = 268435456 & i;
        if (i2 != 0) {
            sb.append("ACTIVITY_NEW_TASK | ");
        }
        int i3 = 536870912 & i;
        if (i3 != 0) {
            sb.append("ACTIVITY_SINGLE_TOP | ");
        }
        int i4 = 1073741824 & i;
        if (i4 != 0) {
            sb.append("ACTIVITY_NO_HISTORY | ");
        }
        if ((67108864 & i) != 0) {
            sb.append("ACTIVITY_CLEAR_TOP | ");
        }
        if ((33554432 & i) != 0) {
            sb.append("ACTIVITY_FORWARD_RESULT | ");
        }
        if ((16777216 & i) != 0) {
            sb.append("ACTIVITY_PREVIOUS_IS_TOP | ");
        }
        if ((8388608 & i) != 0) {
            sb.append("ACTIVITY_EXCLUDE_FROM_RECENTS | ");
        }
        if ((4194304 & i) != 0) {
            sb.append("ACTIVITY_BROUGHT_TO_FRONT | ");
        }
        int i5 = 2097152 & i;
        if (i5 != 0) {
            sb.append("ACTIVITY_RESET_TASK_IF_NEEDED | ");
        }
        if ((1048576 & i) != 0) {
            sb.append("ACTIVITY_LAUNCHED_FROM_HISTORY | ");
        }
        int i6 = 524288 & i;
        if (i6 != 0) {
            sb.append("ACTIVITY_CLEAR_WHEN_TASK_RESET | ");
        }
        if (i6 != 0) {
            sb.append("ACTIVITY_NEW_DOCUMENT | ");
        }
        if ((262144 & i) != 0) {
            sb.append("ACTIVITY_NO_USER_ACTION | ");
        }
        if ((131072 & i) != 0) {
            sb.append("ACTIVITY_REORDER_TO_FRONT | ");
        }
        if ((65536 & i) != 0) {
            sb.append("ACTIVITY_NO_ANIMATION | ");
        }
        if ((32768 & i) != 0) {
            sb.append("ACTIVITY_CLEAR_TASK | ");
        }
        if ((i & 16384) != 0) {
            sb.append("ACTIVITY_TASK_ON_HOME | ");
        }
        if ((i & 8192) != 0) {
            sb.append("ACTIVITY_RETAIN_IN_RECENTS | ");
        }
        if ((i & 4096) != 0) {
            sb.append("ACTIVITY_LAUNCH_ADJACENT | ");
        }
        if ((i & 512) != 0) {
            sb.append("ACTIVITY_REQUIRE_DEFAULT | ");
        }
        if ((i & 1024) != 0) {
            sb.append("ACTIVITY_REQUIRE_NON_BROWSER | ");
        }
        if ((i & 2048) != 0) {
            sb.append("ACTIVITY_MATCH_EXTERNAL | ");
        }
        int i7 = i & 134217728;
        if (i7 != 0) {
            sb.append("ACTIVITY_MULTIPLE_TASK | ");
        }
        if (i4 != 0) {
            sb.append("RECEIVER_REGISTERED_ONLY | ");
        }
        if (i3 != 0) {
            sb.append("RECEIVER_REPLACE_PENDING | ");
        }
        if (i2 != 0) {
            sb.append("RECEIVER_FOREGROUND | ");
        }
        if (i7 != 0) {
            sb.append("RECEIVER_NO_ABORT | ");
        }
        if (i5 != 0) {
            sb.append("RECEIVER_VISIBLE_TO_INSTANT_APPS | ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 3);
        }
        return sb.toString();
    }

    public static String dumpBundle(Bundle bundle) {
        return dumpBundle(bundle, 0);
    }

    private static String dumpBundle(Bundle bundle, int i) {
        if (bundle == null) {
            return "Bundle is null";
        }
        StringBuilder sb = new StringBuilder();
        String replace = new String(new char[i]).replace("\u0000", "    ");
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                sb.append(String.format("%s['%s']: Bundle[\n%s%s]\n", replace, str, dumpBundle((Bundle) obj, 1 + i), replace));
            } else {
                Object[] objArr = new Object[3];
                objArr[0] = replace;
                objArr[1] = str;
                objArr[2] = obj != null ? obj.toString() : "null";
                sb.append(String.format("%s['%s']: %s\n", objArr));
            }
        }
        return sb.toString();
    }

    public static Dialog showIntentDialog(Context context, String str, Intent intent) {
        return showIntentDialog(context, str, intent, false);
    }

    public static Dialog showIntentDialog(Context context, String str, Intent intent, boolean z) {
        if (intent == null) {
            return null;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(20, 50, 20, 50);
        linearLayout.setBackgroundColor(-1052683);
        TextView textView = new TextView(context);
        if (z) {
            textView.setText(str + " (censored)");
        } else {
            textView.setText(str);
        }
        textView.setTextSize(16.0f);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textView.setPadding(0, 0, 0, 40);
        textView.setGravity(17);
        textView.setBackgroundColor(-1052683);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        if (z) {
            textView2.setText("Intent details are censored because it could contain the flag. Try to hijack this intent with your own app instead.");
        } else {
            textView2.setText(dumpIntent(context, intent));
        }
        textView2.setTypeface(Typeface.MONOSPACE);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView2.setPadding(0, 0, 0, 30);
        textView2.setGravity(GravityCompat.START);
        textView2.setBackgroundColor(-1052683);
        linearLayout.addView(textView2);
        Button button = new Button(context);
        button.setText("OK");
        button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        button.setOnClickListener(new View.OnClickListener() { // from class: io.hextree.attacksurface.Utils$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        linearLayout.addView(button);
        dialog.setContentView(linearLayout);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = Gravity.BOTTOM;
            window.setAttributes(attributes);
        }
        dialog.show();
        linearLayout.setTranslationY(2000.0f);
        linearLayout.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(300L);
        animatorSet.setStartDelay(100L);
        animatorSet.start();
        return dialog;
    }
}