package day27.InterfaceOriented.day27Service.day27ServiceImpl;

import day27.InterfaceOriented.day27Dao.Day27StudentDao;
import day27.InterfaceOriented.day27Service.Day27StudentService;

public class Day27StudentServiceImpl implements Day27StudentService {

    private Day27StudentDao day27StudentDao = null;
    //谁调用service方法，谁就需要先调用本方法，提供dao
    public void  setDay27StudentDao(Day27StudentDao day27StudentDao){
        this.day27StudentDao = day27StudentDao;
    }
    @Override
    public void login() {
        day27StudentDao.add(null);
        day27StudentDao.update(null);

    }
}
