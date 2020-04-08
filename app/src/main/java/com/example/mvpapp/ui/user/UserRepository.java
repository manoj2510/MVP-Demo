package com.example.mvpapp.ui.user;

import com.example.mvpapp.model.userlistreponse.UserListResponse;
import com.example.mvpapp.network.APICallback;
import com.example.mvpapp.network.APIClient;
import com.example.mvpapp.network.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    public void callUserData(final APICallback<List<UserListResponse>> callback)
    {
        APIService apiService = APIClient.getRetrofitClient().create(APIService.class);
        Call<List<UserListResponse>> call = apiService.getUserList();

        call.enqueue(new Callback<List<UserListResponse>>() {
            @Override
            public void onResponse(Call<List<UserListResponse>> call, Response<List<UserListResponse>> response) {
                List<UserListResponse> userListResponses;
                if(response!=null && response.body()!=null)
                {
                    userListResponses = response.body();
                    callback.onSuccess(userListResponses);
                }
            }

            @Override
            public void onFailure(Call<List<UserListResponse>> call, Throwable t) {
                callback.onFailure();
            }
        });
    }
}
