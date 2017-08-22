package com.bstek.demo.dao;

import java.util.Collection;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.model.DefaultPosition;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.demo.model.DemoUser;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
//ͨ����context.xmlע�������dao��Ҳ����ͨ������ǩ(����Ҫɨ��õ�)
@Repository
public class HibernateDaoTest extends HibernateDao {
		
	
	@DataResolver
	public void save(Collection<DemoUser> users){
		//�ȴ�session
		Session openSession = this.getSessionFactory().openSession();
		try{
			for(DemoUser user :users){
				//EntityUtils.getState(product)������ȡ����ʵ����������еĲ���״̬
				EntityState state = EntityUtils.getState(user);
				if(EntityState.NEW.equals(state)){
					openSession.save(user);
				}else if(EntityState.MODIFIED.equals(state)){
					openSession.update(user);
				}else if(EntityState.DELETED.equals(state)){
					openSession.delete(user);
				}
			}
		}finally{
			openSession.flush();
			openSession.close();
		}
	}
	//�������Ĳ�ѯ
	@DataProvider
	public Collection<DefaultPosition> query1(){
	    return this.query("from "+DemoUser.class.getName());
	}
	
}
