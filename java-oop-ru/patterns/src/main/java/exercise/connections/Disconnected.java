package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        tcpConnection.setState(new Connected(tcpConnection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error ! Try to disconnect when connection disconnected");
    }

    @Override
    public void write(String str) {
        System.out.println("Error ! Try to write to disconnected connection");
    }
}
// END
