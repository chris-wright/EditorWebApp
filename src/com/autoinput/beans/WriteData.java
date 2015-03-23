package com.autoinput.beans;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.autoinput.hibernate.objects.Agreement;
import com.autoinput.hibernate.objects.City;
import com.autoinput.hibernate.objects.Club;
import com.autoinput.hibernate.objects.Competition;
import com.autoinput.hibernate.objects.Continent;
import com.autoinput.hibernate.objects.Nation;
import com.autoinput.hibernate.objects.Stadium;
import com.autoinput.hibernate.util.HibernateUtil;

public class WriteData {

	public static void removeNations() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createSQLQuery("delete from Nation").executeUpdate();
		session.close();
	}

	public static void removeContinents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createSQLQuery("delete from Continent").executeUpdate();
		session.close();
	}

	public static void removeAgreements() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createSQLQuery("delete from Agreement").executeUpdate();
		session.close();
	}

	public static void removeCities() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createSQLQuery("delete from City").executeUpdate();
		session.close();
	}

	public static void removeClubs() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createSQLQuery("delete from Club").executeUpdate();
		session.close();
	}

	public static void removeStadiums() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createSQLQuery("delete from Stadium").executeUpdate();
		session.close();
	}

	public static void removeCompetitions() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createSQLQuery("delete from Competition").executeUpdate();
		session.close();
	}
	

	public static void writeCompetitionData(List<Competition> competitions, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeCompetitions();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(Competition competition : competitions) {
			competition.setDateAdded(new Date());
			competition.setNameId(competition.getThreeLetterName() + "_" + competition.getName());
			session.save(competition);
		}
		if (!session.getTransaction().wasCommitted())
			session.getTransaction().commit();
		session.close();
	}
	

	public static void writeStadiumData(List<Stadium> stadiums, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeStadiums();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(Stadium stadium : stadiums) {
			stadium.setDateAdded(new Date());
			stadium.setNameId(stadium.getName() + "_" + stadium.getCity());
			session.save(stadium);
		}
		if (!session.getTransaction().wasCommitted())
			session.getTransaction().commit();
		session.close();
	}
	

	public static void writeClubData(List<Club> clubs, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeClubs();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(Club club : clubs) {
			club.setDateAdded(new Date());
			club.setNameId(club.getName() + "_" + club.getNation());
			session.save(club);
		}
		if (!session.getTransaction().wasCommitted())
			session.getTransaction().commit();
		session.close();
	}
	

	public static void writeCityData(List<City> cities, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeCities();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(City city : cities) {
			city.setDateAdded(new Date());
			city.setNameId(city.getName() + "_" + city.getNation());
			session.save(city);
		}
		if (!session.getTransaction().wasCommitted())
			session.getTransaction().commit();
		session.close();
	}
	

	public static void writeAgreementData(List<Agreement> agreements, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeAgreements();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(Agreement agreement : agreements) {
			agreement.setDateAdded(new Date());
			agreement.setNameId(agreement.getName());
			session.save(agreement);
		}
		if (!session.getTransaction().wasCommitted())
			session.getTransaction().commit();
		session.close();
	}

	public static void writeContinentData(List<Continent> continents, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeContinents();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(Continent continent : continents) {
			continent.setDateAdded(new Date());
			continent.setNameId(continent.getThreeLetterName() + "_" + continent.getName());
			session.save(continent);
		}
		if (!session.getTransaction().wasCommitted())
			session.getTransaction().commit();
		session.close();
	}

	public static void writeNationData(List<Nation> nations, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeNations();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(Nation nation : nations) {
			nation.setDateAdded(new Date());
			nation.setNameId(nation.getThreeLetterName() + "_" + nation.getName());
			session.save(nation);
		}
		if (!session.getTransaction().wasCommitted())
			session.getTransaction().commit();
		session.close();
	}

	public static void clearOldContinents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Continent> continents = session.createQuery("from Continent").list();
		for(Continent continent : continents) {
			Query contQuery = session.createQuery("from Continent cont where cont.nameId = :nameId order by cont.dateAdded desc");
			contQuery.setString("nameId", continent.getNameId());
			List<Continent> contsToRemove = contQuery.list();
			boolean del = false;
			for(Continent cont : contsToRemove) {
				if(del)
					session.delete(cont);
				del = true;
			}
		}
	}

}
