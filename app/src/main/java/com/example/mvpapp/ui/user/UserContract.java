package com.example.mvpapp.ui.user;

import com.example.mvpapp.base.BasePresenter;
import com.example.mvpapp.base.BaseView;
import com.example.mvpapp.model.userlistreponse.UserListResponse;

import java.util.List;

public interface UserContract {

    interface View extends BaseView<Presenter>
    {
        void onRetrieveSuccessful(List<UserListResponse> list);

        void onRetrieveFailure(String message);
    }

    interface Presenter extends BasePresenter {

        void callUserData();

    }
}
