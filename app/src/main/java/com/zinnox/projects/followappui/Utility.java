package com.zinnox.projects.followappui;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;

/**
 * ō
 * Created by apple on 18/01/18.
 */

public final class Utility {

    public static final String FONT_NAME = "fonts/HelveticaNeue-Bold.ttf";

    public static void applyFontForTextView(Context context, TextView view) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), FONT_NAME);

        view.setTypeface(tf);
    }

    public static void applyFontForButton(Context context, Button view) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), FONT_NAME);

        view.setTypeface(tf);
    }
}
