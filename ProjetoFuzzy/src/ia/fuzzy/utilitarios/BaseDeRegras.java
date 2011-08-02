/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.utilitarios;

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
        for(int i=0; i< SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++){
            if(temp == mTemperatura[i][0]){
                return true;
            }
        }
        return false;
    }
    private boolean TemperaturaMedia(double temp){
        for(int i=0; i< SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++){
            if(temp == mTemperatura[i][1]){
                return true;
            }
        }
        return false;
    }
    private boolean TemperaturaAlta(double temp){
        for(int i=0; i< SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++){
            if(temp == mTemperatura[i][2]){
                return true;
            }
        }
        return false;
    }
    private boolean VolumePequeno(double vol){
        for(int i=0; i< SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++){
            if(vol == mVolume[i][0]){
                return true;
            }
        }
        return false;
    }
    private boolean VolumeMedio(double vol){
        for(int i=0; i< SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++){
            if(vol == mVolume[i][1]){
                return true;
            }
        }
        return false;
    }
    private boolean VolumeGrande(double vol){
        for(int i=0; i< SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++){
            if(vol == mVolume[i][2]){
                return true;
            }
        }
        return false;
    }
}
