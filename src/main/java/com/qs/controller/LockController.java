package com.qs.controller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockController {
    public static void main(String[] args) {
        ABCD abcd = new ABCD();
        new Thread(() -> {
            for(int i = 0; i < 5; i++){
                abcd.a();
            }
        }, "a").start();
        new Thread(() -> {
            for(int i = 0; i < 5; i++){
                abcd.b();
            }
        }, "b").start();
        new Thread(() -> {
            for(int i = 0; i < 5; i++){
                abcd.c();
            }
        }, "c").start();
        new Thread(() -> {
            for(int i = 0; i < 5; i++){
                abcd.d();
            }
        }, "d").start();
    }
}
class ABCD {
    int flag = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();
    public void a() {
        lock.lock();
        try {
            while(flag != 1){
                condition1.await();
            }
            System.out.println("aaa" + Thread.currentThread().getName());
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void b() {
        lock.lock();
        try {
            while(flag != 2){
                condition2.await();
            }
            System.out.println("bbb" + Thread.currentThread().getName());
            flag = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void c() {
        lock.lock();
        try {
            while(flag != 3){
                condition3.await();
            }
            System.out.println("ccc" + Thread.currentThread().getName());
            flag = 4;
            condition4.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void d() {
        lock.lock();
        try {
            while(flag != 4) {
                condition4.await();
            }
            System.out.println("ddd" + Thread.currentThread().getName());
            flag = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
