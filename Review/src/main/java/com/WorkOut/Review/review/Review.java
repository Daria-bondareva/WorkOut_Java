package com.WorkOut.Review.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "review")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Review {
    @Id
    private String id;
    private String comment;
    private LocalDateTime datePosted;
    private Integer rating;
    private String workOutId;
}
