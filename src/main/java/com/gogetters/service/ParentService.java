package com.gogetters.service;

import com.gogetters.database.Database;
import com.gogetters.entity.BaseEntity;
import com.gogetters.entity.Parent;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.gogetters.database.Database.parentList;

public class ParentService implements CRUDService<Parent> {

    @Override
    public Parent findById(int id) {
        return parentList.stream().filter(p -> p.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Parent with id#" + id + " not found"));
    }

    @Override
    public List<Parent> findAll() {
        return parentList;
    }

    @Override
    public void save(Parent parent) {
        parentList.add(parent);
    }

    @Override
    public void update(Parent parent) {
        if (parentList.stream().anyMatch(p -> p.getId() == parent.getId())) {
        parentList.stream()
                .filter(p -> p.getId() == parent.id)
                .forEach(p -> parentList.set(parentList.indexOf(p), parent));
        } else {
            throw new RuntimeException("Parent with id#" + parent.getId() + " not found!");
        }

//        parentList.stream()
//                .filter(p -> p.getId() == parent.id)
//                .forEach(p -> parentList.set(parentList.indexOf(p), parent));

    }

    @Override
    public void deleteById(Long id) {

        if (parentList.stream().anyMatch(p -> p.getId() == id)) {
            parentList.removeIf(parent -> parent.getId() == id);
        } else {
            throw new RuntimeException("Parent with id#" + id + " not found!");
        }
        //        parentList.removeIf(parent -> parent.getId() == id);

    }
}
