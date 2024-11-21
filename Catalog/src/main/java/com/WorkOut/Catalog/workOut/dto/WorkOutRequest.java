package com.WorkOut.Catalog.workOut.dto;

import java.math.BigDecimal;

public record WorkOutRequest(String description,
                             Integer trainingDuration,
                             BigDecimal price) {
}
