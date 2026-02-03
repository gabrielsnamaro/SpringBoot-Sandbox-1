package io.github.gabrielsnamaro.Sandbox.exception.dto;

import java.util.List;

public record ErroResposta(int codigo,
                           String mensagem,
                           List<ErroCampo> erros) {
    public static ErroResposta recursoNaoEncontrado() {
        return new ErroResposta(404, "Recurso não encontrado.", List.of());
    }

    public static ErroResposta recursoNaoEncontrado(String mensagem) {
        return new ErroResposta(404, mensagem, List.of());
    }
}
