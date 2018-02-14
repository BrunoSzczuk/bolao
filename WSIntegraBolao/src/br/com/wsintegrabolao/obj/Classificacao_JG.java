/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wsintegrabolao.obj;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author bruno.szczuk
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "classificacaojogo")
public class Classificacao_JG implements Serializable {

    @JsonProperty("total")
    @Column(name = "qt_total")
    private int total;

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "cd_equipe", referencedColumnName = "cd_equipe")
    private Equipe cdEquipe;

    @JsonProperty("mandante")
    @Column(name = "qt_mandante")
    private int mandante;

    @JsonProperty("visitante")
    @Column(name = "qt_visitante")
    private int visitante;

    public Classificacao_JG() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMandante() {
        return mandante;
    }

    public void setMandante(int mandante) {
        this.mandante = mandante;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.total;
        hash = 23 * hash + Objects.hashCode(this.cdEquipe);
        hash = 23 * hash + this.mandante;
        hash = 23 * hash + this.visitante;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Classificacao_JG other = (Classificacao_JG) obj;
        if (this.total != other.total) {
            return false;
        }
        if (!Objects.equals(this.cdEquipe, other.cdEquipe)) {
            return false;
        }
        if (this.mandante != other.mandante) {
            return false;
        }
        if (this.visitante != other.visitante) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Classificacao_JG{" + "total=" + total + ", mandante=" + mandante + ", visitante=" + visitante + '}';
    }

}
