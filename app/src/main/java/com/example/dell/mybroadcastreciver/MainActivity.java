package com.example.dell.mybroadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        NeTwrokChangRecvice changRecvice = new NeTwrokChangRecvice();
        registerReceiver(changRecvice, intentFilter);
    }

    private class NeTwrokChangRecvice extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
            if (activeNetworkInfo!=null && activeNetworkInfo.isAvailable()){

            Toast.makeText(context," 网络可以使用 ",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"w网络不可用",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
