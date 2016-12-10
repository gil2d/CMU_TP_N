package com.tpv13.costa.nuno.quizv1;

/**
 * Created by Nuno on 03-12-2016.
 */

public class Categoria {

    private int id;
    private String descricao;

    public Categoria(int _id, String _descricao){
        this.setId(_id);
        this.setDescricao(_descricao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
