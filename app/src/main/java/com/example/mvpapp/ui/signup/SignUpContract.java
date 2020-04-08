package com.example.mvpapp.ui.signup;

import com.example.mvpapp.base.BasePresenter;
import com.example.mvpapp.base.BaseView;
import com.example.mvpapp.model.signuprequest.SignUpRequest;
import com.example.mvpapp.model.signupresponse.SignUpResponse;

public interface SignUpContract {

    interface View extends BaseView<Presenter> {

        void onSignUpSuccess(SignUpResponse signUpResponse);

        void onSignUpFailure(String message);
    }

    interface Presenter extends BasePresenter{

        void callSignUp(SignUpRequest signUpRequest);

        boolean validateUser(String data);
    }

}
