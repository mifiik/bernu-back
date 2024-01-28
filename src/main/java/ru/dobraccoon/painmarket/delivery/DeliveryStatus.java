package ru.dobraccoon.painmarket.delivery;

public enum DeliveryStatus {
    CREATED(1),
    DELIVERY(3),
    COMPLETED(3);

    private long statusId;

    DeliveryStatus(long id) {
        this.statusId = id;
    }

    public static DeliveryStatus getById(long statusId) {
        switch ((int) statusId) {
            case 1:
                return CREATED;
            case 2:
                return DELIVERY;
            case 3:
                return COMPLETED;
            default:
                try {
                    throw new IllegalAccessException();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
        }
    }

}

