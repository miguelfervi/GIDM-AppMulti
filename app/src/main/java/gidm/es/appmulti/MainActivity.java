package gidm.es.appmulti;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final boolean muestra_estados = false;
    SharedPreferences sharedpreferences;
    DrawerLayout drawerLayout;
    NavigationView navView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Obtenemos una referencia a los controles de la interfaz
        final Button boton_sensores = (Button)findViewById(R.id.button_sensores);
        //Implementamos el evento “click” del botón
        boton_sensores .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, SensoresActivity.class);
                startActivity(intent);
            }
        });

        final Button boton_estados = (Button)findViewById(R.id.button_estados);
        boton_estados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean muestra_estado;
                SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                muestra_estado = prefs.getBoolean("muestra_estados", true);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                if(muestra_estado==false){
                    editor.putBoolean("muestra_estados", true);
                    Toast.makeText(MainActivity.this,"Estados visibles",Toast.LENGTH_LONG).show();
                }
                else{
                    editor.putBoolean("muestra_estados", false);
                    Toast.makeText(MainActivity.this,"Estados ocultos",Toast.LENGTH_LONG).show();
                }

                editor.commit();

            }
        });

         drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);

        navView = (NavigationView)findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {


                boolean fragmentTransaction = false;
                SensoresFragment fragment = null;

                switch (item.getItemId()){
                    case R.id.sensores:
                        fragment= new SensoresFragment();
                        fragmentTransaction = true;
                        break;
                }
                return true;
            }
        });




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.op_sensor) {
            // Handle the camera action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
