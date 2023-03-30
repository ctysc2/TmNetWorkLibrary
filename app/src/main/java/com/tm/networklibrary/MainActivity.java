package com.tm.networklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.tm.tmnetwork.app.TmsLibraryApp;
import com.tm.tmnetwork.repository.network.RetrofitManager;
import com.tm.tmnetwork.utils.NetWorkConfigUtil;
import com.tm.tmnetwork.utils.TransformUtils;

import java.util.ArrayList;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetWorkConfigUtil.init(this);
        TmsLibraryApp.preInit(this,"test","a","1",12);
        testRequest();
    }

    private void testRequest(){
        ((MyService)(RetrofitManager.getInstance("queryAllProjectAlias", MyService.class).getService())).queryAllProjectAlias()
                .compose(TransformUtils.<TestDao>defaultSchedulers())
                .subscribe(new Observer<TestDao>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(TestDao data) {
                        Toast.makeText(MainActivity.this,"111",Toast.LENGTH_SHORT).show();
                    }

                });
    }
}