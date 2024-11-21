package com.WorkOut.Review.review;

import com.WorkOut.Review.review.client.WorkOutClient;
import com.WorkOut.Review.review.client.WorkOutDTO;
import com.WorkOut.Review.review.dto.ReviewRequest;
import com.WorkOut.Review.review.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final WorkOutClient workOutClient;

    public void createReview(ReviewRequest reviewRequest){
        WorkOutDTO work = workOutClient.getWorkOutById(reviewRequest.workOutId());

        if(work == null){
            throw new RuntimeException("Work Out with id " + reviewRequest.workOutId() + " not found");

        }
        Review review = Review.builder()
                .comment(reviewRequest.comment())
                .datePosted(reviewRequest.datePosted())
                .rating(reviewRequest.rating())
                .workOutId(reviewRequest.workOutId())
                .build();
        reviewRepository.save(review);
        log.info("Work out with id {} is saved", review.getId());
    }

    public List<ReviewResponse> getAllReview(){
        List<Review> reviews = reviewRepository.findAll();
        return  reviews.stream().map(this::mapToReviewResponse).toList();
    }
    private ReviewResponse mapToReviewResponse(Review review){
        return new ReviewResponse(review.getId(), review.getComment(), review.getDatePosted(), review.getRating(), review.getWorkOutId());
    }
}
