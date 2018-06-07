package com.qexz.chapter10.item01;

import com.qexz.chapter04.item03.Point;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * 程序清单10-6 通过公开调用来避免在相互协作的对象之间产生死锁
 * @author zzqnxx@foxmail.com
 * @date 2018/6/3 0:00
 */
class CooperatingNoDeadlock {
    @ThreadSafe
    class Taxi {
        @GuardedBy("this") private Point location, destination;
        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation() {
            return location;
        }

        public synchronized void setLocation(Point location) {
            boolean reachedDestination;
            synchronized (this) {
                this.location = location;
                reachedDestination = location.equals(destination);
            }
            if (reachedDestination)
                dispatcher.notifyAvailable(this);
        }

        public synchronized Point getDestination() {
            return destination;
        }

        public synchronized void setDestination(Point destination) {
            this.destination = destination;
        }
    }

    @ThreadSafe
    class Dispatcher {
        @GuardedBy("this") private final Set<Taxi> taxis;
        @GuardedBy("this") private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            taxis = new HashSet<Taxi>();
            availableTaxis = new HashSet<Taxi>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }

        public Image getImage() {
            Set<Taxi> copy;
            synchronized (this) {
                copy = new HashSet<Taxi>(taxis);
            }
            Image image = new Image();
            for (Taxi t : copy)
                image.drawMarker(t.getLocation());
            return image;
        }
    }

    class Image {
        public void drawMarker(Point p) {
        }
    }

}
