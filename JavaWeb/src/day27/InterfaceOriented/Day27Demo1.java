package day27.InterfaceOriented;


import cn.itcast.beanfactory.BeanFactory;
import day27.InterfaceOriented.Day27Domain.Day27Student;
import day27.InterfaceOriented.day27Dao.Day27StudentDao;
import day27.InterfaceOriented.day27Service.Day27StudentService;
import org.junit.Test;

/**
 * 面向接口编程
 * dao
 *  daoImpl
 * service
 *  serviceImpl
 */

public class Day27Demo1 {

    @Test
    public void fun1(){
        /**
         * 创建Bean工厂，创建时需要给出工厂指定配置文件
         * 从工厂中获取bean对象
         */
        BeanFactory beanFactory = new BeanFactory("beans.xml");
        Day27Student student1 = (Day27Student)beanFactory.getBean("stu1");
        Day27Student student2 = (Day27Student)beanFactory.getBean("stu2");
        System.out.println(student1 == student2);

    }

    @Test
    public void fun2(){
        /**
         * 创建Bean工厂，创建时需要给出工厂指定配置文件
         * 从工厂中获取bean对象
         */
        BeanFactory beanFactory = new BeanFactory("beans.xml");
        Day27Student student1 = (Day27Student)beanFactory.getBean("stu1");
        Day27Student student2 = (Day27Student)beanFactory.getBean("stu2");
        System.out.println(student1.getDay27Teacher() == student2.getDay27Teacher());

    }

    @Test
    public void fun3(){
        BeanFactory beanFactory = new BeanFactory("beans.xml");
        Day27StudentDao day27StudentDao = (Day27StudentDao) beanFactory.getBean("StuDao");
        day27StudentDao.add(null);
        day27StudentDao.update(null);
    }

    public void fun4(){
        BeanFactory beanFactory = new BeanFactory("beans.xml");
        Day27StudentService day27StudentService = (Day27StudentService) beanFactory.getBean("stuService");
        day27StudentService.login();
    }
}
