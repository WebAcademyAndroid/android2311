package com.example.student.android11;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


public class RequiredEditText extends AppCompatEditText {

    private boolean mRequired;

    public RequiredEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RequiredEditText, 0, 0);
        mRequired = array.getBoolean(R.styleable.RequiredEditText_required, false);

        array.recycle();
    }

    public boolean validate() {
        if (mRequired && getText().length() == 0) {
            setError("Required field");
            return false;
        }
        return true;
    }
}
