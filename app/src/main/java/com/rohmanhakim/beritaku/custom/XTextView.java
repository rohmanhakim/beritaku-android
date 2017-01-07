package com.rohmanhakim.beritaku.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.rohmanhakim.beritaku.R;

public class XTextView extends TextView{
    private AttributeSet attributeSet;
    private int fontStyle;

    public XTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attributeSet = attributeSet;
        init(getFontFamily());
    }

    public void setFontStyle(int fontStyle) {
        int fontFamily = getFontFamily();
        this.fontStyle = fontStyle;
        init(fontFamily);
        invalidate();
    }

    public int getFontFamily() {
        TypedArray styledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.XTextView);
        int fontFamily = styledAttributes.getInt(R.styleable.XTextView_fontFamily, XTextViewAttr.roboto);
        fontStyle = styledAttributes.getInt(R.styleable.XTextView_fontStyle, XTextViewAttr.regular);
        styledAttributes.recycle();
        return fontFamily;
    }

    private void init(int fontFamily) {
        String fontName = null;
        switch (fontFamily) {
            // font family BEBAS
            case XTextViewAttr.bebas:
                switch (fontStyle) {
                    case XTextViewAttr.regular:
                        fontName = "fonts/BebasNeue Regular.ttf";
                        break;
                    case XTextViewAttr.bold:
                        fontName = "fonts/BebasNeue Bold.ttf";
                        break;
                    case XTextViewAttr.book:
                        fontName = "fonts/BebasNeue Book.ttf";
                        break;
                }
                break;
            // font family LATO
            case XTextViewAttr.lato:
                switch (fontStyle) {
                    case XTextViewAttr.regular:
                        fontName = "fonts/lato-regular.ttf";
                        break;
                    case XTextViewAttr.bold:
                        fontName = "fonts/lato-bold.ttf";
                        break;
                    case XTextViewAttr.medium:
                        fontName = "fonts/lato-medium.ttf";
                        break;
                    case XTextViewAttr.thin:
                        fontName = "fonts/lato-thin.ttf";
                        break;
                }
                break;
            // font family CHAMPAGNE
            case XTextViewAttr.champagne:
                switch (fontStyle) {
                    case XTextViewAttr.regular:
                        fontName = "fonts/ChampagneLimousines-1.ttf";
                        break;
                    case XTextViewAttr.bold:
                        fontName = "fonts/ChampagneLimousines Bold-1.ttf";
                        break;
                }
                break;
            // font family OPEN SANS
            case XTextViewAttr.openSans:
                switch (fontStyle) {
                    case XTextViewAttr.regular:
                        fontName = "fonts/OpenSans-Regular.ttf";
                        break;
                    case XTextViewAttr.bold:
                        fontName = "fonts/OpenSans-Bold.ttf";
                        break;
                }
                break;
            // font family us101
            case XTextViewAttr.us:
                fontName = "fonts/us101.TTF";
                break;
            // font family Roboto.
            case XTextViewAttr.roboto:
                switch (fontStyle) {
                    case XTextViewAttr.regular:
                        fontName = "fonts/Roboto-Regular.ttf";
                        break;
                    case XTextViewAttr.bold:
                        fontName = "fonts/Roboto-Bold.ttf";
                        break;
                    case XTextViewAttr.medium:
                        fontName = "fonts/Roboto-Medium.ttf";
                        break;
                    case XTextViewAttr.light:
                        fontName = "fonts/Roboto-Light.ttf";
                        break;
                }
                break;
            // font family NEO SANS PRO
            case XTextViewAttr.neoSansPro:
                switch (fontStyle) {
                    case XTextViewAttr.regular:
                        fontName = "fonts/NeoSansPro.ttf";
                        break;
                    case XTextViewAttr.bold:
                        fontName = "fonts/NeoSansPro-Bold.ttf";
                        break;
                    case XTextViewAttr.medium:
                        fontName = "fonts/NeoSansPro-Medium.ttf";
                        break;
                    case XTextViewAttr.thin:
                        fontName = "fonts/NeoSansPro-Light.ttf";
                        break;
                    default:
                        fontName = "fonts/NeoSansPro.ttf";
                        break;
                }
                break;
        }

        setTypeface(Typeface.createFromAsset(getContext().getAssets(), fontName));
    }

    public static class XTextViewAttr {
        // font family
        public static final int lato = 1;
        public static final int bebas = 2;
        public static final int us = 3;
        public static final int champagne = 4;
        public static final int openSans = 5;
        public static final int neoSansPro = 6;
        public static final int roboto = 7;

        // font style
        public static final int regular = 0;
        public static final int bold = 1;
        public static final int medium = 2;
        public static final int thin = 3;
        public static final int book = 4; // for bebas neue
        public static final int light = 5; // for roboto light
    }
}
