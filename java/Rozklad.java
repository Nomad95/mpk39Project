/**
 * Created by Igor on 2016-03-09.
 */
package com.mojaaplikacja.igor.shower39;

public class Rozklad
{
    private int godzina;
    private int minuta;

    public Rozklad(int godz,int min)
    {
        this.godzina=godz;
        this.minuta=min;
    }

    public String getGodzina()
    {
        String zwroc = Integer.toString(godzina);
        return zwroc;
    }

    public void setGodzina(int godz)
    {
        godzina=godz;
    }

    public String getMinuta()
    {
        String zwroc = Integer.toString(minuta);
        return zwroc;
    }

    public void setMinuta(int min)
    {
        minuta=min;
    }

    public int getMinutaInt()
    {

        return minuta;
    }

    public int getGodzinaInt()
    {

        return godzina;
    }
}
