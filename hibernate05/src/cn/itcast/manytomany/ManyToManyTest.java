package cn.itcast.manytomany;

import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

public class ManyToManyTest {
	@Test
	public void test() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		//��������ѧ��
		Student s1=new Student();
		s1.setName("����");
		Student s2=new Student();
		s2.setName("��˹");
		//����������Ŀ
		Course c1=new Course();
		c1.setName("JAVA");
		Course c2=new Course();
		c2.setName("PHP");
		//����������ϵ��ѧ��������Ŀ
	    s1.getCourse().add(c1);
	    s1.getCourse().add(c2);
	    s2.getCourse().add(c1);
	    s2.getCourse().add(c2);
	    //�洢
	    session.save(c1);
	    session.save(c2);
	    session.save(s1);
	    session.save(s2);
	    
		session.beginTransaction().commit();
		session.close();
	}
	

}
