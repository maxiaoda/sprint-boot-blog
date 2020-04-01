package hello.service;

import hello.entity.User;

import javax.inject.Inject;

public class OrderService {

    private UserService userService;

    @Inject
    public OrderService(UserService userService) {
        this.userService = userService;
    }

    public User placeOrder(Integer userId, String item) {
        return userService.getUserById(userId);
    }
}
