package com.qexz.chapter04.item03;

import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 程序清单4-7 将线程安全委托给ConcurrentHashMap
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 16:23
 */
@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<String, Point>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

//    public Map<String, Point> getLocations() {
//        return unmodifiableMap;
//    }

    public Map<String, Point> getLocations() {
        return Collections.unmodifiableMap(new HashMap<String, Point>(locations));
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null)
            throw new IllegalArgumentException("invalid vehicle name: " + id);
    }
}
