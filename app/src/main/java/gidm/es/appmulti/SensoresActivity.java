package gidm.es.appmulti;


import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by JCristobal and Miguel on 04/06/2016.
 */

public class SensoresActivity extends FragmentActivity implements SensoresFragment.LisSelectionListener {
    private static final String TAG = "Sensores";
    SensorManager sensorManager;
    private SensoresFragment vSensoresFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);

        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<Map<String, String>> sensorData = new ArrayList<Map<String,String>>();

        for (Sensor sensor: sensorList) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("name", sensor.getName());
            data.put("vendor", sensor.getVendor());
            sensorData.add(data);
        }

        SimpleAdapter sa = new SimpleAdapter(this, sensorData, android.R.layout.simple_list_item_2, new String[]{"name", "vendor"}, new int[]{android.R.id.text1, android.R.id.text2});

        ListView lv = (ListView) findViewById(R.id.sensorList);
        lv.setAdapter(sa);

        vSensoresFragment = (SensoresFragment) getSupportFragmentManager().findFragmentById(R.id.sensores);

    }

    // Funciones para controlar el estado de la aplicación
    @Override
    protected void onStart(){
        super.onStart();

        boolean muestra_estado;
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onStart));
            Toast.makeText(this, R.string.onStart, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        boolean muestra_estado;
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onRestart));
            Toast.makeText(this, R.string.onRestart, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        boolean muestra_estado;
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onResume));
            Toast.makeText(this, R.string.onResume, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        boolean muestra_estado;
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onPause));
            Toast.makeText(this, R.string.onPause, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        boolean muestra_estado;
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onStop));
            Toast.makeText(this, R.string.onStop, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        boolean muestra_estado;
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onDestroy));
            Toast.makeText(this, R.string.onDestroy, Toast.LENGTH_SHORT).show();
        }
    }

}
