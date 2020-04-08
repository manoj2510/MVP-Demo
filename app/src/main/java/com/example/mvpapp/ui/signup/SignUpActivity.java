package com.example.mvpapp.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpapp.R;
import com.example.mvpapp.base.BaseActivity;
import com.example.mvpapp.model.signuprequest.SignUpRequest;
import com.example.mvpapp.model.signupresponse.SignUpResponse;
import com.example.mvpapp.ui.user.UserActivity;
import com.example.mvpapp.utils.SnackBarUtil;

public class SignUpActivity extends BaseActivity implements SignUpContract.View {

    private EditText mName, mEmail, mPassword;
    private Button mSignUpButton;
    private ProgressBar mProgressBar;
    private SignUpPresenter mSignUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
        setValues();
    }

    @Override
    public void initView() {
        mName = findViewById(R.id.et_name);
        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        mSignUpButton = findViewById(R.id.bt_signup);
        mProgressBar = findViewById(R.id.pb);
        new SignUpPresenter(this,this,new SignUpRepository());
    }

    @Override
    public void setValues() {
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(!mSignUpPresenter.validateUser(name))
                {
                    Toast.makeText(SignUpActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                } else if(!mSignUpPresenter.validateUser(email))
                {
                    Toast.makeText(SignUpActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if(!mSignUpPresenter.validateUser(password))
                {
                    Toast.makeText(SignUpActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else{
                    SignUpRequest signUpRequest = new SignUpRequest(email,name,password,"email");
                    mSignUpPresenter.callSignUp(signUpRequest);
                }
            }
        });
    }
    @Override
    public void onSignUpSuccess(SignUpResponse signUpResponse) {
        Toast.makeText(this, signUpResponse.getUserid()+" "+signUpResponse.getSuccess()+" "+signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();
        emptyTheView();
        Intent intent = new Intent(SignUpActivity.this, UserActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSignUpFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSnackBar(String message) {
        SnackBarUtil.setSnackBar(null, message);
    }

    @Override
    public void setPresenter(SignUpContract.Presenter presenter) {
        mSignUpPresenter = (SignUpPresenter) presenter;
    }

    private void emptyTheView() {
        mName.setText("");
        mEmail.setText("");
        mPassword.setText("");
    }

}
