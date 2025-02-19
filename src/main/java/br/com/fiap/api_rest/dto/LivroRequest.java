package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import jakarta.validation.constraints.*;

public class LivroRequest {
    @NotBlank( message = "O TITULO NAO PODE SER NULO OU VAZIO" )
    @Size(min = 3, max =254, message = "O TITLO DEBE TER ENTRE 3 E 254" )
    @NotBlank( message = "O TITULO NAO PODE SER NULO OU VAZIO" )
    @Size(min = 3, max = 150, message = "O TITLO DEBE TER ENTRE 3 E 150" )
    private String autor;
    @Min(value = 1, message ="O preco deve ser no minimo 1")
    @Min(value = 99, message ="O preco deve ser no maximo 99")
    private int preco;
    @NotNull(message = "A categoria é obrigatoria")
    private Categoria categoria;
    @Pattern( regexp = "(^970\\d{7}$)|(^970\\d{10}$)\n" +"")
    private String isbn;

    private String titulo;
    private String autor;
    private int preco;
    private Categoria categoria;
    private  String isbn;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
