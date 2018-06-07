package com.qexz.chapter11.item04;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 程序清单11-5 减少锁的持有时间
 * @author zzqnxx@foxmail.com
 * @date 2018/6/3 15:26
 */
@ThreadSafe
public class BetterAttributeStore {
    @GuardedBy("this")
    private final Map<String, String>
            attributes = new HashMap<String, String>();

    public boolean userLocationMatches(String name, String regexp) {
        String key = "users." + name + ".location";
        String location;
        synchronized (this) {
            location = attributes.get(key);
        }
        if (location == null)
            return false;
        else
            return Pattern.matches(regexp, location);
    }
}
