package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealDao {
    Meal save(Meal meal);
    boolean delete(int mealId);
    Collection<Meal> getAll();
    Meal get(int mealId);
}
