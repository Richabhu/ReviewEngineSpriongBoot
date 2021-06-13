package com.spring.product.review.controller;

import com.spring.product.review.models.ProductReview;
import com.spring.product.review.responses.ProductReviewResponse;
import com.spring.product.review.responses.common.StatusResponse;
import com.spring.product.review.responses.common.enumeration.SuccessCodes;
import com.spring.product.review.services.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/review/")
public class ProductReviewController {

    @Autowired
    ProductReviewService productReviewService;

    protected ProductReviewResponse createResponse(ProductReview productReview) {
        ProductReviewResponse response = new ProductReviewResponse();
        response.setProductReview(productReview);
        return response;
    }

    @RequestMapping(
            value = {""},
            method = {RequestMethod.POST}
    )
    public ProductReviewResponse create(@RequestBody ProductReview input) throws Exception {

        ProductReviewResponse response = this.createResponse(null);

        ProductReview result = productReviewService.addReview(input);

        response = this.createResponse(result);
        response.setStatus(new StatusResponse(SuccessCodes.OK, 1));
        return response;

    }
}
