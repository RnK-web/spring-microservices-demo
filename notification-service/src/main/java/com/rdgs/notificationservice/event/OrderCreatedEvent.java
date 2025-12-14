package com.rdgs.notificationservice.event;

public record OrderCreatedEvent(String orderId, String email) {
}
