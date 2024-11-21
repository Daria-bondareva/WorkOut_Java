package com.WorkOut.Catalog.workOut.dto;

import java.math.BigDecimal;

public record WorkOutResponse(String id,
        String description,
        Integer trainingDuration,
        BigDecimal price) {
}
