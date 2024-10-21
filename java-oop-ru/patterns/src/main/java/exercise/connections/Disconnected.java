package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {

    TcpConnection connection;

    public Disconnected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        this.connection.setConnection(new Connected(connection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error");

    }

    @Override
    public void write(String text) {
        System.out.println("Error");
    }
}
// END
