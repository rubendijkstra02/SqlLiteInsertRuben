package com.example.ruben.sqlliteinsertruben;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Ruben on 9-11-2017.
 */

public class Message {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
