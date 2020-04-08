package com.example.mvpapp.ui.signup;

import com.example.mvpapp.model.signuprequest.SignUpRequest;
import com.example.mvpapp.model.signupresponse.SignUpResponse;
import com.example.mvpapp.network.APICallback;
import com.example.mvpapp.network.APIClient;
import com.example.mvpapp.network.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepository {

    public void callSignUp(SignUpRequest signUpRequest, final APICallback<SignUpResponse> callback)
    {
        APIService apiService = APIClient.getRetrofitClient().create(APIService.class);
        Call<SignUpResponse> call =apiService.signUp(signUpRequest);

        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                SignUpResponse signUpResponse = response.body();
                callback.onSuccess(signUpResponse);
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

}
