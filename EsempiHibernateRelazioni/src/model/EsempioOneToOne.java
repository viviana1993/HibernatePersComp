package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtil.HibernateUtil;

public class EsempioOneToOne {

	public static void main(String[] args) {
		
		Computer c1=new Computer();
		c1.setModello("fff");
		Computer c2=new Computer();
		c2.setModello("hp");
		
		Persona p1=new Persona();
		
		p1.setNome("AAAAA");
		p1.setCognome("AAAAA");
		
		p1.addComputer(c1);//aggiungo computer a persona
		//p1.addComputer(c2);
		
		c1.addPersone(p1);//aggiungo persona a computer
		//c2.addPersona(p1);
		
		
		Session session=HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();//inizio transazione
		
			//lavori da fare
			//session.delete(u);//se voglio rimuovere,ma vale anche per le altre operazioni
			session.save(c1);
			session.save(c2);
			session.save(p1);
			
			tx.commit();//se la transazione è ok allora faccio commit
			//altrimenti catturo l'eccezione
		}catch(Exception ex){
			tx.rollback();//se nn va a buon fine torno indietro

		}finally{
			session.close();
		}
		
		
		
	}

}
