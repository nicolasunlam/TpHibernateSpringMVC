package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

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
		assertThat(lista).isNotEmpty();
		assertThat(lista.get(0).getIdioma()).isEqualTo("inglés");
		assertThat(lista.get(1).getIdioma()).isEqualTo("inglés");
		assertThat(lista.get(0).getNombre()).isEqualTo("Irlanda");
		assertThat(lista.get(1).getNombre()).isEqualTo("Reino Unido");
		assertThat(lista.get(0).getNombre()).isNotEqualTo("Japón");
		assertThat(lista.get(1).getNombre()).isNotEqualTo("Japón");
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
				.createAlias("continente", "continente")
				.add(Restrictions.eq("continente.nombre", "Europa"))
				.list();
		assertThat(lista).hasSize(2);
		assertThat(lista).isNotEmpty();
		assertThat(lista.get(0).getContinente().getNombre()).isEqualTo("Europa");
		assertThat(lista.get(1).getContinente().getNombre()).isEqualTo("Europa");
		assertThat(lista.get(0).getContinente().getNombre()).isNotEqualTo("Asia");
		assertThat(lista.get(1).getContinente().getNombre()).isNotEqualTo("Asia");
		assertThat(lista.get(0).getNombre()).isEqualTo("Irlanda");
		assertThat(lista.get(1).getNombre()).isEqualTo("Reino Unido");

	}

}

