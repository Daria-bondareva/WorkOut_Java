package com.WorkOut.Review.review;

import com.WorkOut.Review.review.dto.ReviewRequest;
import com.WorkOut.Review.review.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.createReview(reviewRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getAllReviews(){
        return reviewService.getAllReview();
    }
}
