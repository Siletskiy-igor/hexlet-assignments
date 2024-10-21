package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private Connection connection;
    String ip;
    int port;

    public TcpConnection(String ip, int port) {
        this.connection = new Disconnected(this);
        this.ip = ip;
        this.port = port;
    }

    public String getCurrentState() {
        return this.connection.getCurrentState();
    }

    public void connect() {
        connection.connect();
    }

    public void disconnect() {
        connection.disconnect();

    }

    public void write(String text) {
        connection.write(text);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
// END
