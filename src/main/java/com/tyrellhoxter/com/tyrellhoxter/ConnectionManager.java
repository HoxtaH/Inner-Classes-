package com.tyrellhoxter.com.tyrellhoxter;

/**
 * Created by tyrellhoxter on 5/20/16.
 */
//Factory
public class ConnectionManager {
    public int connectionCounter;
    public int connectionLimit;

    public ConnectionManager(int limit) {
        connectionLimit = limit;

    }

    //CarMaker
    public ManagedConnection getConnectionObjects(String ip, String protocol) {
        if (protocol.toUpperCase().equals("FTP") || protocol.toUpperCase().equals("TLS") || protocol.toUpperCase().equals("PPP") && connectionLimit > connectionCounter) {
            connectionCounter++;
            return new ManagedConnection(ip, "8080", protocol);

        } else {
            System.out.println("Not A Proper Connection... ERROR");
            return null;
        }
    }

    public ManagedConnection defaultConnectionObject(String ip, String port) {
        if (connectionLimit > connectionCounter) {
            connectionCounter++;
            return new ManagedConnection(ip, port, "HTTP");
        } else {
            System.out.println("To many cooks");
            return null;
        }
    }

    //BluePrintForCar
    private class ManagedConnection implements Connection {
        public String Ip;
        public String port;
        public String protocol;

        //Car
        ManagedConnection(String Ip, String port, String protocol) {
            this.Ip = Ip;
            this.port = port;
            this.protocol = protocol;
        }

        //SteeringWheel
        public String connect() {
            if(Ip.equals("closed")){
                return "Connections Closed";
            }
            return "Connected";
        }

        //Wheels
        public String getIp() {
            return Ip;
        }

        //Rims
        public String getPort() {
            return port;
        }

        //airConditioner
        public String getProtocol() {
            return protocol;
        }

        public String close(){
            Ip = "closed";
            port = "closed";
            protocol = "closed";
            connectionCounter--;
            return "Connection Closed";
        }
    }
}
