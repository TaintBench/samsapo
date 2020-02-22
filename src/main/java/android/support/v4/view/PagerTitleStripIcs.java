package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class PagerTitleStripIcs {

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private static final String TAG = "SingleLineAllCapsTransform";
        private Locale mLocale;

        public SingleLineAllCapsTransform(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            return transformation != null ? transformation.toString().toUpperCase(this.mLocale) : null;
        }
    }

    PagerTitleStripIcs() {
    }

    public static void setSingleLineAllCaps(TextView textView) {
        TextView textView2 = textView;
        TextView textView3 = textView2;
        SingleLineAllCapsTransform singleLineAllCapsTransform = r5;
        SingleLineAllCapsTransform singleLineAllCapsTransform2 = new SingleLineAllCapsTransform(textView2.getContext());
        textView3.setTransformationMethod(singleLineAllCapsTransform);
    }
}
