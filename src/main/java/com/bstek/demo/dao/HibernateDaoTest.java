package com.bstek.demo.dao;

import java.util.Collection;

import org.hibernate.classic.Session;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.demo.model.DemoUser;
import com.bstek.dorado.annotation.DataResolver;

public class HibernateDaoTest extends HibernateDao {
		
	
	@DataResolver
	public void saveDemoUser(Collection<DemoUser> users){
		Session openSession = this.getSessionFactory().openSession();
		try{
			for(DemoUser user :users){
				
			}
		}finally{
			openSession.flush();
			openSession.close();
		}
	}
}
