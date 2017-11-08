package com.example.tiburcio.coches;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Tiburcio on 08/11/2017.
 */

public class AccesoREST {
    static final String ruta = "http://192.168.203.10:8080/Coches/webresources/coches";

    static Coche getCoche(){
        Coche coche = null;

        try {
            URL url = new URL(ruta);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String datos;

            while((datos = br.readLine()) != null){
                sb.append(datos);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            coche = new Coche(jsonObject.getString("marca"), jsonObject.getString("modelo"));

            return coche;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return coche;
    }
}
