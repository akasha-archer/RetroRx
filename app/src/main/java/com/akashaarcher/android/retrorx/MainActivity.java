package com.akashaarcher.android.retrorx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView listResultsRv;

    private List<CivilServiceList> listResults;
    private CivilServiceListAdapter adapter;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final String API_URL = "https://data.cityofnewyork.us/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        listResultsRv.setLayoutManager(new LinearLayoutManager(this));
        listResultsRv.setAdapter(adapter);
        getResultList();
    }

    private void getResultList() {

        CivilServiceListClient.getInstance()
                .getCivilServiceList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CivilServiceList>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "In onSubscribe");
                    }

                    @Override
                    public void onNext(CivilServiceList value) {
                        adapter.setData(listResults);
                        Log.d(TAG, "In onNext, list size: " + listResults.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "In onComplete");
                    }
                });
    }
}
