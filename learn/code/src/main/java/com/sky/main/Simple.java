package com.sky.main;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;


public class Simple implements Watcher {

    private CountDownLatch connectedSignal = new CountDownLatch(1);


    @Override
    public void process(WatchedEvent watchedEvent) {

        if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {

            // 鏈接成功才會調用
            connectedSignal.countDown();

            System.out.println("事件类型为：" + watchedEvent.getType());
            System.out.println("事件发生的路径：" + watchedEvent.getPath());
            System.out.println("通知状态为：" + watchedEvent.getState());

        }

    }


    public void createNode() throws Exception {

        ZooKeeper zookeeper = new ZooKeeper("192.168.0.12:2181", 20000, this);

        connectedSignal.await();

        zookeeper.create("/data2", "Hello world".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zookeeper.close();

    }

    public void getNode() throws Exception {

        ZooKeeper zookeeper = new ZooKeeper("192.168.0.12:2181", 20000, this);

        connectedSignal.await();

        System.out.println(new String(zookeeper.getData("/data2", false, null)));

        zookeeper.close();

    }


    public static void main(String[] args) throws Exception {

        Simple simple = new Simple();

        simple.getNode();

    }

}