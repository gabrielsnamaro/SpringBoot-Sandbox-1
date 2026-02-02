package io.github.gabrielsnamaro.Sandbox.repository;

import io.github.gabrielsnamaro.Sandbox.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {
}
