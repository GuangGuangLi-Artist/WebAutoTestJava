package day27.InterfaceOriented.day27Dao.day27DaoImple;

import day27.InterfaceOriented.Day27Domain.Day27Student;
import day27.InterfaceOriented.day27Dao.Day27StudentDao;

public class Day27StudentImpl implements Day27StudentDao {
    @Override
    public void add(Day27Student day27Student) {
        System.out.println("Day27StudentImpl.add()");
    }

    @Override
    public void update(Day27Student day27Student) {
        System.out.println("Day27StudentImpl.update");

    }
}
