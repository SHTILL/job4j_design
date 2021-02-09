package ru.job4j.gc.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class PhantomDemo {
    private static class MyPhantom extends PhantomReference<String> {
        private String name;

        public MyPhantom(String referent, ReferenceQueue<? super String> q, String name) {
            super(referent, q);
            this.name = name;
        }

        @Override
        public String get() {
            return name;
        }
    }

    private static class PhantomStorage {

        private ReferenceQueue<String> queue = new ReferenceQueue<>();

        private List<MyPhantom> phantoms = new LinkedList<>();

        public void add(String someData) {
            MyPhantom phantom = new MyPhantom(someData, queue, "my ref");
            phantoms.add(phantom);
        }

        public void utilizeResource() {
            for (ListIterator<MyPhantom> i = phantoms.listIterator(); i.hasNext();) {
                MyPhantom current = i.next();
                if (current != null && current.isEnqueued()) {
                    //System.out.println("Utilized " + current.get());
                    current.clear();
                    i.remove();
                }
            }
        }

        public void utilizeResourceCorrect() {
            Reference ref = null;
            while ((ref = queue.poll()) != null) {
                //System.out.println("Utilized " + ref.get());
                ref.clear();
                phantoms.remove(0);
            }
        }
    }

    private static void example1() throws InterruptedException {
        PhantomStorage storage = new PhantomStorage();
        String data = "123".repeat(1000);
        storage.add(data);
        data = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        storage.utilizeResource();
    }

    private static void example2() throws InterruptedException {
        PhantomStorage storage = new PhantomStorage();
        for (int i = 0; i < 100_000; i++) {
            String data = Integer.toString(i);
            storage.add(data);
            storage.utilizeResource();
            if (i % 1000 == 0) {
                System.out.println("*");
                System.gc();
            }
        }
        TimeUnit.SECONDS.sleep(3);
    }

    private static void example3() throws InterruptedException {
        PhantomStorage storage = new PhantomStorage();
        for (int i = 0; i < 100_000; i++) {
            String data = Integer.toString(i);
            storage.add(data);
            storage.utilizeResourceCorrect();
            if (i % 1000 == 0) {
                System.out.println("*");
                System.gc();
            }
        }
        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException {
        //example1();
        example2();
        //example3();
    }

}
