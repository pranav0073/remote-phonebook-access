package com.example.remoteAcess;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class ServiceReceiver extends BroadcastReceiver {
    private static final String SMS_EXTRA_NAME = "pdus";
    private boolean isReceiving=true;
    private CallbackContext callback_receive;
   

	

    public void onReceive(Context context, Intent intent) {
    	
    	
    	 Log.d("debug", "sms detected");
    	Bundle extras=intent.getExtras(); //get the sms map
        if(extras!=null)
        {
            Object[] smsExtra=(Object[])extras.get(SMS_EXTRA_NAME); //get received sms array
           
            for(int i=0;i<smsExtra.length;i++)
            {
                SmsMessage sms=SmsMessage.createFromPdu((byte[])smsExtra[i]);
               
                Toast.makeText(context, "Service Destroyed", Toast.LENGTH_LONG).show();
               
                    String formattedMsg=sms.getOriginatingAddress()+">"+sms.getMessageBody();
                    Toast.makeText(context, formattedMsg, Toast.LENGTH_LONG).show();
                    /*PluginResult result=new PluginResult(PluginResult.Status.OK,formattedMsg);
                    result.setKeepCallback(true);
                    callback_receive.sendPluginResult(result);*/
                
                
            }

            //if the plugin is active and we don't want to broadcast to other receivers
          
        }
    	
    	
    	
    
    }


}