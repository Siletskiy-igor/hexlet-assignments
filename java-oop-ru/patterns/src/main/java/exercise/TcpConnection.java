package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection implements Connection {
    private String ip;
    private int port;
    private Connection connection;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    @Override
    public String getCurrentState() {
        return this.connection.getCurrentState();
    }

    @Override
    public void connect() {
        this.connection.connect();
    }

    @Override
    public void disconnect() {
        this.connection.disconnect();
    }

    @Override
    public void write(String str) {
        this.connection.write(str);
    }

    public void setState(Connection stateObject) {
        connection = stateObject;
    }
}
// END
