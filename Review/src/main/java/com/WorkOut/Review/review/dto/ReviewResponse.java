package com.WorkOut.Review.review.dto;

import java.time.LocalDateTime;

public record ReviewResponse(String id,
                             String comment,
                             LocalDateTime datePosted,
                             Integer rating,
                             String workOutId) {
}
