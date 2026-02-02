package io.github.gabrielsnamaro.Sandbox.mapper;

import io.github.gabrielsnamaro.Sandbox.dto.CadastroTodoDto;
import io.github.gabrielsnamaro.Sandbox.model.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    CadastroTodoDto paraCadastroDto(TodoEntity entity);

    @Mapping(target = "id", ignore = true)
    TodoEntity paraEntidade(CadastroTodoDto dto);
}
