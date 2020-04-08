package com.example.mvpapp.ui.signup;

import android.content.Context;

import com.example.mvpapp.model.signuprequest.SignUpRequest;
import com.example.mvpapp.model.signupresponse.SignUpResponse;
import com.example.mvpapp.network.APICallback;
import com.example.mvpapp.utils.Utils;

public class SignUpPresenter implements SignUpContract.Presenter{

    private SignUpContract.View mView;
    private Context mContext;
    private SignUpRepository mSignUpRepository;

    public SignUpPresenter(SignUpContract.View mView, Context mContext, SignUpRepository mSignUpRepository) {
        this.mView = mView;
        this.mContext = mContext;
        this.mSignUpRepository = mSignUpRepository;
        mView.setPresenter(this);
    }

    @Override
    public void callSignUp(SignUpRequest signUpRequest) {

        if(Utils.isNetworkAvailable(mContext))
        {
            mView.showProgressBar();
            mSignUpRepository.callSignUp(signUpRequest, new APICallback<SignUpResponse>() {
                @Override
                public void onSuccess(SignUpResponse response) {

                    mView.hideProgressBar();
                    mView.onSignUpSuccess(response);
                }

                @Override
                public void onFailure() {
                    mView.hideProgressBar();
                    mView.onSignUpFailure("Something went wrong!");
                }
            });
        }
        else
        {
            mView.showSnackBar("Internet Not Available!");
        }
    }

    @Override
    public boolean validateUser(String data) {

        if(!data.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void show() {
        mView.showProgressBar();
    }
}
