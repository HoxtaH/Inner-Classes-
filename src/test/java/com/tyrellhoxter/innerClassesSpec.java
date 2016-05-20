package com.tyrellhoxter;

import com.tyrellhoxter.com.tyrellhoxter.Connection;
import com.tyrellhoxter.com.tyrellhoxter.ConnectionManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by tyrellhoxter on 5/20/16.
 */
public class innerClassesSpec {
    ConnectionManager connectionManager = new ConnectionManager(3);

    @Test
    public void getConnectionTest() {
        assertNotNull(connectionManager.getConnectionObjects("10101010110","FTP"));
    }

    @Test
    public void getConnectionFailedTest(){
        assertNull(connectionManager.getConnectionObjects("101010101", "DNCP"));
    }

    @Test
    public void connectionCounterTest(){
        ConnectionManager theNewConnection = new ConnectionManager(2);
        theNewConnection.getConnectionObjects("101010101", "PPP");
        int expectedCounter = 2;
        theNewConnection.getConnectionObjects("110101010", "TLS");
        int actualCounter = theNewConnection.connectionCounter;
        assertEquals("The connection counter should be 2", expectedCounter, actualCounter);
    }

    @Test
    public void connectionLimitTest(){
        ConnectionManager wuTangConnection = new ConnectionManager(4);
        int expectedConnectionLimit = 4;
        int actualConnectionLimit = wuTangConnection.connectionLimit;
        assertEquals("The connection limit should be 4", expectedConnectionLimit, actualConnectionLimit);
    }

    @Test
    public void defaultConnectionsNullTest(){
        assertNotNull(connectionManager.defaultConnectionObject("11001010", "javaSpring"));
    }

    @Test
    public void defaultConnectionsTest(){
        ConnectionManager wuTangConnection = new ConnectionManager(0);
        assertNull(wuTangConnection.defaultConnectionObject("1010101", "Slavers Bay")) ;
    }

    @Test
    public void connectTest(){
        ConnectionManager wuTangConnection = new ConnectionManager(3);
        Connection theChambersOf36 = wuTangConnection.getConnectionObjects("10101011", "PPP");
        String expectedConnect = "Connected";
        String actualConnect = theChambersOf36.connect();
        assertEquals("The expected should be connected", expectedConnect, actualConnect);
    }

    @Test
    public void closedConnectionTest(){
        ConnectionManager wuTangConnection = new ConnectionManager(36);
        Connection theChambersOf36 = wuTangConnection.getConnectionObjects("1010101", "PPP");
        String expectedConnect = "Connection Closed";
        String actualConnect = theChambersOf36.close();
        assertEquals("The expected connection should be closed", expectedConnect, actualConnect);
    }

}
