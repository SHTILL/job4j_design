package ru.job4j.lsp;

public class Device {
    private boolean isBurned;

    void connect(SocketEuro socket) {
        if (socket.voltage() > 220.0) {
            isBurned = true;
        }
    }

    public boolean isBurned() {
        return isBurned;
    }

    public void setBurned(boolean burned) {
        isBurned = burned;
    }
}
