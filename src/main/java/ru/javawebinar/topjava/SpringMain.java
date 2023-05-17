package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.web.user.AdminRestController;
import ru.javawebinar.topjava.web.user.MealRestController;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management (ARM)
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ADMIN));
            MealRestController mrc = appCtx.getBean(MealRestController.class);
            mrc.get(1, 1);
            mrc.create(new MealTo(null, LocalDateTime.now(), "lolo", 2000, false), 1);
            System.out.println(mrc.getAll(1));
        }
    }
}
