package com.mojaaplikacja.igor.shower39;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PolitechnikaCel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politechnika_cel);
        Intent intent = getIntent();

    }

    public void zobaczPolitechnikaLipniak(View view)
    {
        Intent przejscie = new Intent(this,MainPolitechnikaToLipniak.class);
        startActivity(przejscie);
    }
}
