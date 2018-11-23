package com.mksoft.fooda2.userPackage;

import com.mksoft.fooda2.Webservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private Webservice webservice;
    private Retrofit retrofit;

    // ...

    public UserRepository() {
        retrofit = new Retrofit.Builder()
                .baseUrl("testIP")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webservice = retrofit.create(Webservice.class);
    }

    public LiveData<User> getUser(String userId) {
        // This isn't an optimal implementation. We'll fix it later.
        final MutableLiveData<User> data = new MutableLiveData<>();
        webservice.getUser(userId).enqueue(new Callback<User>() {//비동기식으로 서버에 요청
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());//data에 서버에서 받은 User저장
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //실패처리
            }

            // Error case is left out for brevity.
        });
        return data;
    }
}