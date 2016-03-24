package com.mojaaplikacja.igor.shower39;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GorkiCel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorki_cel);

        Intent intent = getIntent();
    }

    public void zobaczGorkiMelgiewska(View view)
    {
        Intent przejscie = new Intent(this,MainGorkiToMelgiewska.class);
        startActivity(przejscie);
    }

    public void zobaczGorkiLipniak(View view)
    {
        Intent przejscie = new Intent(this,MainGorkiToLipniak.class);
        startActivity(przejscie);
    }
}
