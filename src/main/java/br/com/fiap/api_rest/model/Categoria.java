package br.com.fiap.api_rest.model;

public enum Categoria {
    ROMANCE("ROMANCE"),
    FICCAO("ROMANCE"),
    FANTASIA("FANTASIA");
    //valores padronizados
    private String descricao;

    Categoria(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
