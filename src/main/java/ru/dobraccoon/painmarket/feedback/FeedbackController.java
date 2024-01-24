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
    public void create(@RequestBody Feedback feedback) {
        feedbackService.create(feedback);
    }

    @GetMapping("/load-by-ProductId/{productId}")
    public List<Feedback> loadByProductId(@PathVariable long productId) {
        return feedbackService.loadByProductId(productId);
    }
}
