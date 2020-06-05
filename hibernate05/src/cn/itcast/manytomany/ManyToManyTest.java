package cn.itcast.manytomany;

import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

public class ManyToManyTest {
	@Test
	public void test() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		//创建两个学生
		Student s1=new Student();
		s1.setName("赫曼");
		Student s2=new Student();
		s2.setName("李斯");
		//创建两个科目
		Course c1=new Course();
		c1.setName("JAVA");
		Course c2=new Course();
		c2.setName("PHP");
		//建立关联关系，学生关联科目
	    s1.getCourse().add(c1);
	    s1.getCourse().add(c2);
	    s2.getCourse().add(c1);
	    s2.getCourse().add(c2);
	    //存储
	    session.save(c1);
	    session.save(c2);
	    session.save(s1);
	    session.save(s2);
	    
		session.beginTransaction().commit();
		session.close();
	}
	

}
