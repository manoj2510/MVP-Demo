package com.example.mvpapp.network;

public interface APICallback<T> {

    void onSuccess(T response);

    void onFailure();

}
