package io.github.gabrielsnamaro.Sandbox.service;

import io.github.gabrielsnamaro.Sandbox.model.dto.CadastroTodoDto;
import io.github.gabrielsnamaro.Sandbox.model.dto.ResultadoPesquisaTodoDto;
import io.github.gabrielsnamaro.Sandbox.exception.RecursoNaoEncontradoException;
import io.github.gabrielsnamaro.Sandbox.mapper.TodoMapper;
import io.github.gabrielsnamaro.Sandbox.model.TodoEntity;
import io.github.gabrielsnamaro.Sandbox.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;
    private final TodoMapper mapper;

    public TodoEntity salvar(CadastroTodoDto dto) {
        TodoEntity entidade = mapper.paraEntidade(dto);

        repository.save(entidade);

        return entidade;
    }

    public ResultadoPesquisaTodoDto buscarPorId(UUID id) throws RecursoNaoEncontradoException {
        return repository
                .findById(id)
                .map(mapper::paraResultadoPesquisaDto)
                .orElseThrow(() -> new RecursoNaoEncontradoException("'Todo' não encontrado para o id " + id + ". "));
    }
}
