package com.example.synchronoss2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class PhoneReceiver extends BroadcastReceiver {
Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        TelephonyManager tmgr = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        MyPhoneStateListener PhoneListener = new MyPhoneStateListener();
        tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

    }

    private class MyPhoneStateListener extends PhoneStateListener {

        public void onCallStateChanged(int state, String incomingNumber) {

            Log.d("MyPhoneListener", state + "   incoming no:" + incomingNumber);


            // state = 1 means when phone is ringing
            if (state == 1) {

                String msg = " New Phone Call Event. Incoming Number : " + incomingNumber;
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(mContext,msg, duration);

                toast.show();

            }
        }
    }
}
