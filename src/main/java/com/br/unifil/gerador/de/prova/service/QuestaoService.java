package com.br.unifil.gerador.de.prova.service;

import com.br.unifil.gerador.de.prova.model.Questao;
import com.br.unifil.gerador.de.prova.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by labinfo on 06/09/2018.
 */

@RestController
@RequestMapping("/questoes")
public class QuestaoService {

    @Autowired
    QuestaoRepository questaoRepository;

    /**
     * Recupera todas as questões.
     * @return
     */
    @GetMapping
    public List<Questao> getAllQuestoes() {
        return questaoRepository.findAll();
    }

    /**
     * Recupera uma questão pelo id.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Questao> getQuestao(@PathVariable("id") Long id) {
        return questaoRepository.findById(id);
    }

    /**
     * Salva a questão
     * @param questao
     * @return
     */
    @PostMapping
    public Questao saveQuestao(@RequestBody Questao questao) {
        return questaoRepository.save(questao);
    }

    /**
     * Atualiaza a questão
     * @param id
     * @param questao
     * @return
     */
    @PutMapping("/{id}")
    public Questao atualizaQuestao(@PathVariable("id") Long id, @RequestBody Questao questao) {
        return questaoRepository.save(questao);
    }

    /**
     * Deleta questão pelo id.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteQuestao(@PathVariable("id") Long id) {
        questaoRepository.deleteById(id);
    }

    //http://localhost:8080/questoes/categoria/Frontend?categoria=Frontend

    /**
     * Recupera todas as questões de acordo com a entrada que o professor deseja,
     * realizando um filtro com o tipo de categoria da questão
     * @param categoria
     * @return
     */
    @GetMapping("/categoria/{categoriaSelecionada}")
    public List<Questao> getQuestaoPorCategoria(@RequestParam(value = "categoria") String categoria) {
        return questaoRepository.findByCategoria(categoria);
    }

//    @GetMapping("/professor/{professorSelecionado}")
//    public List<Questao> getQuestoesDeProfessor(@RequestParam(value = "professor") String professor) {
//        return questaoRepository.findByProfessor(professor);
//    }

}
