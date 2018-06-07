package com.qexz.chapter04.item02;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * 程序清单4-2 通过封闭机制来确保线程安全
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 11:03
 */
@ThreadSafe
public class PersonSet {

    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {
    }
}
