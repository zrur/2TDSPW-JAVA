package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.LivroRequest;
import br.com.fiap.api_rest.dto.LivroResponse;
import br.com.fiap.api_rest.model.Livro;
import br.com.fiap.api_rest.repository.LivroRepository;
import br.com.fiap.api_rest.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
impo

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroService livroService;
    // CREATE, READ, UPDATE, DELETE
    // POST, GET, PUT, DELETE

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody LivroRequest livro) {
        Livro livroSalvo = livroRepository.save(livroService.requestToLivro(livro));
        return new ResponseEntity<>(livroSalvo,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> readLivros() {
        List<Livro> livros = livroRepository.findAll();
        List<LivroResponse> listalivros = new ArrayList<>();
        for (Livro livro : livros ){
            listalivros.add(livroService.livroToResponse(livro));
        }
        return new ResponseEntity<>(livros,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> readLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(livro.get(),HttpStatus.OK);
    }

    @PutMapping{"/{id}"}
    public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro,@PathVariable long id) {
      Optional<Livro> Livro livroExistente = livroRepository.findById(id);
      if (livroExistente.isEmpty()){
          return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
      }
      livro.setId(livroExistente.get().getId());
      Livro livroSalvo = livroRepository.save(livro);
        return new ResponseEntity<>(livroSalvo,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
