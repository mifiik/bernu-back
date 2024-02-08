package ru.dobraccoon.painmarket.feedback;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("feedback")
public class FeedbackController {
    FeedbackService feedbackService;

    @PostMapping
    public Feedback create(@RequestBody Feedback newFeedback) {
        return feedbackService.create(newFeedback);
    }

    @GetMapping("/load-by-productId/{productId}")
    public List<Feedback> loadByProductId(@PathVariable long productId) {
        return feedbackService.loadByProductId(productId);
    }
}
