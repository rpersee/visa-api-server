package eu.ill.visa.persistence.repositories;

import com.google.inject.Provider;
import eu.ill.preql.AbstractFilterQueryProvider;
import eu.ill.preql.FilterQuery;
import eu.ill.visa.core.domain.OrderBy;
import eu.ill.visa.core.domain.Pagination;
import eu.ill.visa.core.domain.Parameter;
import eu.ill.visa.core.domain.QueryFilter;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNullElseGet;

abstract class AbstractRepository<T> {

    private final Provider<EntityManager> entityManager;

    protected AbstractRepository(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(final T object) {
        entityManager.get().persist(object);
    }

    public T merge(final T object) {
        T persistedObject = entityManager.get().merge(object);
        return persistedObject;
    }

    public void remove(final T object) {
        EntityManager em = entityManager.get();

        em.remove(em.contains(object) ? object : em.merge(object));
    }

    public abstract List<T> getAll();

    public EntityManager getEntityManager() {
        return entityManager.get();
    }

    public FilterQuery<T> createFilterQuery(AbstractFilterQueryProvider<T> provider, QueryFilter filter, OrderBy orderBy, Pagination pagination) {
        final FilterQuery<T> query = provider.createQuery(filter.getQuery());

        for (Parameter parameter : filter.getParameters()) {
            query.setParameter(parameter.getName(), parameter.getValue());
        }
        if (pagination != null) {
            query.setPagination(pagination.getLimit(), pagination.getOffset());
        }

        if (orderBy != null) {
            final String direction = orderBy.getAscending() ? "asc" : "desc";
            query.setOrder(orderBy.getName(), direction);
        }
        return query;
    }

    public Long countAll(AbstractFilterQueryProvider<T> provider, QueryFilter filter) {
        final FilterQuery<T> query = createFilterQuery(provider, requireNonNullElseGet(filter, QueryFilter::new), null, null);
        return query.count();
    }

    public List<T> getAll(AbstractFilterQueryProvider<T> provider, QueryFilter filter, OrderBy orderBy, Pagination pagination) {
        final FilterQuery<T> query = createFilterQuery(provider, requireNonNullElseGet(filter, QueryFilter::new), orderBy, pagination);
        return query.getResultList();
    }

    public void initialiseData(String filename) {
        final String sql = getFileAsString(filename);

        EntityManager em = this.getEntityManager();
        em.clear();
        Session session = em.unwrap(Session.class);
        session.doWork(connection -> {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        });
    }

    private String getFileAsString(String fileName) {
        final InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }
}
