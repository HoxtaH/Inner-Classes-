package com.tyrellhoxter.com.tyrellhoxter;

/**
 * Created by tyrellhoxter on 5/20/16.
 */
public interface Connection {
    public String connect();
    public String getIp();
    public String getPort();
    public String getProtocol();
    public String close();

}
