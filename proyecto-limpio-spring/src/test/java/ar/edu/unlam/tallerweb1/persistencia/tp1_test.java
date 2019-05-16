package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class tp1_test extends SpringTest {

	//2- Hacer con junit un test que busque todos los países de habla inglesa.
	@Test @Transactional @Rollback
	public void testQueBusqueTodosLosPaisesDeHablaInglesa() {
		Session session = getSession();

		Continente europa = new Continente();
		europa.setNombre("Europa");

		/////IRLANDA//////
		Pais irlanda = new Pais();
		irlanda.setContinente(europa);
		irlanda.setHabitantes((long) 4784000);
		irlanda.setIdioma("inglés");
		irlanda.setNombre("Irlanda");

		Ciudad dublin = new Ciudad();
		dublin.setNombre("Dublin");
		dublin.setPais(irlanda);

		irlanda.setCapital(dublin);

		Ubicacion ugeoDublin = new Ubicacion();
		ugeoDublin.setLatitud(53.3330612);
		ugeoDublin.setLongitud(-6.2488899);

		dublin.setUgeo(ugeoDublin);

		session.save(dublin);
		session.save(irlanda);

		/////REINO UNIDO//////
		Pais reinoUnido = new Pais();
		reinoUnido.setContinente(europa);
		reinoUnido.setHabitantes((long) 63040000);
		reinoUnido.setIdioma("inglés");
		reinoUnido.setNombre("Reino Unido");

		Ciudad londres = new Ciudad();
		londres.setNombre("Londres");
		londres.setPais(reinoUnido);

		reinoUnido.setCapital(londres);

		Ubicacion ugeoLondres = new Ubicacion();
		ugeoLondres.setLatitud(51.5072);
		ugeoLondres.setLongitud(0.1275);

		londres.setUgeo(ugeoLondres);

		session.save(londres);
		session.save(reinoUnido);

		/////JAPON//////
		Continente asia = new Continente();
		asia.setNombre("Asia");

		Pais japon = new Pais();
		japon.setContinente(asia);
		japon.setHabitantes((long) 126800000);
		japon.setIdioma("japonés");
		japon.setNombre("Japón");

		Ciudad tokio = new Ciudad();
		tokio.setNombre("Tokio");
		tokio.setPais(japon);

		japon.setCapital(tokio);

		Ubicacion ugeoTokio = new Ubicacion();
		ugeoTokio.setLatitud(35.6895);
		ugeoTokio.setLongitud(139.6917);

		tokio.setUgeo(ugeoTokio);

		session.save(tokio);
		session.save(tokio);


		List<Pais> lista = getSession().createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "inglés"))
				.list();
		assertThat(lista).hasSize(2);
	}

	//3- Hacer con junit un test que busque todos los países del continente europeo.
	@Test @Transactional @Rollback
	public void testQueBusqueTodosLosPaisesDeEuropa() {
		Session session = getSession();

		Continente europa = new Continente();
		europa.setNombre("Europa");

		/////IRLANDA//////
		Pais irlanda = new Pais();
		irlanda.setContinente(europa);
		irlanda.setHabitantes((long) 4784000);
		irlanda.setIdioma("inglés");
		irlanda.setNombre("Irlanda");

		Ciudad dublin = new Ciudad();
		dublin.setNombre("Dublin");
		dublin.setPais(irlanda);

		irlanda.setCapital(dublin);

		Ubicacion ugeoDublin= new Ubicacion();
		ugeoDublin.setLatitud(53.3330612);
		ugeoDublin.setLongitud(-6.2488899);

		dublin.setUgeo(ugeoDublin);

		session.save(dublin);
		session.save(irlanda);

		/////REINO UNIDO//////
		Pais reinoUnido = new Pais();
		reinoUnido.setContinente(europa);
		reinoUnido.setHabitantes((long) 63040000);
		reinoUnido.setIdioma("inglés");
		reinoUnido.setNombre("Reino Unido");

		Ciudad londres = new Ciudad();
		londres.setNombre("Londres");
		londres.setPais(reinoUnido);

		reinoUnido.setCapital(londres);

		Ubicacion ugeoLondres= new Ubicacion();
		ugeoLondres.setLatitud(51.5072);
		ugeoLondres.setLongitud(0.1275);

		londres.setUgeo(ugeoLondres);

		session.save(londres);
		session.save(reinoUnido);

		/////JAPON//////
		Continente asia = new Continente();
		asia.setNombre("Asia");

		Pais japon = new Pais();
		japon.setContinente(asia);
		japon.setHabitantes((long) 126800000);
		japon.setIdioma("japonés");
		japon.setNombre("Japón");

		Ciudad tokio = new Ciudad();
		tokio.setNombre("Tokio");
		tokio.setPais(japon);

		japon.setCapital(tokio);

		Ubicacion ugeoTokio = new Ubicacion();
		ugeoTokio.setLatitud(35.6895);
		ugeoTokio.setLongitud(139.6917);

		tokio.setUgeo(ugeoTokio);

		session.save(tokio);
		session.save(japon);

		List<Pais> lista = getSession().createCriteria(Pais.class)
				.createAlias("continente", "con")
				.add(Restrictions.eq("con.nombre", "Europa"))
				.list();
		assertThat(lista).hasSize(2);
	}

	//4- Hacer con junit un test que busque todos los países cuya capital están al norte del trópico de cáncer.

	@Test @Transactional @Rollback
	public void testQueBuscoPaisesCapitalNorteCancer(){

		Session session = getSession();

		//continentes
		Continente America = new Continente();
		America.setNombre("America");
		session.save(America);

		Continente Europa = new Continente();
		Europa.setNombre("Europa");
		session.save(Europa);


		//paises
		Pais Argentina = new Pais();
		Argentina.setHabitantes( (long) 40000000);
		Argentina.setNombre("Argentina");
		Argentina.setIdioma("español");
		Argentina.setContinente(America);

		Pais Inglaterra = new Pais();
		Inglaterra.setNombre("Inglaterra");
		Inglaterra.setIdioma("ingles");
		Inglaterra.setHabitantes( (long)5000000);
		Inglaterra.setContinente(Europa);

		Pais Holanda = new Pais();
		Holanda.setNombre("Holanda");
		Holanda.setHabitantes( (long) 17200000);
		Holanda.setIdioma("holandes");
		Holanda.setContinente(Europa);	

		//ubicaciones
		Ubicacion ubicacionBsAs = new Ubicacion();
		ubicacionBsAs.setLatitud(-34.6083);
		ubicacionBsAs.setLongitud(-58.3712);


		Ubicacion ubicacionLondres = new Ubicacion();
		ubicacionLondres.setLatitud(51.5072);
		ubicacionLondres.setLongitud(-0.1275);

		Ubicacion ubicacionAms = new Ubicacion();
		ubicacionAms.setLatitud(52.3738);
		ubicacionAms.setLongitud(4.89093);

		//ciudades
		Ciudad buenosAires=new Ciudad();
		buenosAires.setNombre("Buenos Aires");
		buenosAires.setUgeo(ubicacionBsAs);

		Ciudad Londres=new Ciudad();
		Londres.setNombre("Londres");
		Londres.setUgeo(ubicacionLondres);

		Ciudad Amsterdam = new Ciudad();
		Amsterdam.setNombre("Amsterdam");
		Amsterdam.setUgeo(ubicacionAms);

		buenosAires.setPais(Argentina);
		session.save(buenosAires);
		Argentina.setCapital(buenosAires);
		session.save(Argentina);

		Londres.setPais(Inglaterra);
		session.save(Londres);
		Inglaterra.setCapital(Londres);
		session.save(Inglaterra);

		Amsterdam.setPais(Holanda);
		session.save(Amsterdam);
		Holanda.setCapital(Amsterdam);
		session.save(Holanda);

		List<Pais> lista = getSession().createCriteria(Pais.class)
				.createAlias("capital","capital")
				.createAlias("capital.ugeo","ubicacionTotal")
				.add(Restrictions.ge("ubicacionTotal.latitud", 23.5))
				.list();

		assertThat(lista).hasSize(2);
	}

	//5- Hacer con junit un test que busque todas las ciudades del hemisferio sur
	@Test @Transactional @Rollback
	public void testQueBuscoCiudadesDelHemisferioSur(){

		Session session = getSession();

		//pais 1
		Continente america = new Continente();
		america.setNombre("America");

		Pais argentina =new Pais();
		argentina.setNombre("Argentina");
		argentina.setHabitantes((long) 40000000);
		argentina.setIdioma("español");
		argentina.setContinente(america);

		Ubicacion ubicacionBsAs = new Ubicacion();
		ubicacionBsAs.setLatitud(-34.6083);
		ubicacionBsAs.setLongitud(-58.3712);


		Ubicacion ubicacionSantiago = new Ubicacion();
		ubicacionSantiago.setLatitud(-29.4110);
		ubicacionSantiago.setLongitud(66.8506);
		Ciudad santiago = new Ciudad();

		santiago.setNombre("Santiago");
		santiago.setPais(argentina);
		santiago.setUgeo(ubicacionSantiago);

		session.save(santiago);

		Ciudad buenosAires = new Ciudad();
		buenosAires.setNombre("Buenos Aires");
		buenosAires.setUgeo(ubicacionBsAs);



		buenosAires.setPais(argentina);
		session.save(buenosAires);
		argentina.setCapital(buenosAires);
		session.save(argentina);

		//pais 2
		Pais estadosUnidos = new Pais();
		estadosUnidos.setNombre("Estados Unidos");
		estadosUnidos.setHabitantes((long) 328835763);
		estadosUnidos.setIdioma("ingles");
		estadosUnidos.setContinente(america);

		Ubicacion ubicacionW = new Ubicacion();
		ubicacionW.setLatitud(38.9041);
		ubicacionW.setLongitud(-77.0171);

		Ciudad washington = new Ciudad();
		washington.setNombre("Washington");
		washington.setUgeo(ubicacionW);

		washington.setPais(estadosUnidos);
		session.save(washington);
		estadosUnidos.setCapital(washington);
		session.save(estadosUnidos);


		//pais 3
		Continente europa = new Continente();
		europa.setNombre("Europa");

		Pais inglaterra = new Pais();
		inglaterra.setContinente(europa);
		inglaterra.setIdioma("ingles");
		inglaterra.setNombre("Inglaterra");
		inglaterra.setHabitantes((long) 53012000);

		Ubicacion ubicacionL = new Ubicacion();
		ubicacionL.setLatitud(51.5072);
		ubicacionL.setLongitud(-0.1275);

		Ciudad londres = new Ciudad();
		londres.setNombre("Londres");
		londres.setUgeo(ubicacionL);

		londres.setPais(inglaterra);
		session.save(londres);
		inglaterra.setCapital(londres);
		session.save(inglaterra);		



		List<Ciudad> lista=getSession().createCriteria(Ciudad.class)
				.createAlias("ugeo","ubicacionSur")
				.add(Restrictions.lt("ubicacionSur.latitud", 0.00))
				.list();
		assertThat(lista).hasSize(2);
	}

}

	@Test @Transactional @Rollback
	public void testQueBuscoPaisesCapitalNorteCancer(){

		Session session = getSession();

		//continentes
		Continente America = new Continente();
		America.setNombre("America");
		session.save(America);

		Continente Europa = new Continente();
		Europa.setNombre("Europa");
		session.save(Europa);


		//paises
		Pais Argentina = new Pais();
		Argentina.setHabitantes( (long) 40000000);
		Argentina.setNombre("Argentina");
		Argentina.setIdioma("español");
		Argentina.setContinente(America);

		Pais Inglaterra = new Pais();
		Inglaterra.setNombre("Inglaterra");
		Inglaterra.setIdioma("ingles");
		Inglaterra.setHabitantes( (long)5000000);
		Inglaterra.setContinente(Europa);

		Pais Holanda = new Pais();
		Holanda.setNombre("Holanda");
		Holanda.setHabitantes( (long) 17200000);
		Holanda.setIdioma("holandes");
		Holanda.setContinente(Europa);	

		//ubicaciones
		Ubicacion ubicacionBsAs = new Ubicacion();
		ubicacionBsAs.setLatitud(-34.6083);
		ubicacionBsAs.setLongitud(-58.3712);


		Ubicacion ubicacionLondres = new Ubicacion();
		ubicacionLondres.setLatitud(51.5072);
		ubicacionLondres.setLongitud(-0.1275);

		Ubicacion ubicacionAms = new Ubicacion();
		ubicacionAms.setLatitud(52.3738);
		ubicacionAms.setLongitud(4.89093);

		//ciudades
		Ciudad buenosAires=new Ciudad();
		buenosAires.setNombre("Buenos Aires");
		buenosAires.setUgeo(ubicacionBsAs);

		Ciudad Londres=new Ciudad();
		Londres.setNombre("Londres");
		Londres.setUgeo(ubicacionLondres);

		Ciudad Amsterdam = new Ciudad();
		Amsterdam.setNombre("Amsterdam");
		Amsterdam.setUgeo(ubicacionAms);

		buenosAires.setPais(Argentina);
		session.save(buenosAires);
		Argentina.setCapital(buenosAires);
		session.save(Argentina);

		Londres.setPais(Inglaterra);
		session.save(Londres);
		Inglaterra.setCapital(Londres);
		session.save(Inglaterra);

		Amsterdam.setPais(Holanda);
		session.save(Amsterdam);
		Holanda.setCapital(Amsterdam);
		session.save(Holanda);

		List<Pais> lista = getSession().createCriteria(Pais.class)
				.createAlias("capital","capital")
				.createAlias("capital.ugeo","ubicacionTotal")
				.add(Restrictions.ge("ubicacionTotal.latitud", 23.5))
				.list();

		assertThat(lista).hasSize(2);
	}

	//5- Hacer con junit un test que busque todas las ciudades del hemisferio sur
	@Test @Transactional @Rollback
	public void testQueBuscoCiudadesDelHemisferioSur(){

		Session session = getSession();

		//pais 1
		Continente america = new Continente();
		america.setNombre("America");

		Pais argentina =new Pais();
		argentina.setNombre("Argentina");
		argentina.setHabitantes((long) 40000000);
		argentina.setIdioma("español");
		argentina.setContinente(america);

		Ubicacion ubicacionBsAs = new Ubicacion();
		ubicacionBsAs.setLatitud(-34.6083);
		ubicacionBsAs.setLongitud(-58.3712);


		Ubicacion ubicacionSantiago = new Ubicacion();
		ubicacionSantiago.setLatitud(-29.4110);
		ubicacionSantiago.setLongitud(66.8506);
		Ciudad santiago = new Ciudad();

		santiago.setNombre("Santiago");
		santiago.setPais(argentina);
		santiago.setUgeo(ubicacionSantiago);

		session.save(santiago);

		Ciudad buenosAires = new Ciudad();
		buenosAires.setNombre("Buenos Aires");
		buenosAires.setUgeo(ubicacionBsAs);



		buenosAires.setPais(argentina);
		session.save(buenosAires);
		argentina.setCapital(buenosAires);
		session.save(argentina);

		//pais 2
		Pais estadosUnidos = new Pais();
		estadosUnidos.setNombre("Estados Unidos");
		estadosUnidos.setHabitantes((long) 328835763);
		estadosUnidos.setIdioma("ingles");
		estadosUnidos.setContinente(america);

		Ubicacion ubicacionW = new Ubicacion();
		ubicacionW.setLatitud(38.9041);
		ubicacionW.setLongitud(-77.0171);

		Ciudad washington = new Ciudad();
		washington.setNombre("Washington");
		washington.setUgeo(ubicacionW);

		washington.setPais(estadosUnidos);
		session.save(washington);
		estadosUnidos.setCapital(washington);
		session.save(estadosUnidos);


		//pais 3
		Continente europa = new Continente();
		europa.setNombre("Europa");

		Pais inglaterra = new Pais();
		inglaterra.setContinente(europa);
		inglaterra.setIdioma("ingles");
		inglaterra.setNombre("Inglaterra");
		inglaterra.setHabitantes((long) 53012000);

		Ubicacion ubicacionL = new Ubicacion();
		ubicacionL.setLatitud(51.5072);
		ubicacionL.setLongitud(-0.1275);

		Ciudad londres = new Ciudad();
		londres.setNombre("Londres");
		londres.setUgeo(ubicacionL);

		londres.setPais(inglaterra);
		session.save(londres);
		inglaterra.setCapital(londres);
		session.save(inglaterra);		



		List<Ciudad> lista=getSession().createCriteria(Ciudad.class)
				.createAlias("ugeo","ubicacionSur")
				.add(Restrictions.lt("ubicacionSur.latitud", 0.00))
				.list();
		assertThat(lista).hasSize(2);
	}

}