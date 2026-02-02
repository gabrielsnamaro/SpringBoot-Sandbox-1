package io.github.gabrielsnamaro.Sandbox.service;

import io.github.gabrielsnamaro.Sandbox.dto.CadastroTodoDto;
import io.github.gabrielsnamaro.Sandbox.mapper.TodoMapper;
import io.github.gabrielsnamaro.Sandbox.model.TodoEntity;
import io.github.gabrielsnamaro.Sandbox.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
