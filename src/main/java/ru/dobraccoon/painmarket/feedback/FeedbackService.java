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

    public void deleteById(long id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback loadById(long feedbackId) {
        return feedbackRepository.loadById(feedbackId);
    }

    public List<Feedback> loadByProductId(long productId) {
        return feedbackRepository.loadByProductId(productId);
    }
}
