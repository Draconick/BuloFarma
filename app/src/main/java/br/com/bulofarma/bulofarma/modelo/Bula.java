package br.com.bulofarma.bulofarma.modelo;

/**
 * Created by Katrina on 24/05/2016.
 */
public class Bula {
    private String titulo;
    private String composicao;
    private String indicacoes;
    private String contraindicacoes;
    private String modoUsar;
    private String posologia;
    private String advertencias;
    private String efeitoColateral;
    private int favorito;

    public Bula(String titulo, String composicao, String indicacoes, String contraindicacoes, String modoUsar, String posologia, String advertencias, String efeitoColateral, int favorito) {
        this.titulo = titulo;
        this.composicao = composicao;
        this.indicacoes = indicacoes;
        this.contraindicacoes = contraindicacoes;
        this.modoUsar = modoUsar;
        this.posologia = posologia;
        this.advertencias = advertencias;
        this.efeitoColateral = efeitoColateral;
        this.favorito = favorito;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getEfeitoColateral() {
        return efeitoColateral;
    }

    public void setEfeitoColateral(String efeitoColateral) {
        this.efeitoColateral = efeitoColateral;
    }

    public String getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(String advertencias) {
        this.advertencias = advertencias;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public String getContraindicacoes() {
        return contraindicacoes;
    }

    public void setContraindicacoes(String contraindicacoes) {
        this.contraindicacoes = contraindicacoes;
    }

    public String getModoUsar() {
        return modoUsar;
    }

    public void setModoUsar(String modoUsar) {
        this.modoUsar = modoUsar;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

}
