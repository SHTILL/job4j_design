package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class SocketEuro {
    public double voltage() {
        return 220.0;
    }

    public static void main(String[] args) {
        SocketEuro socket = new SocketEuro();
        List<Device> devices = new ArrayList<>();
        devices.add(new Device());
        devices.add(new DeviceUSA());
        devices.add(new Device());

        for (Device d: devices) {
            d.connect(socket);
        }

        int burnedDevices = 0;
        for (Device d: devices) {
            if (d.isBurned()) {
                burnedDevices++;
            }
        }

        if (burnedDevices != 0) {
            System.out.print("Some devices are burned!!! LSP is violated!!!");
        }
    }
}
