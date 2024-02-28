package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Equipamiento;
import entities.General;
import entities.Regimiento;
import entities.Soldado;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Requerimiento2JPA");
		EntityManager em = factory.createEntityManager();
		
		//OPERACIONES
		Equipamiento equip1 = new Equipamiento("pistola", "9mm", 1);
		Equipamiento equip2 = new Equipamiento("rifle", "ak", 1);
		Equipamiento equip3 = new Equipamiento("granada", "de mano", 1);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(equip1);
		em.persist(equip2);
		em.persist(equip3);
		
		Soldado soldado1 = new Soldado("Diego", "raso");
		Soldado soldado2 = new Soldado("Pablo", "raso");
		Soldado soldado3 = new Soldado("Jorge", "raso");
		em.persist(soldado1);
		em.persist(soldado2);
		em.persist(soldado3);
		
		General general1 = new General("Pepe", "mayor");
		List<Soldado> listSold1 = new ArrayList<>();
		listSold1.add(soldado1);
		listSold1.add(soldado2);
		general1.setSoldados(listSold1);
		General general2 = new General("Fran", "mayor");
		List<Soldado> listSold2 = new ArrayList<>();
		listSold2.add(soldado1);
		listSold2.add(soldado3);
		general1.setSoldados(listSold2);
		General general3 = new General("Jesús", "mayor");
		List<Soldado> listSold3 = new ArrayList<>();
		listSold3.add(soldado3);
		listSold3.add(soldado2);
		general1.setSoldados(listSold3);
		em.persist(general1);
		em.persist(general2);
		em.persist(general3);
		
		Regimiento reg1 = new Regimiento("Regimiento1", "Madrid");
		List<Soldado> listSold4 = new ArrayList<>();
		listSold4.add(soldado1);
		listSold4.add(soldado2);
		reg1.setSoldados(listSold4);
		Regimiento reg2 = new Regimiento("Regimiento2", "Barcelona");
		List<Soldado> listSold5 = new ArrayList<>();
		listSold5.add(soldado3);
		reg1.setSoldados(listSold5);
		Regimiento reg3 = new Regimiento("Regimiento3", "Valencia");
		em.persist(reg1);
		em.persist(reg2);
		em.persist(reg3);
		
		soldado1.setRegimiento(reg1);
		soldado2.setRegimiento(reg1);
		soldado3.setRegimiento(reg2);
		em.persist(soldado1);
		em.persist(soldado2);
		em.persist(soldado3);
		
		et.commit();
		em.close();
	}

}
