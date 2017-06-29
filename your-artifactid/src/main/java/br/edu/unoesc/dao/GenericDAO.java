package br.edu.unoesc.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.edu.unoesc.ExceptionDao.MinhaExceptionDAO;
import br.edu.unoesc.model.Elo;
import br.edu.unoesc.model.MeuModelo;
import br.edu.unoesc.model.Rota;

@RequestScoped
public abstract class GenericDAO<T extends MeuModelo> {

	@Produces
	protected EntityManagerFactory emf;

	@Produces
	protected EntityManager em;

	public GenericDAO() {
	}

	public void conectar() {
		emf = Persistence.createEntityManagerFactory("unidade");
		em = emf.createEntityManager();
	}

	public void desconectar() {
		em.close();
		emf.close();
	}

	public void salvar(T objeto) throws MinhaExceptionDAO {
		conectar();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			if (objeto.getCodigo() == null) {
				em.persist(objeto);
			} else {
				em.merge(objeto);
			}
			et.commit();
		} catch (Exception ex) {
			et.rollback();
			throw new MinhaExceptionDAO(ex.getMessage());
		} finally {
			desconectar();
		}
	}

	public void excluir(T objeto, Class<T> tipo) throws MinhaExceptionDAO {
		conectar();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			T banco = em.find(tipo, objeto.getCodigo());
			em.remove(banco);
			et.commit();
		} catch (Exception ex) {
			et.rollback();
			throw new MinhaExceptionDAO(ex.getMessage());
		} finally {
			desconectar();
		}
	}

	public List<T> listar(String query, Class<T> tipo) {
		conectar();
		TypedQuery<T> tq = em.createNamedQuery(query, tipo);
		List<T> objetos = tq.getResultList();
		desconectar();
		return objetos;
	}

	public List<T> pesquisarPorNome(String nome, String query, Class<T> tipo) {
		conectar();
		TypedQuery<T> tq = em.createNamedQuery(query, tipo);
		tq.setParameter("NOME", "%" + nome + "%");
		List<T> objetos = tq.getResultList();
		desconectar();
		return objetos;
	}

	public T pesquisarPorNicknameESenha(String nickname, String senha, String query, Class<T> tipo) {
		conectar();
		TypedQuery<T> tq = em.createNamedQuery(query, tipo);
		tq.setParameter("NICKNAME", nickname);
		tq.setParameter("SENHA", senha);
		T objeto = tq.getSingleResult();
		desconectar();
		return objeto;
	}

	public T pesquisarPorCodigo(Long codigo, String query, Class<T> tipo) {
		conectar();
		TypedQuery<T> tq = em.createNamedQuery(query, tipo);
		tq.setParameter("CODIGO", codigo);
		T objeto = tq.getSingleResult();
		desconectar();
		return objeto;
	}

	public List<T> pesquisarDuo(Elo elo, Rota rota, String query, Class<T> tipo) {
		conectar();
		TypedQuery<T> tq = em.createNamedQuery(query, tipo);
		tq.setParameter("ELO", elo);
		tq.setParameter("ROTA", rota);
		List<T> objetos = tq.getResultList();
		desconectar();
		return objetos;
	}

	public List<T> pesquisarMentor(Elo elo, Rota rota, String query, Class<T> tipo) {
		conectar();
		TypedQuery<T> tq = em.createNamedQuery(query, tipo);
		tq.setParameter("ELO", elo);
		tq.setParameter("ROTA", rota);
		List<T> objetos = tq.getResultList();
		desconectar();
		return objetos;
	}
}
