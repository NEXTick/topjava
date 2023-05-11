package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDaoImpl implements MealDao{

    private static AtomicInteger counter = new AtomicInteger(0);

    public static final Map<Integer, Meal> meals = new ConcurrentHashMap<>();

    {
        MealsUtil.meals.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            meals.put(meal.getId(), meal);
            return meal;
        }
        return meals.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public boolean delete(int mealId) {
        return meals.remove(mealId) != null;
    }

    @Override
    public Collection<Meal> getAll() {
        return meals.values();
    }

    @Override
    public Meal get(int mealId) {
        return meals.get(mealId);
    }
}
