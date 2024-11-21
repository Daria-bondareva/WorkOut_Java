package com.WorkOut.Review;

import org.springframework.boot.SpringApplication;

public class TestReviewApplication {

	public static void main(String[] args) {
		SpringApplication.from(ReviewApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
