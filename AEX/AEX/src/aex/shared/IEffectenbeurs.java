/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Roy
 */
public interface IEffectenbeurs extends Remote {

    public IFonds[] getKoersen() throws RemoteException;
}
