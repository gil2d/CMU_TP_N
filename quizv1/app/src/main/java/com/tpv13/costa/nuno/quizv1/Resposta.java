package com.tpv13.costa.nuno.quizv1;

/**
 * Created by Nuno on 02-12-2016.
 */

public class Resposta {

    private int id;
    private int perguntaID;
    private String descricao;
    private boolean correta;

    public Resposta(int _id, int _perguntaId, String _descricao, boolean _correta)
    {
        this.setId(_id);
        this.setPerguntaID(_perguntaId);
        this.setDescricao(_descricao);
        this.setCorreta(_correta);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerguntaID() {
        return perguntaID;
    }

    public void setPerguntaID(int perguntaID) {
        this.perguntaID = perguntaID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}
