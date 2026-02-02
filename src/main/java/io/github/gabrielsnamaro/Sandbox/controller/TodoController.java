package io.github.gabrielsnamaro.Sandbox.controller;

import io.github.gabrielsnamaro.Sandbox.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("todo")
public class TodoController {
    private final TodoService service;
}
