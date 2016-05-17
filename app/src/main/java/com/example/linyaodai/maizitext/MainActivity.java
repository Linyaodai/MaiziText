package com.example.linyaodai.maizitext;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button main_bind;
    private Button mian_unbind;
    private Button mian_start;
    private MyService myService ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        main_bind = (Button) findViewById(R.id.main_bind);
        mian_unbind = (Button) findViewById(R.id.mian_unbind);
        mian_start = (Button) findViewById(R.id.mian_start);

        main_bind.setOnClickListener(this);
        mian_unbind.setOnClickListener(this);
        mian_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        switch (v.getId()) {
            case R.id.main_bind:
                unbindService(conn);
                break;
            case R.id.mian_unbind:

                bindService(intent,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.mian_start:
                Log.i("linyaodaiI","startService")    ;
                startService(intent);
                break;
        }
    }
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myService = ((MyService.ServiceBinder)iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myService = null;
        }
    };
}
