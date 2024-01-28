package ru.dobraccoon.painmarket.feedback;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {
    private FeedbackRepository feedbackRepository;

    public void create(Feedback feedback) {
        feedbackRepository.create(feedback);
    }

    public List<Feedback> loadByProductId(long productId) {
        return feedbackRepository.loadByProductId(productId);
    }
}
