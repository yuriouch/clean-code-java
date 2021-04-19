package com.epam.engx.cleancode.naming;

public enum NotificationLevel {
    INFO_NOTIFICATION_LEVEL(4), CRITICAL_NOTIFICATION_LEVEL(1);

    private int level;

    NotificationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
