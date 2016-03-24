package com.mojaaplikacja.igor.shower39;


import java.io.IOException;
import java.io.InputStream;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class MainGorkiToMelgiewska extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gorki);

        Intent intent = getIntent();
        ArrayList<Rozklad> bierzacyRozklad;
        bierzacyRozklad=wczytajDane();

        TextView zaChwile = (TextView)findViewById(R.id.textView2);
        TextView testGodziny = (TextView)findViewById(R.id.textView5);
        TextView nastepny = (TextView)findViewById(R.id.textView4);

        Date data = new Date();
        testGodziny.setText(Integer.toString(data.getHours())+":"+Integer.toString(data.getMinutes()));
        zaChwile.setText(porownaj(data,bierzacyRozklad)+ " minut");
        nastepny.setText(porownajNastepny(data,bierzacyRozklad)+" minut");
    }

    public String porownaj(Date data,ArrayList<Rozklad> rozklad)
    {
        int godzina = data.getHours();
        int minuta = data.getMinutes();
        int ileDo;
        for(int i=0;i<rozklad.size();i++)
        {
            if(godzina>rozklad.get(i).getGodzinaInt())
                continue;
            else if (godzina<rozklad.get(i).getGodzinaInt())
            {
                ileDo=(60-minuta)+(60*(rozklad.get(i).getGodzinaInt()-godzina-1))+rozklad.get(i).getMinutaInt();  //jesli jest za 2 godziny?
                return Integer.toString(ileDo);
            }
            else if(minuta>rozklad.get(i).getMinutaInt())
                continue;
            else
            {
                ileDo=rozklad.get(i).getMinutaInt()-minuta;
                return Integer.toString(ileDo);
            }
        }
        return "Jutro";
    }

    public String porownajNastepny(Date data,ArrayList<Rozklad> rozklad)
    {
        int godzina = data.getHours();
        int minuta = data.getMinutes();
        int ileDo;
        for(int i=0;i<rozklad.size();i++)
        {
            if(i<rozklad.size()-1)
            {
                if (godzina > rozklad.get(i).getGodzinaInt())
                    continue;
                else if (godzina < rozklad.get(i).getGodzinaInt())
                {
                    ileDo = (60 - minuta) + (60 * (rozklad.get(i + 1).getGodzinaInt() - godzina - 1)) + rozklad.get(i + 1).getMinutaInt();  //jesli jest za 2 godziny?
                    return Integer.toString(ileDo);
                }
                else if (minuta > rozklad.get(i).getMinutaInt())
                    continue;
                else
                {
                    if (godzina == rozklad.get(i + 1).getGodzinaInt())
                        ileDo = rozklad.get(i + 1).getMinutaInt() - minuta;
                    else
                        ileDo = (60 - minuta) + rozklad.get(i + 1).getMinutaInt();
                    return Integer.toString(ileDo);
                }
            }
        }
        return "Jutro";
    }

    public InputStream otworzPlik()
    {
        InputStream otworzAsset = null;
        try {
            otworzAsset = getResources().getAssets().open("gorki.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return otworzAsset;
    }

    public ArrayList<Rozklad> wczytajDane()
    {
        String linijka;
        Scanner otworzonyAsset = new Scanner(otworzPlik());
        ArrayList<Rozklad> DajRozklad = new ArrayList<>();
        while(otworzonyAsset.hasNextLine())
        {
            linijka = otworzonyAsset.nextLine();

            DajRozklad.add(oddzielPrzecinek(linijka));
        }
        return DajRozklad;
    }

    public Rozklad oddzielPrzecinek(String linia)
    {
        String[] Linia2 = linia.split(",");
        Rozklad rozklad = new Rozklad(Integer.parseInt(Linia2[0]),Integer.parseInt(Linia2[1]));
        return rozklad;
    }



}
