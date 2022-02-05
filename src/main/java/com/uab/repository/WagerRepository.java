package com.uab.repository;

import com.uab.model.Wager;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WagerRepository {
    private List<Wager> database = new ArrayList<>();

    public void save(Wager wager) {
        database.add(wager);
    }

    public List<Wager> getAll() {
        return database;
    }
}
