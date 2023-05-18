package com.bpcha.core_banking_bpcha.domain.model.person;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Person {
    private Integer id;
    @Schema(example = "Jhon Doe")
    private String name;
    @Schema(example = "M/F")
    private String gender;
    @Schema(example = "100")
    private Integer age;
    @Schema(example = "12345678")
    private Integer documentId;
    @Schema(example = "Cll 1 2 3")
    private String address;
    @Schema(example = "571234567")
    private Integer phoneNumber;
}
