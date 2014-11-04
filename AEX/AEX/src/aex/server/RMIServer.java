/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.server;

import aex.shared.IEffectenbeurs;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Roy
 */
public class RMIServer {

    private static final int portNumber = 1099;

    private static final String bindingName = "Effectenbeurs";

    public RMIServer(IEffectenbeurs e) {
        System.out.println("Server: Port number " + portNumber);

        if (e != null) {
            try {
                LocateRegistry.createRegistry(portNumber);
                Naming.rebind(bindingName, e);

            } catch (MalformedURLException ex) {
                System.out.println("Server: Cannot bind mock effectenbeurs");
                System.out.println("Server: MalformedURLException: " + ex.getMessage());
            } catch (RemoteException ex) {
                System.out.println("Server: Cannot bind mock effectenbeurs");
                System.out.println("Server: RemoteException: " + ex.getMessage());
            }
            System.out.println("Server: Mock effectenbeurs bound to " + bindingName);
        } else {
            System.out.println("Server: Mock effectenbeurs not bound");
        }
    }
    
    // Print IP addresses and network interfaces
    private static void printIPAddresses() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Server: IP Address: " + localhost.getHostAddress());
            // Just in case this host has multiple IP addresses....
            InetAddress[] allMyIps = InetAddress.getAllByName(localhost.getCanonicalHostName());
            if (allMyIps != null && allMyIps.length > 1) {
                System.out.println("Server: Full list of IP addresses:");
                for (InetAddress allMyIp : allMyIps) {
                    System.out.println("    " + allMyIp);
                }
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server: Cannot get IP address of local host");
            System.out.println("Server: UnknownHostException: " + ex.getMessage());
        }

        try {
            System.out.println("Server: Full list of network interfaces:");
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                System.out.println("    " + intf.getName() + " " + intf.getDisplayName());
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    System.out.println("        " + enumIpAddr.nextElement().toString());
                }
            }
        } catch (SocketException ex) {
            System.out.println("Server: Cannot retrieve network interface list");
            System.out.println("Server: UnknownHostException: " + ex.getMessage());
        }
    }

}
