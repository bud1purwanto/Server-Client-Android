package com.example.root.restserver_client;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Insert extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextName;
    private EditText editTextNIM;
    private EditText editTextTelepon;
    private EditText editTextAlamat;
    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextNIM = (EditText) findViewById(R.id.editTextNIM);
        editTextTelepon = (EditText) findViewById(R.id.editTextTelepon);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    private void addEmployee(){

        final String nama = editTextName.getText().toString().trim();
        final String nim = editTextNIM.getText().toString().trim();
        final String telepon = editTextTelepon.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Insert.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Insert.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_MHS_NAMA,nama);
                params.put(Konfigurasi.KEY_MHS_NIM,nim);
                params.put(Konfigurasi.KEY_MHS_TELEPON,telepon);
                params.put(Konfigurasi.KEY_MHS_ALAMAT,alamat);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_Insert, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
            startActivity(new Intent(this,MainActivity.class));
        }

        if(v == buttonView){
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
