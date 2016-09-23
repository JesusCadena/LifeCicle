package com.example.alumnedam.lifecicle;

import android.annotation.TargetApi;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String txtHora;
    @TargetApi(Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificar("onCreate");
        Log.i("tag","onCreate");
    //Comprobamos que savedInstanceState es nulo esto pasa cuando se ejecuta la primera vez.
        if(savedInstanceState == null) {

            Calendar dataActual = Calendar.getInstance();
            int hora = dataActual.get(Calendar.HOUR_OF_DAY);
            int minut = dataActual.get(Calendar.MINUTE);
            int segon = dataActual.get(Calendar.SECOND);

            this.txtHora = "Hora " + hora + ";" + minut + ":" + segon;

        }else{

            this.txtHora = savedInstanceState.getString("hora");
        }
        TextView tvHora = (TextView) findViewById(R.id.tvHora);
        tvHora.setText(txtHora);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("hora", this.txtHora);

    }
//public MainActivity() {
      //  super();
        //Mostrar mensaje en el telefono
      //  Toast.makeText(this,"MainActivity",Toast.LENGTH_SHORT).show();
        //Mostrar mensaje en log
     //   Log.i("tag","MainActivity");
    //}

    @Override
    protected void onStop() {
        super.onStop();
        notificar("onStop");
        Log.i("tag","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notificar("onDestroy");
        Log.i("tag","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        notificar("onStart");
        Log.i("tag","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Mostrar mensaje en el telefono
        notificar("onPause");
        Log.i("tag","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notificar("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Mostrar mensaje en el telefono
        //Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
        //Mostrar mensaje en log
        //Log.i("tag","onRestart");
        notificar("onRestart");
    }

    public void notificar(String mensaje){
        //Mostrar mensaje en el telefono
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        //Mostrar mensaje en log
        Log.i("tag",mensaje);
    }
}
