package com.WorkOut.Review.review.dto;

import java.time.LocalDateTime;

public record ReviewRequest(String comment,
                            LocalDateTime datePosted,
                            Integer rating,
                            String workOutId) {
}
