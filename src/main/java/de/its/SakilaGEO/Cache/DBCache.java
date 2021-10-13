/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BackInBash
 */
public class DBCache {

    private final List<CacheObserver> observers;

    public DBCache() {
        observers = new ArrayList<>();
    }

    public void addObserver(CacheObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(CacheObserver obs) {
        observers.remove(obs);
    }

    public void notifyObservers() {
        for (var obs : observers) {
            obs.update();
        }
    }
}
