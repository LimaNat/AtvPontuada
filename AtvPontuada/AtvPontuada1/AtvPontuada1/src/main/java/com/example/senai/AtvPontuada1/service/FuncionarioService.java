package com.example.senai.AtvPontuada1.service;
import com.example.senai.AtvPontuada1.exception.EmailCadastrado;
import jakarta.validation.Valid;
import com.example.senai.AtvPontuada1.model.Funcionario;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.example.senai.AtvPontuada1.repository.FuncionarioRepository;

import java.util.List;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> ListarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario) {
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new EmailCadastrado("Funcionario ja cadastrado.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario) {
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado."));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setSalario(funcionario.getSalario());

        return funcionarioRepository.save(funcionarioAtualizar);
    }

    public void excluir(Long id) {
        Funcionario funcionarioExcluir = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado."));

        funcionarioRepository.delete(funcionarioExcluir);
    }
}