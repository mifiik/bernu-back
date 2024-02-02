package ru.dobraccoon.painmarket.feedback;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {
    private FeedbackRepository feedbackRepository;

    public Feedback create(Feedback newFeedback) {
        return feedbackRepository.create(newFeedback);
    }

    public List<Feedback> loadByProductId(long productId) {
        return feedbackRepository.loadByProductId(productId);
    }
}
