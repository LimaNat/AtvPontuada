package com.example.senai.AtvPontuada1.controller;

import com.example.senai.AtvPontuada1.model.Funcionario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.senai.AtvPontuada1.service.FuncionarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController4 {
    private FuncionarioService funcionarioService;

    public FuncionarioController4(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.ListarTodos();
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Funcionario cadastrado com sucesso!"));
    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionario atualizado com sucesso."));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionario excluido com sucesso."));
    }


}
