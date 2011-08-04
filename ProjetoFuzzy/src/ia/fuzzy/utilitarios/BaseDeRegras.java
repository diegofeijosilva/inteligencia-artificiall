/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.utilitarios;

import ia.fuzzy.ConjuntoFuzzy;


/**
 *
 * @author Larissa
 */
public class BaseDeRegras {

    private double[][] mTemperatura;
    private double[][] mVolume;
    private double temp;
    private double volume;
    private ConjuntoFuzzy conjunto;
    private double pertinenciaBaixa;
    private double pertinenciaMedia;
    private double pertinenciaAlta;
    
    private double alfaCorteTemperatura;
    private double alfaCorteVolume;

    public double[] valoresRegra1;
    public double[] valoresRegra2;
    public double[] valoresRegra3;
    public double[] valoresRegra4;
    public double[] valoresRegra5;
    public double[] valoresRegra6;
    public double[] valoresRegra7;
    public double[] valoresRegra8;
    public double[] valoresRegra9;


    public BaseDeRegras(double[][] mInferenciaTemperatura, double[][] mInferenciaVolume, double temp, double volume){
        this.mTemperatura = mInferenciaTemperatura;
        this.mVolume = mInferenciaVolume;
        this.temp = temp;
        this.volume = volume;
    }

    public boolean regra1(){
        if(TemperaturaBaixa(temp) && VolumePequeno(volume)){
            valoresRegra1 = new double[2];
            valoresRegra1[0] = getAlfaCorteTemperatura();
            valoresRegra1[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra2(){
        if(TemperaturaMedia(temp) && VolumePequeno(volume)){
            valoresRegra2 = new double[2];
            valoresRegra2[0] = getAlfaCorteTemperatura();
            valoresRegra2[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra3(){
        if(TemperaturaAlta(temp) && VolumePequeno(volume)){
            valoresRegra3 = new double[2];
            valoresRegra3[0] = getAlfaCorteTemperatura();
            valoresRegra3[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é media
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra4(){
        if(TemperaturaBaixa(temp) && VolumeMedio(volume)){
            valoresRegra4 = new double[2];
            valoresRegra4[0] = getAlfaCorteTemperatura();
            valoresRegra4[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra5(){
        if(TemperaturaMedia(temp) && VolumeMedio(volume)){
            valoresRegra5 = new double[2];
            valoresRegra5[0] = getAlfaCorteTemperatura();
            valoresRegra5[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é media
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra6(){
        if(TemperaturaAlta(temp) && VolumeMedio(volume)){
            valoresRegra6 = new double[2];
            valoresRegra6[0] = getAlfaCorteTemperatura();
            valoresRegra6[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }
    public boolean regra7(){
        if(TemperaturaBaixa(temp) && VolumeGrande(volume)){
            valoresRegra7 = new double[2];
            valoresRegra7[0] = getAlfaCorteTemperatura();
            valoresRegra7[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é media
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra8(){
        if(TemperaturaMedia(temp) && VolumeGrande(volume)){
            valoresRegra8 = new double[2];
            valoresRegra8[0] = getAlfaCorteTemperatura();
            valoresRegra8[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }
    public boolean regra9(){
        if(TemperaturaAlta(temp) && VolumeGrande(volume)){
            valoresRegra9 = new double[2];
            valoresRegra9[0] = getAlfaCorteTemperatura();
            valoresRegra9[1] = getAlfaCorteVolume();
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }

    private boolean TemperaturaBaixa(double temp){
        conjunto = new ConjuntoFuzzy("baixa", "trapezoidal", 0, 1000, 800, 900);
        pertinenciaBaixa = conjunto.pertinencia(temp);
        conjunto = new ConjuntoFuzzy("media", "triangular", 900, 1100, 1000, 0);
        pertinenciaMedia = conjunto.pertinencia(temp);
        conjunto = new ConjuntoFuzzy("alta", "trapezoidal", 1000, 0, 1100, 1200);
        pertinenciaAlta = conjunto.pertinencia(temp);

        if(pertinenciaBaixa >= pertinenciaMedia && pertinenciaBaixa >= pertinenciaAlta){
            setAlfaCorteTemperatura(pertinenciaBaixa);
            return true;
        }
        return false;
    }
    private boolean TemperaturaMedia(double temp){
        conjunto = new ConjuntoFuzzy("baixa", "trapezoidal", 0, 1000, 800, 900);
        pertinenciaBaixa = conjunto.pertinencia(temp);
        conjunto = new ConjuntoFuzzy("media", "triangular", 900, 1100, 1000, 0);
        pertinenciaMedia = conjunto.pertinencia(temp);
        conjunto = new ConjuntoFuzzy("alta", "trapezoidal", 1000, 0, 1100, 1200);
        pertinenciaAlta = conjunto.pertinencia(temp);

        if(pertinenciaMedia >= pertinenciaBaixa && pertinenciaMedia >= pertinenciaAlta){
            setAlfaCorteTemperatura(pertinenciaMedia);
            return true;
        }
        return false;
    }
    private boolean TemperaturaAlta(double temp){
        conjunto = new ConjuntoFuzzy("baixa", "trapezoidal", 0, 1000, 800, 900);
        pertinenciaBaixa = conjunto.pertinencia(temp);
        conjunto = new ConjuntoFuzzy("media", "triangular", 900, 1100, 1000, 0);
        pertinenciaMedia = conjunto.pertinencia(temp);
        conjunto = new ConjuntoFuzzy("alta", "trapezoidal", 1000, 0, 1100, 1200);
        pertinenciaAlta = conjunto.pertinencia(temp);

        if(pertinenciaAlta >= pertinenciaMedia && pertinenciaAlta >= pertinenciaBaixa){
            setAlfaCorteTemperatura(pertinenciaAlta);
            return true;
        }
        return false;
    }
    private boolean VolumePequeno(double vol){
        conjunto = new ConjuntoFuzzy("pequeno","trapezoidal", 0, 7, 2, 4.5);
        pertinenciaBaixa = conjunto.pertinencia(vol);
        conjunto = new ConjuntoFuzzy("medio", "triangular", 4.5, 9.5, 7, 0);
        pertinenciaMedia = conjunto.pertinencia(vol);
        conjunto = new ConjuntoFuzzy("grande","trapezoidal", 7, 0, 9.5, 12);
        pertinenciaAlta = conjunto.pertinencia(vol);

        if(pertinenciaBaixa >= pertinenciaMedia && pertinenciaBaixa >= pertinenciaAlta){
            setAlfaCorteVolume(pertinenciaBaixa);
            return true;
        }
        return false;
    }
    private boolean VolumeMedio(double vol){
        conjunto = new ConjuntoFuzzy("pequeno","trapezoidal", 0, 7, 2, 4.5);
        pertinenciaBaixa = conjunto.pertinencia(vol);
        conjunto = new ConjuntoFuzzy("medio", "triangular", 4.5, 9.5, 7, 0);
        pertinenciaMedia = conjunto.pertinencia(vol);
        conjunto = new ConjuntoFuzzy("grande","trapezoidal", 7, 0, 9.5, 12);
        pertinenciaAlta = conjunto.pertinencia(vol);

        if(pertinenciaMedia >= pertinenciaBaixa && pertinenciaMedia >= pertinenciaAlta){
            setAlfaCorteVolume(pertinenciaMedia);
            return true;
        }
        return false;
    }
    private boolean VolumeGrande(double vol){
        conjunto = new ConjuntoFuzzy("pequeno","trapezoidal", 0, 7, 2, 4.5);
        pertinenciaBaixa = conjunto.pertinencia(vol);
        conjunto = new ConjuntoFuzzy("medio", "triangular", 4.5, 9.5, 7, 0);
        pertinenciaMedia = conjunto.pertinencia(vol);
        conjunto = new ConjuntoFuzzy("grande","trapezoidal", 7, 0, 9.5, 12);
        pertinenciaAlta = conjunto.pertinencia(vol);

        if(pertinenciaAlta >= pertinenciaBaixa && pertinenciaAlta >= pertinenciaMedia){
            setAlfaCorteVolume(pertinenciaAlta);
            return true;
        }
        return false;
    }
    public double getAlfaCorteTemperatura() {
        return alfaCorteTemperatura;
    }

    public void setAlfaCorteTemperatura(double alfaCorteTemperatura) {
        this.alfaCorteTemperatura = alfaCorteTemperatura;
    }

    public double getAlfaCorteVolume() {
        return alfaCorteVolume;
    }

    public void setAlfaCorteVolume(double alfaCorteVolume) {
        this.alfaCorteVolume = alfaCorteVolume;
    }
}
