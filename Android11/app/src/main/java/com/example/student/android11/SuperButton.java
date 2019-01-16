package com.example.student.android11;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SuperButton extends RelativeLayout {
    private ImageView mImageView;
    private TextView mTextView;

    public SuperButton(Context context) {
        super(context);
        init(context, null);
    }

    public SuperButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.super_button, this);

        mImageView = view.findViewById(R.id.imageView);
        mTextView = view.findViewById(R.id.textView);

        if(attrs != null){
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SuperButton, 0,0);

            String text = array.getString(R.styleable.SuperButton_buttonText);
            if(text != null){
                mTextView.setText(text);
            }

            int src = array.getResourceId(R.styleable.SuperButton_buttonSrc, 0);
            if(src != 0){
                mImageView.setImageResource(src);
            }
        }
    }
}
