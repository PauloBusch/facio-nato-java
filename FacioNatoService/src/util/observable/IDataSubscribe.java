/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.observable;

import java.util.List;

/**
 *
 * @author paulo
 */
public interface IDataSubscribe<Type> {
    IDataSubscription subscribe(IDataPromisse<Type> promisse);
}
