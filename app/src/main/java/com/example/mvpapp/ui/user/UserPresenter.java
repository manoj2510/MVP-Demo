package com.example.mvpapp.ui.user;

import android.content.Context;

import com.example.mvpapp.model.userlistreponse.UserListResponse;
import com.example.mvpapp.network.APICallback;
import com.example.mvpapp.utils.Utils;

import java.util.List;

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View mView;
    private Context mContext;
    private UserRepository mUserRepository;

    public UserPresenter(UserContract.View mView, Context mContext, UserRepository mUserRepository) {
        this.mView = mView;
        this.mContext = mContext;
        this.mUserRepository = mUserRepository;
        mView.setPresenter(this);
    }

    @Override
    public void callUserData() {
        if(Utils.isNetworkAvailable(mContext)) {
            mView.showProgressBar();
            mUserRepository.callUserData(new APICallback<List<UserListResponse>>() {
                @Override
                public void onSuccess(List<UserListResponse> response) {
                    mView.hideProgressBar();
                    mView.onRetrieveSuccessful(response);
                }

                @Override
                public void onFailure() {
                    mView.hideProgressBar();
                    mView.onRetrieveFailure("Something went wrong!");
                }
            });
        }
        else
        {
            mView.showSnackBar("Internet Not Available!");
        }
    }

    @Override
    public void show() {
        mView.showProgressBar();
    }
}
