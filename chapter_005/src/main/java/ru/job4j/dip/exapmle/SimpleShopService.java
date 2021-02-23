package ru.job4j.dip.exapmle;

import java.util.*;

public class SimpleShopService {
    private HashMap<User, Set<Order>> serviceDB = new HashMap<>();

    public boolean createBucket(User user) {
        if (serviceDB.containsKey(user)) {
            return false;
        }
        serviceDB.put(user, new HashSet<>());
        return  true;
    }

    public boolean createOrder(User user, Order order) {
        Set<Order> orders = serviceDB.get(user);
        if (orders == null) {
            return false;
        }
        return orders.add(order);
    }

    public boolean addProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            return false;
        }
        return orderDB.get().add(product);
    }

    private Optional<Order> findOrder(User user, Order order) {
        return serviceDB.getOrDefault(user, Set.of()).stream()
                .filter(o -> o.getId() == order.getId())
                .findFirst();
    }

    public boolean removeProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            return false;
        }
        return orderDB.get().remove(product.getId());
    }

    public boolean removeOrder(User user, Order order) {
        Set<Order> orders = serviceDB.get(user);
        if (orders == null) {
            return false;
        }
        return orders.remove(order);
    }

    public Check payOrder(User user, Order order) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            System.out.println("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Invalid order");
        }
        if (orderDB.get().isPayed()) {
            System.out.println("Get error with "  + user + " " + order);
            throw new IllegalArgumentException("Already payed!");
        }
        orderDB.get().setPayed(true);
        return new Check((int) (System.currentTimeMillis() % 1000_000), "Payed: " + orderDB.get().getId());
    }

    public static void main(String[] args) {
        User u = new User(0, "Petya");
        SimpleShopService s = new SimpleShopService();
        if (s.createBucket(u)) {
            System.out.println("Bucket created");
        } else {
            System.out.println("Bucket is not created");
            return;
        }
        Order o = new Order();
        if (s.createOrder(u, o)) {
            System.out.println("Order created");
        } else {
            System.out.println("Order is not created");
        }
        Product p = new Product(1, "Cola");
        if (s.addProduct(u, o, p)) {
            System.out.println("Added");
        } else {
            System.out.println("Not added");
        }
    }
}
