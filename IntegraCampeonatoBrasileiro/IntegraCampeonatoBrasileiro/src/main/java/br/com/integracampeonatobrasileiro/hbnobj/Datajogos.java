package br.com.integracampeonatobrasileiro.hbnobj;
// Generated 22/02/2018 16:55:34 by Hibernate Tools 4.3.1



/**
 * Datajogos generated by hbm2java
 */
public class Datajogos  implements java.io.Serializable {


     private DatajogosId id;
     private Jogoid jogoid;

    public Datajogos() {
    }

    public Datajogos(DatajogosId id, Jogoid jogoid) {
       this.id = id;
       this.jogoid = jogoid;
    }
   
    public DatajogosId getId() {
        return this.id;
    }
    
    public void setId(DatajogosId id) {
        this.id = id;
    }
    public Jogoid getJogoid() {
        return this.jogoid;
    }
    
    public void setJogoid(Jogoid jogoid) {
        this.jogoid = jogoid;
    }




}


