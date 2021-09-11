package org.ppsspp.ppsspp; 
 
import android.content.Context; 
import android.location.Location; 
import android.location.LocationListener; 
import android.location.LocationManager; 
import android.os.Bundle; 
import android.util.Log; 
 
public class LocationHelper 
implements LocationListener { 
    private static final String TAG = "LocationHelper"; 
    private boolean mLocationEnable; 
    private LocationManager mLocationManager; 
 
    public LocationHelper(Context context) { 
        this.mLocationManager = (LocationManager)context.getSystemService("location"); 
        this.mLocationEnable = false; 
    } 
 
    public void onLocationChanged(Location location) { 
        NativeApp.pushNewGpsData((float)location.getLatitude(), (float)location.getLongitude(), (float)location.getAltitude(), location.getSpeed(), location.getBearing(), location.getTime() / 1000L); 
    } 
 
    public void onProviderDisabled(String string2) { 
    } 
 
    public void onProviderEnabled(String string2) { 
    } 
 
    public void onStatusChanged(String string2, int n, Bundle bundle) { 
    } 
 
    /* 
     * Loose catch block 
     * Enabled aggressive block sorting 
     * Enabled unnecessary exception pruning 
     * Enabled aggressive exception aggregation 
     * Lifted jumps to return sites 
     */ 
   
  public void startLocationUpdates() { 
        boolean bl; 
        boolean bl2; 
        block6 : { 
            SecurityException securityException; 
            block7 : { 
                block8 : { 
                    Log.d((String)TAG, (String)"startLocationUpdates"); 
                    if (this.mLocationEnable) return; 
                    bl = this.mLocationManager.isProviderEnabled("gps"); 
                    try { 
                        bl2 = this.mLocationManager.isProviderEnabled("network"); 
                    } 
                    catch (SecurityException securityException2) { 
                        securityException = securityException2; 
                        break block8; 
                    } 
                    try { 
                        this.mLocationManager.requestLocationUpdates("gps", 1000L, 0.0f, (LocationListener)this); 
                        this.mLocationManager.requestLocationUpdates("network", 1000L, 0.0f, (LocationListener)this); 
                        this.mLocationEnable = true; 
                        break block6; 
                    } 
                    catch (SecurityException securityException4) { 
                        securityException = securityException4; 
                        bl = false; 
                    } 
                } 
                bl2 = false; 
            } 
            StringBuilder stringBuilder = new StringBuilder(); 
            stringBuilder.append("Cannot start location updates: "); 
            stringBuilder.append(securityException.toString()); 
            Log.e((String)TAG, (String)stringBuilder.toString()); 
        } 
        if (bl) return; 
        if (bl2) return; 
        Log.i((String)TAG, (String)"No location provider found"); 
    } 
  
    public void stopLocationUpdates() { 
        Log.d((String)TAG, (String)"stopLocationUpdates"); 
        if (this.mLocationEnable) { 
            this.mLocationEnable = false; 
            this.mLocationManager.removeUpdates((LocationListener)this); 
        } 
    } 
} 
 
 
