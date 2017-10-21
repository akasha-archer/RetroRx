package com.akashaarcher.android.retrorx;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Akasha on 10/19/17.
 */

public class CivilServiceListClient {

    private final String API_URL = "https://data.cityofnewyork.us/";

    private static CivilServiceListClient instance;
    private CivilServiceListApi api;

    public static CivilServiceListClient getInstance() {
        if (instance == null) {
            instance = new CivilServiceListClient();
        }

        return instance;
    }

    private CivilServiceListClient() {
        final Gson gson =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(CivilServiceListApi.class);
//        Observable<List<CivilServiceList>> civilServiceList = api.getCivilServiceList();
//        civilServiceList.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe();
    }

    public Observable<CivilServiceList> getCivilServiceList() {
        return api.getCivilServiceList();
    }

}
