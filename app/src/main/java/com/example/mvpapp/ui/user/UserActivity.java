package com.example.mvpapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpapp.R;
import com.example.mvpapp.base.BaseActivity;
import com.example.mvpapp.model.userlistreponse.UserListResponse;
import com.example.mvpapp.ui.user.userrecycler.UserAdapter;
import com.example.mvpapp.utils.SnackBarUtil;

import java.util.List;

public class UserActivity extends BaseActivity implements UserContract.View{

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private UserPresenter mUserPresenter;
    private List<UserListResponse> mUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initView();
        setValues();
    }

    @Override
    public void initView() {
        mRecyclerView = findViewById(R.id.user_list_recycler_view);
        mProgressBar = findViewById(R.id.pb_user);
        new UserPresenter(this,this,new UserRepository());
    }

    @Override
    public void setValues() {
        mUserPresenter.callUserData();
    }

    @Override
    public void onRetrieveSuccessful(List<UserListResponse> list) {
        mUserList =  list;
        Log.d("list", list.toString());
        UserAdapter userAdapter = new UserAdapter(mUserList,this);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(userAdapter);

    }

    @Override
    public void onRetrieveFailure(String message) {
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
    public void setPresenter(UserContract.Presenter presenter) {
        mUserPresenter = (UserPresenter) presenter;
    }
}
