package service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootBroadcast:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action.equals(Intent.ACTION_BOOT_COMPLETED)){
            Log.e("Device Booted", "Action Boot")
            val serviceIntent = Intent(context, FirebaseService::class.java)
            context?.startService(serviceIntent)
        }
    }
}