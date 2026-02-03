package io.github.gabrielsnamaro.Sandbox.controller;

import io.github.gabrielsnamaro.Sandbox.model.dto.CadastroTodoDto;
import io.github.gabrielsnamaro.Sandbox.model.dto.ResultadoPesquisaTodoDto;
import io.github.gabrielsnamaro.Sandbox.model.TodoEntity;
import io.github.gabrielsnamaro.Sandbox.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("todo")
public class TodoController {
    private final TodoService service;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody CadastroTodoDto dto) {
        TodoEntity entidadeSalva = service.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entidadeSalva.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPesquisaTodoDto> buscarPorId(@PathVariable("id") String idString) {
        UUID id = UUID.fromString(idString);

        ResponseEntity<ResultadoPesquisaTodoDto> resposta;

        resposta = ResponseEntity.ok(service.buscarPorId(id));

        return resposta;
    }
}
