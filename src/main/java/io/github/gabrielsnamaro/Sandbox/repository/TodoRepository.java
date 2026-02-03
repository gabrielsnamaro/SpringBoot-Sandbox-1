package io.github.gabrielsnamaro.Sandbox.repository;

import io.github.gabrielsnamaro.Sandbox.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {
    @Query("""
        SELECT t FROM TodoEntity t WHERE
            ((LOWER(t.nome) LIKE CONCAT('%', LOWER(?1), '%')) OR ?1 IS NULL)    
    """)
    List<TodoEntity> pesquisar(String nome);
}
