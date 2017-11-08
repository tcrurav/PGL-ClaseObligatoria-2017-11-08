package com.example.tiburcio.coches;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tiburcio on 08/11/2017.
 */

public class LlamadaREST extends AsyncTask<Void, Void, Coche> {
    MainActivity actividad;
    public LlamadaREST(MainActivity actividad){
        this.actividad = actividad;
    }

    @Override
    protected Coche doInBackground(Void... voids) {
        Coche coche = AccesoREST.getCoche();
        return coche;
    }

    @Override
    protected void onPostExecute(Coche coche) {
        super.onPostExecute(coche);
        actividad.mostrarCoche(coche);
    }
}
