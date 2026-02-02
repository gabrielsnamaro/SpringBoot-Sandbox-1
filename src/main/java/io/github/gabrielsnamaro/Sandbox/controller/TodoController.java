package io.github.gabrielsnamaro.Sandbox.controller;

import io.github.gabrielsnamaro.Sandbox.dto.CadastroTodoDto;
import io.github.gabrielsnamaro.Sandbox.model.TodoEntity;
import io.github.gabrielsnamaro.Sandbox.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("todo")
public class TodoController {
    private final TodoService service;

    @PostMapping
    public ResponseEntity<Object> salvar(CadastroTodoDto dto) {
        TodoEntity entidadeSalva = service.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entidadeSalva.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
