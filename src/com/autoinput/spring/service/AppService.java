package com.autoinput.spring.service;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autoinput.hibernate.objects.Agreement;
import com.autoinput.hibernate.objects.City;
import com.autoinput.hibernate.objects.Club;
import com.autoinput.hibernate.objects.Competition;
import com.autoinput.hibernate.objects.Continent;
import com.autoinput.hibernate.objects.Nation;
import com.autoinput.hibernate.objects.Player;
import com.autoinput.hibernate.objects.Stadium;
import com.autoinput.hibernate.util.HibernateUtil;
 
@Component
public class AppService {
	
    private SessionFactory sessionFactory;
 
    public SessionFactory getSessionFactory() {
    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveContinent(Continent continent) {
        Session session = sessionFactory.getCurrentSession();
        session.save(continent);
    }

    @Transactional
    public void saveNation(Nation nation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(nation);
    }

    @Transactional
    public void deleteAgreement(Agreement agreement) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(agreement);
    }

    @Transactional
    public void deleteCity(City city) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(city);
    }

    @Transactional
    public void deleteClub(Club club) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(club);
    }

    @Transactional
    public void deleteContinent(Continent continent) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(continent);
    }

    @Transactional
    public void deleteNation(Nation nation) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(nation);
    }

    @Transactional
    public void deletePlayer(Player player) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(player);
    }

    @Transactional
    public void deleteStadium(Stadium stadium) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(stadium);
    }

    @Transactional
    public void deleteCompetition(Competition competition) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(competition);
    }

    @Transactional
    public void removeNations() {
        Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("delete from Nation").executeUpdate();
	}

    @Transactional
	public void removeContinents() {
        Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("delete from Continent").executeUpdate();
	}

    @Transactional
	public void removeAgreements() {
        Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("delete from Agreement").executeUpdate();
	}

    @Transactional
	public void removeCities() {
        Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("delete from City").executeUpdate();
	}

    @Transactional
	public void removeClubs() {
        Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("delete from Club").executeUpdate();
	}

    @Transactional
	public void removeStadiums() {
        Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("delete from Stadium").executeUpdate();
	}

    @Transactional
	public void removeCompetitions() {
        Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("delete from Competition").executeUpdate();
	}

    @Transactional
	public void writeCompetitionData(List<Competition> competitions, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeCompetitions();
		}
        Session session = sessionFactory.getCurrentSession();
		for(Competition competition : competitions) {
			competition.setDateAdded(new Date());
			competition.setNameId(competition.getThreeLetterName() + "_" + competition.getName());
			session.save(competition);
		}
	}

    @Transactional
	public void writeStadiumData(List<Stadium> stadiums, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeStadiums();
		}
        Session session = sessionFactory.getCurrentSession();
		for(Stadium stadium : stadiums) {
			stadium.setDateAdded(new Date());
			stadium.setNameId(stadium.getName() + "_" + stadium.getCity());
			session.save(stadium);
		}
	}

    @Transactional
	public void writeClubData(List<Club> clubs, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeClubs();
		}
        Session session = sessionFactory.getCurrentSession();
		for(Club club : clubs) {
			club.setDateAdded(new Date());
			club.setNameId(club.getName() + "_" + club.getNation());
			session.save(club);
		}
	}

    @Transactional
	public void writeCityData(List<City> cities, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeCities();
		}
        Session session = sessionFactory.getCurrentSession();
		for(City city : cities) {
			city.setDateAdded(new Date());
			city.setNameId(city.getName() + "_" + city.getNation());
			session.save(city);
		}
	}

    @Transactional
	public void writeAgreementData(List<Agreement> agreements, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeAgreements();
		}
        Session session = sessionFactory.getCurrentSession();
		for(Agreement agreement : agreements) {
			agreement.setDateAdded(new Date());
			agreement.setNameId(agreement.getName());
			session.save(agreement);
		}
	}

    @Transactional
	public void writeContinentData(List<Continent> continents, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeContinents();
		}
        Session session = sessionFactory.getCurrentSession();
		for(Continent continent : continents) {
			continent.setDateAdded(new Date());
			continent.setNameId(continent.getThreeLetterName() + "_" + continent.getName());
			session.save(continent);
		}
	}

    @Transactional
	public void writeNationData(List<Nation> nations, boolean removeAllOthers) {
		if(removeAllOthers) {
			removeNations();
		}
        Session session = sessionFactory.getCurrentSession();
		for(Nation nation : nations) {
			nation.setDateAdded(new Date());
			nation.setNameId(nation.getThreeLetterName() + "_" + nation.getName());
			session.save(nation);
		}
	}

    @Transactional
    public void updateCity(City city) {
    	Session session = sessionFactory.getCurrentSession();
    	City mergedOne = (City) session.merge(city);
    	session.saveOrUpdate(mergedOne);
    }

    @Transactional
	public void clearOldContinents() {
        Session session = sessionFactory.getCurrentSession();
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