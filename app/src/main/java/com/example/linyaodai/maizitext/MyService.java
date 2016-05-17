package com.example.linyaodai.maizitext;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by wj on 2016/5/15 0015.
 */


public class MyService extends Service {

    private void myText(){
        Log.i("linyaodaiI","myText")    ;
    }

    @Override
    public void onCreate() {
        Log.i("linyaodaiI","onCreate")    ;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("linyaodaiI","onStartCommand")    ;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("linyaodaiI","onDestroy")    ;
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("linyaodaiI","onUnbind")    ;
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("linyaodaiI","onBind")    ;
        return null;
    }

    class ServiceBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }
}
