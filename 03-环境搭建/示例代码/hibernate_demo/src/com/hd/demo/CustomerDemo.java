package com.hd.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import com.hd.domain.Customer;
public class CustomerDemo {
	@Test
	public void test(){
		// 加载数据库的核心配置文件 (引入映射文件)
				Configuration configuration = new Configuration();
				configuration.configure();
				// 手动加载映射文件
				//configuration.addResource("cn/itcast/domain/Customer.hbm.xml");
				// 获取sessionFactory  session工厂
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				// 获取session  相当于connection
				Session session = sessionFactory.openSession();
				// 开启事务 (小细节:hibernate对增删改(除了查询)一条sql语句 都得开事务手动提交一次，这个很不方便)
				Transaction tx = session.beginTransaction();
				// 操作 (存一条数据到cst_customer)
				Customer customer = new Customer();
				customer.setCust_name("rose");
				session.save(customer);
				// 提交
				tx.commit();
				// 关闭连接
				session.close();
				// 关闭连接池
				sessionFactory.close();
	}
}
