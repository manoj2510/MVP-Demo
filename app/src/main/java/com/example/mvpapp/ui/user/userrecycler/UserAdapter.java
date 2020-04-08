package com.example.mvpapp.ui.user.userrecycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpapp.R;
import com.example.mvpapp.model.userlistreponse.UserListResponse;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<UserListResponse> userDetails;
    private Context mContext;

    public UserAdapter(List<UserListResponse> userDetails, Context mContext) {
//        Log.d("adapterList", userDetails.toString());
        this.userDetails = userDetails;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_list_item, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String id = userDetails.get(position).getId();
        String name = userDetails.get(position).getName();
        String email = userDetails.get(position).getEmail();
        Log.d("okay", "onBindViewHolder: "+id+" "+name+" "+email);
        holder.mUserId.setText(userDetails.get(position).getId());
        holder.mName.setText(userDetails.get(position).getName());
        holder.mUserEmail.setText(userDetails.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
//        if(userDetails!=null) {
            return userDetails.size();
//        }
//        return -1;
    }
}
