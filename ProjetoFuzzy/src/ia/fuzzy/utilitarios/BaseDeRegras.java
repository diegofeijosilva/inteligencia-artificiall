/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.utilitarios;

import ia.fuzzy.ConjuntoFuzzy;
import ia.fuzzy.SistemaFuzzy;


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

    public BaseDeRegras(double[][] mInferenciaTemperatura, double[][] mInferenciaVolume, double temp, double volume){
        this.mTemperatura = mInferenciaTemperatura;
        this.mVolume = mInferenciaVolume;
        this.temp = temp;
        this.volume = volume;
    }

    public boolean regra1(){
        if(TemperaturaBaixa(temp) && VolumePequeno(volume)){
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra2(){
        if(TemperaturaMedia(temp) && VolumePequeno(volume)){
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra3(){
        if(TemperaturaAlta(temp) && VolumePequeno(volume)){
            return true; //ou seja, pressão é media
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra4(){
        if(TemperaturaBaixa(temp) && VolumeMedio(volume)){
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra5(){
        if(TemperaturaMedia(temp) && VolumeMedio(volume)){
            return true; //ou seja, pressão é media
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra6(){
        if(TemperaturaAlta(temp) && VolumeMedio(volume)){
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }
    public boolean regra7(){
        if(TemperaturaBaixa(temp) && VolumeGrande(volume)){
            return true; //ou seja, pressão é meida
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra8(){
        if(TemperaturaMedia(temp) && VolumeGrande(volume)){
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }
    public boolean regra9(){
        if(TemperaturaAlta(temp) && VolumeGrande(volume)){
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
            return true;
        }
        return false;
    }
}
