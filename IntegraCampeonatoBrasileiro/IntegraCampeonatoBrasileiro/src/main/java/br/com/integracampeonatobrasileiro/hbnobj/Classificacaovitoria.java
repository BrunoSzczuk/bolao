package br.com.integracampeonatobrasileiro.hbnobj;
// Generated 22/02/2018 16:55:34 by Hibernate Tools 4.3.1



/**
 * Classificacaovitoria generated by hbm2java
 */
public class Classificacaovitoria  implements java.io.Serializable {


     private String cdEquipe;
     private Equipe equipe;
     private Integer qtMandante;
     private Integer qtTotal;
     private Integer qtVisitante;

    public Classificacaovitoria() {
    }

	
    public Classificacaovitoria(Equipe equipe) {
        this.equipe = equipe;
    }
    public Classificacaovitoria(Equipe equipe, Integer qtMandante, Integer qtTotal, Integer qtVisitante) {
       this.equipe = equipe;
       this.qtMandante = qtMandante;
       this.qtTotal = qtTotal;
       this.qtVisitante = qtVisitante;
    }
   
    public String getCdEquipe() {
        return this.cdEquipe;
    }
    
    public void setCdEquipe(String cdEquipe) {
        this.cdEquipe = cdEquipe;
    }
    public Equipe getEquipe() {
        return this.equipe;
    }
    
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    public Integer getQtMandante() {
        return this.qtMandante;
    }
    
    public void setQtMandante(Integer qtMandante) {
        this.qtMandante = qtMandante;
    }
    public Integer getQtTotal() {
        return this.qtTotal;
    }
    
    public void setQtTotal(Integer qtTotal) {
        this.qtTotal = qtTotal;
    }
    public Integer getQtVisitante() {
        return this.qtVisitante;
    }
    
    public void setQtVisitante(Integer qtVisitante) {
        this.qtVisitante = qtVisitante;
    }




}


