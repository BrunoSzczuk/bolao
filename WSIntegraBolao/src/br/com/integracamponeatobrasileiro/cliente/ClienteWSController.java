/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.integracamponeatobrasileiro.cliente;

import br.com.integracamponeatobrasileiro.obj.Equipe;
import br.com.integracamponeatobrasileiro.obj.EquipeList;
import br.com.integracamponeatobrasileiro.obj.Fase;
import br.com.integracamponeatobrasileiro.obj.FaseList;
import br.com.integracamponeatobrasileiro.obj.Jogo_id;
import br.com.integracamponeatobrasileiro.obj.JogoList;
import br.com.integracamponeatobrasileiro.obj.JogoPK;
import br.com.integracamponeatobrasileiro.obj.Jogo_data;
import br.com.integracamponeatobrasileiro.obj.Jogo_dataPK;
import br.com.integracamponeatobrasileiro.obj.Jogo_rodada;
import br.com.integracamponeatobrasileiro.obj.Jogo_rodadaPK;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author bruno.szczuk
 */
public class ClienteWSController {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Collection<Equipe> buscaEquipe(String json) {
        ArrayList<Equipe> equipes = new ArrayList<>();
        try {
            EquipeList lista = mapper.readValue(json, EquipeList.class);
            equipes = new ArrayList<>(lista.getEquipe().values());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipes;
    }

    public static Collection<Jogo_id> buscaJogo(String json) {
        ArrayList<Jogo_id> jogos = new ArrayList<>();
        try {
            JogoList lista = mapper.readValue(json, JogoList.class);
            jogos = new ArrayList<>(lista.getJogo().values());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jogos;
    }

    public static Collection<Fase> buscaFase(String json) {
        ArrayList<Fase> fases = new ArrayList<>();
        try {
            FaseList lista = mapper.readValue(json, FaseList.class);
            fases = new ArrayList<>(lista.getFase().values());
            //Pegar o ID do Jogo_ID
            for (Object key : fases.get(0).getJogos().getJogo().keySet()) {
                fases.get(0).getJogos().getJogo().get(key).setId(new JogoPK((int) key));
            }
            //Pegar a data do Jogo_data
            for (Object key : fases.get(0).getJogos().getData().keySet()) {
                for (Jogo_data j : fases.get(0).getJogos().getData().get(key)) {
                    j.setPk(new Jogo_dataPK(j.getPk().getEquipe(), (Date) key));
                }
            }
            //Pegar a rodada do Jogo_rodada
            for (Object key : fases.get(0).getJogos().getRodada().keySet()) {
                for (Jogo_rodada r : fases.get(0).getJogos().getRodada().get(key)) {
                    r.setPk(new Jogo_rodadaPK(r.getPk().getJogo(), (int) key));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fases;
    }
}