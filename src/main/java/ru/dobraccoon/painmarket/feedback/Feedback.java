package ru.dobraccoon.painmarket.feedback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Feedback {
    @Setter
    private Long id;
    private long customerId;
    private long productId;
    private LocalDateTime creationDt;
    private String caption;
    private String feedbackText;
    private int rating;
}
