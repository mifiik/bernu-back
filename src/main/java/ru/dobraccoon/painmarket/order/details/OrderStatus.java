package ru.dobraccoon.painmarket.order.details;

public enum OrderStatus {
    CREATED(1),
    IN_PROGRESS(2),
    COMPLETED(3);

    private final long statusId;

    OrderStatus(long statusId) {
        this.statusId = statusId;
    }

    public static OrderStatus getStatusNameById(long statusId) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.statusId == statusId) {
                return status;
            }
        }

        throw new IllegalStateException();
    }
}
