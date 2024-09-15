package br.com.fiap.solutech.dto.investment;

import jakarta.validation.constraints.Size;

import java.util.List;

public record InvestmentUpdateDto(

        @Size(max = 100, min = 3, message = "The minimum name size is 3 and the maximum is 100!")
        String name,

        @Size(max = 150, min = 15, message = "The minimum mail size is 15 and the maximum is 150!")
        String type,

        Double value,

        Long agencyId,

        List<Long> usersId

) {
}
