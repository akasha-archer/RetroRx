package com.akashaarcher.android.retrorx;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.GET;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Akasha on 10/19/17.
 */

public interface CivilServiceListApi {

    @GET("resource/5scm-b38n.json")
    Observable<CivilServiceList> getCivilServiceList();

}
