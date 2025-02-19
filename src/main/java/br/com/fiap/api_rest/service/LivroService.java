package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.LivroRequest;
import br.com.fiap.api_rest.dto.LivroRequestDTO;
import br.com.fiap.api_rest.dto.LivroResponse;
import br.com.fiap.api_rest.model.Livro;

public class LivroService {
    public Livro requestToLivro(LivroRequest livroRequest){
        Livro livro = new Livro();
        livro.setAutor(livroRequest.getAutor());
        livro.setTitulo(livroRequest.getTitulo());
        return livro;
    }
    public Livro recordToLivro(LivroRequestDTO livroRecord) {
     Livro livro = new Livro();
     livro.setTitulo(livroRecord.titulo());
     livro.setAutor(livroRecord.autor());
     return livro;

    }
    public LivroResponse livroToResponse(Livro livro){
        LivroResponse livroResponse = new LivroResponse(livro.getAutor() + " - " + livro.getTitulo());
    }
    public List<LivroResponse> LivrosToResponse(List<Livros> livros){
        List<LivroResponse> Listalivros = new ArrayList<>();
        for (Livros livro : livros){
            listaLivros.add(LivrosToResponse(Livro));
        }
        return listaLivros
    }
}
