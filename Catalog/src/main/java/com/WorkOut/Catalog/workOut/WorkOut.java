package com.WorkOut.Catalog.workOut;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "workout")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WorkOut {
    @Id
    private String id;
    private String description;
    private Integer trainingDuration;
    private BigDecimal price;
}
