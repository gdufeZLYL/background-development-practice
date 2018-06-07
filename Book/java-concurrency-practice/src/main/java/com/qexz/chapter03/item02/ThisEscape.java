package com.qexz.chapter03.item02;

import java.util.EventListener;

/**
 * 程序清单3-7 隐式地使this引用逸出(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/5/27 23:12
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
