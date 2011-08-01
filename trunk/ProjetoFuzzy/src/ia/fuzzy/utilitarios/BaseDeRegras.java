/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.utilitarios;

/**
 *
 * @author Larissa
 */
public class BaseDeRegras {

    /*
Regra 1: Se (Temperatura é Baixa) e (Volume é Pequeno)
Então (Pressão é Baixa)
Regra 2: Se (Temperatura é Média) e (Volume é Pequeno)
Então (Pressão é Baixa)
Regra 3: Se (Temperatura é Alta) e (Volume é Pequeno)
Então (Pressão é Média)
Regra 4: Se (Temperatura é Baixa) e (Volume é Médio)
Então (Pressão é Baixa)
Regra 5: Se (Temperatura é Média) e (Volume é Médio)
Então (Pressão é Média)
Regra 6: Se (Temperatura é Alta) e (Volume é Médio)
Então (Pressão é Alta)
Regra 7: Se (Temperatura é Baixa) e (Volume é Grande)
Então (Pressão é Média)
Regra 8: Se (Temperatura é Média) e (Volume é Grande)
Então (Pressão é Alta)
Regra 9: Se (Temperatura é Alta) e (Volume é Grande)
Então (Pressão é Alta)
     */

    public boolean regra1(double temp, double volume){
        if(TemperaturaBaixa(temp) && VolumePequeno(volume)){
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra2(double temp, double volume){
        if(TemperaturaMedia(temp) && VolumePequeno(volume)){
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra3(double temp, double volume){
        if(TemperaturaAlta(temp) && VolumePequeno(volume)){
            return true; //ou seja, pressão é media
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra4(double temp, double volume){
        if(TemperaturaBaixa(temp) && VolumeMedio(volume)){
            return true; //ou seja, pressão é baixa
        }
        else{
            return false;//ou seja pressão nao é baixa
        }
    }
    public boolean regra5(double temp, double volume){
        if(TemperaturaMedia(temp) && VolumeMedio(volume)){
            return true; //ou seja, pressão é media
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra6(double temp, double volume){
        if(TemperaturaAlta(temp) && VolumeMedio(volume)){
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }
    public boolean regra7(double temp, double volume){
        if(TemperaturaBaixa(temp) && VolumeGrande(volume)){
            return true; //ou seja, pressão é meida
        }
        else{
            return false;//ou seja pressão nao é media
        }
    }
    public boolean regra8(double temp, double volume){
        if(TemperaturaMedia(temp) && VolumeGrande(volume)){
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }
    public boolean regra9(double temp, double volume){
        if(TemperaturaAlta(temp) && VolumeGrande(volume)){
            return true; //ou seja, pressão é alta
        }
        else{
            return false;//ou seja pressão nao é alta
        }
    }

   //falta fazer esses métodos abaixo
    private boolean TemperaturaBaixa(double temp){
        return false;
    }
    private boolean TemperaturaMedia(double tem){
        return false;
    }
    private boolean TemperaturaAlta(double tem){
        return false;
    }
    private boolean VolumePequeno(double vol){
        return false;
    }
    private boolean VolumeMedio(double vol){
        return false;
    }
    private boolean VolumeGrande(double vol){
        return false;
    }
}
