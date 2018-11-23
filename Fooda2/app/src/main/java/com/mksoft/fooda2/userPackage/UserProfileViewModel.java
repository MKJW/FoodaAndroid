package com.mksoft.fooda2.userPackage;


import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserProfileViewModel extends ViewModel {
    private LiveData<User> user;
    // Instructs Dagger 2 to provide the UserRepository parameter.
    /*@Inject
    public UserProfileViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }//더거2로 처리가능할꺼 같지만 나중에...

    */
    private UserRepository userRepository;

    public void init(String userId) {
        if (this.user != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;//유저가 있으면 초기화하지 않느다.
        }
        if(userRepository == null)
            userRepository = new UserRepository();

        user = userRepository.getUser(userId);
    }
    public LiveData<User> getUser() {
        return this.user;
    }
}