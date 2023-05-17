package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public MealTo create(MealTo mealTo, int userId) {
        Meal meal = MealsUtil.create(mealTo);
        return MealsUtil.createTo(repository.save(meal, userId), false);
    }

    public void delete(int mealId, int userId) {
        checkNotFoundWithId(repository.delete(mealId, userId), mealId);
    }

    public MealTo get(int mealId, int userId) {
        return MealsUtil.createTo(checkNotFoundWithId(repository.get(mealId, userId), mealId), false);
    }

    public List<MealTo> getAll(int userId) {
        return MealsUtil.getTos(repository.getAll(userId), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public void update(MealTo mealTo, int userId) {
        Meal meal = MealsUtil.create(mealTo);
        checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }
}