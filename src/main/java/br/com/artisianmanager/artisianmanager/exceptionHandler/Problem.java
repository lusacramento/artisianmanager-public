package br.com.artisianmanager.artisianmanager.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<FieldProblem> fields;

    @AllArgsConstructor
    @Getter
    public static class FieldProblem {
        private String name;
        private String message;
    }
}
