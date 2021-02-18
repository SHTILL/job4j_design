package ru.job4j.lsp;

public class DeviceUSA extends Device {
    @Override
    void connect(SocketEuro socket) {
        if (socket.voltage() > 120.0) {
            setBurned(true);
        }
    }
}
