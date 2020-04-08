package com.example.mvpapp.ui.user.userrecycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpapp.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView mUserId, mName, mUserEmail;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        mUserId = itemView.findViewById(R.id.tv_id);
        mName = itemView.findViewById(R.id.tv_name);
        mUserEmail = itemView.findViewById(R.id.tv_email);
    }
}
