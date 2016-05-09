package com.briup.ch01.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.briup.ch01.Clazz;
import com.briup.ch01.Student;

public class Test {
	public static void main(String[] args) {
		//1.创建配置对象 
		Configuration config = new Configuration();
		//2. 读取配置文件  src/hibernate.cfg.xml
		config.configure();
		//3. 创建连接工厂
		SessionFactory factory= config.buildSessionFactory();
		//4.创建会话
		Session session = factory.openSession();
		//5.开启事务
		Transaction tran = session.beginTransaction();
		//>1开班
		//Clazz clazz = new Clazz("网通", "天天向上");
		//session.save(clazz);
		//>2查询并且修改
		/*Query query = session.createQuery("from Clazz where name=?");
		query.setString(0, "三年一班");
		Clazz clazz = (Clazz)query.uniqueResult();
		if(clazz!=null){
			clazz.setName("冶金");
		}*/
		//>3学生报到
		//Student stu1 = new Student(null, "周鑫", 18, "四川");
		//session.save(stu1);
		
		//查询班级
		Clazz clazz = (Clazz) session.load(Clazz.class, 1L);
		/*
		//查询学生
		Query query = session.createQuery("from Student where name=?");
		query.setString(0, "周鑫");
		Student stu = (Student) query.uniqueResult();
		
		//分班
		stu.setClazz(clazz);*/
		/*
		Student stu2 = new Student(null, "汤龙", 19, "江西");
		//分班
		stu2.setClazz(clazz);
		session.save(stu2);
		*/
		
		//查找冶金班的学生的信息
		Query query = session.createQuery("from Student");
		//query.setString(0, "网通");
		List<Student> list = query.list();
		for(Student stu : list){
			System.out.println(stu.getName()+"今年"+stu.getAge()+"岁了，家在"+stu.getAddress()+",现在在"+stu.getClazz().getName()+",他班级的口号为"+stu.getClazz().getMessge());
		}
		
		
		
		
		
		//>1.添加学生
		//Student stu = new Student(null, "wood", 15, "山西");
		//session.save(stu);
		
		//>2.查询单个值
		//Student stu = (Student) session.load(Student.class, 2L);
		//System.out.println(stu);
		
		//>3.修改
		//Long id = 2L;
		//Student stu = (Student) session.load(Student.class, id);
		//stu.setName("赖瑞2");
		
		//>4.删除
		//Long id = 2L;
		//Student stu = (Student) session.load(Student.class, id);
		//session.delete(stu);
		
		//>5.hql查询
		//String hql = "from Student where age > ?";
		//Query query = session.createQuery(hql);
		//query.setInteger(0, 13);
		//List<Student> stus = query.list();
		//for(Student s : stus){
		//	System.out.println(s);
		//}
		
		//>6.qbc查询
		//创建模板
		/*Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.lt("age", 18));
		criteria.add(Restrictions.gt("id", 2L));
		criteria.add(Restrictions.like("name", "%i%"));
		List<Student> stus = criteria.list();
		for(Student s : stus){
			System.out.println(s);
		}*/
		//6.事务提交
		tran.commit();
		//7.会话结束
		session.close();
		System.out.println("----");
	}
}
