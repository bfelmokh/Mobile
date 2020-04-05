package com.example.findme;

import android.app.NotificationChannel;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MySMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast. Réception du message SMS
        String messageBody,phoneNumber;
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle =intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]); }
                if (messages.length > -1) {
                    messageBody = messages[0].getMessageBody();
                    phoneNumber = messages[0].getDisplayOriginatingAddress();
                    Toast.makeText(context, "Message : "+messageBody+"Reçu de la part de;"+ phoneNumber, Toast.LENGTH_LONG ).show();
                    if (messageBody.contains("FindMe")){
                        NotificationCompat.Builder myNotification = new NotificationCompat.Builder(context, NotificationChannel.DEFAULT_CHANNEL_ID);
                        myNotification.setContentTitle(phoneNumber); // définir le titre
                        myNotification.setContentText(messageBody); // définir le contenu
                        myNotification.setSmallIcon(android.R.drawable.ic_dialog_map); // définir l'icon
                    // Vibration
                        myNotification.setVibrate(new long[]{1000,2000,1000,2000});
                        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        myNotification.setSound(alarm);
                        // Lancement du notification
                        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
                        manager.notify(1,  myNotification.build());

                    }
                }
            }
        }
    }
}
