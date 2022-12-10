/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e2p1_gerardocano;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author gcano
 */
public class MaquinaEstados {
    ArrayList <String> estados;
    ArrayList <String> estados_aceptacion = new ArrayList<>();
    ArrayList <String> aristas = new ArrayList<>();
    String estado_actual;

    public MaquinaEstados(String estados, String aristas) {
        this.estados=splitstr(estados,';');
        extractAcceptNodes();
        this.estados=splitstr(aristas,';');
        this.estado_actual = this.estados.get(0);
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public ArrayList<String> getEstados_aceptacion() {
        return estados_aceptacion;
    }

    public void setEstados_aceptacion(ArrayList<String> estados_aceptacion) {
        this.estados_aceptacion = estados_aceptacion;
    }

    public ArrayList<String> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<String> aristas) {
        this.aristas = aristas;
    }

    public String getEstado_actual() {
        return estado_actual;
    }

    public void setEstado_actual(String estado_actual) {
        this.estado_actual = estado_actual;
    }
    
    public ArrayList<String> splitstr(String str,char delim){
        String chara = Character.toString(delim);
        String [] array = str.split(chara);
        
         ArrayList<String> ret = new ArrayList(Arrays.asList(array));
        
        return ret;
    }
    public void extractAcceptNodes(){
        
        for (int i = 0; i < estados.size(); i++) {
            if(estados.get(i).contains(".")){
                estados_aceptacion.add(estados.get(i).substring(1));
                estados.set(i,estados.get(i).substring(1));
            }
        }
    }
    public String getArista(String str){
        for (int i = 0; i < aristas.size(); i++) {
            if (aristas.get(i).contains(str)) {
                return aristas.get(i);
            }
        }
        return "";
    }
    public String computestr(String comp){
    String salida="";
    estado_actual = estados.get(0);
        for (int i = 0; i <comp.length()-1; i++) {
            String ar = getArista(estado_actual+','+comp.charAt(i));
            if (!ar.equals("")) {
                estado_actual = ar.split(",")[2];
                salida+=ar.split(",")[0]+':'+ar.split(",")[1]+"->"+ar.split(",")[2] + '\n';
            }else{
                salida+="rechazada";
                return salida;
            }
        }if(estados_aceptacion.contains(estado_actual)){
            salida+="aceptada";
                return salida;
        }else{
                salida+="rechazada";
                return salida;
            }
        
    }
    
     
    
}
