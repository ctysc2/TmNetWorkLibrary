package com.tm.networklibrary;

import com.tm.tmnetwork.repository.network.RWService;

import retrofit2.http.GET;
import rx.Observable;

public interface MyService{

    @GET("/api/subject-zm-service/project/queryAllProjectAlias")
    Observable<TestDao> queryAllProjectAlias();
}
