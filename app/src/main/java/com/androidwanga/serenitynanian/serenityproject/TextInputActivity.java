package com.androidwanga.serenitynanian.serenityproject;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextInputActivity extends AppCompatActivity {


    private static final int MAX_LENGTH = 6;
    private TextInputLayout mUserNameTextInputLayout ;
    private TextInputLayout mPasswordTextInputLayout;

    private EditText mUserNameEditText ;
    private TextInputEditText mPasswordEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);


        mUserNameTextInputLayout = (TextInputLayout) findViewById(R.id.username_inputlayout);
        mPasswordTextInputLayout = (TextInputLayout) findViewById(R.id.password_inputlayout);

        mUserNameEditText = (EditText) findViewById(R.id.et_username);
        mPasswordEditText = (TextInputEditText) findViewById(R.id.et_password);

//        mPasswordTextInputLayout.setPasswordVisibilityToggleEnabled(true);
//        mPasswordTextInputLayout.setPasswordVisibilityToggleDrawable(R.mipmap.ic_launcher_round);

        mUserNameTextInputLayout.setCounterEnabled(true);
        mUserNameTextInputLayout.setCounterMaxLength(MAX_LENGTH);


        mUserNameTextInputLayout.setErrorTextAppearance(R.style.TextInputErrorStyle);
        mPasswordTextInputLayout.setErrorTextAppearance(R.style.TextInputErrorStyle);

        mUserNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = s.length();
                if(length> MAX_LENGTH ){
                    mUserNameTextInputLayout.setError("Max length is :"+ MAX_LENGTH);
                }else{
                    mUserNameTextInputLayout.setErrorEnabled(false);
                }
            }
        });

        mPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = s.length();
                if(length> MAX_LENGTH ){
                    mPasswordTextInputLayout.setError("Max length is :"+ MAX_LENGTH);
                }else{
                    mPasswordTextInputLayout.setErrorEnabled(false);
                }
            }
        });

    }
}
