package ru.javawebinar.topjava.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.ValidationUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.List;

import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;
@Controller
public class MealRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MealService service;


    public MealRestController(MealService service) {
        this.service = service;
    }

    public MealTo get(int mealId, int userId) {
        log.info("get {}", mealId);
        return service.get(mealId, authUserId());
    }

    public List<MealTo> getAll(int userId) {
        log.info("getAll");
        return service.getAll(authUserId());
    }

    public MealTo create(MealTo meal, int userId) {
        log.info("create {}", meal);
        return service.create(meal, authUserId());
    }

    public void update(MealTo meal, int userId) {
        log.info("update {} with id={}", meal, meal.getId());
        service.update(meal, authUserId());
    }

    public void delete(int mealId, int userId) {
        log.info("delete {}", mealId);
        service.delete(mealId, authUserId());
    }
}
