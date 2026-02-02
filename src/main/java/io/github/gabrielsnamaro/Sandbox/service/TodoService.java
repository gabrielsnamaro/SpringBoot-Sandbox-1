package io.github.gabrielsnamaro.Sandbox.service;

import io.github.gabrielsnamaro.Sandbox.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;
}
