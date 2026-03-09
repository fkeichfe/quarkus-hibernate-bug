package org.example.data;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.jpa.HibernateHints;
import org.hibernate.jpa.SpecHints;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class TestCase {


    @Inject
    protected EntityManager em;

    @Test
    void testHibernateBugWithCriteriaQuery() {
        final HibernateCriteriaBuilder builder = em.unwrap(Session.class).getCriteriaBuilder();
        final CriteriaQuery<Account> deviceCriteriaQuery = builder.createQuery(Account.class);
        Root<Account> deviceRoot = deviceCriteriaQuery.from(Account.class);
        Path<UUID> idPath = deviceRoot.get(Account_.id);
        deviceCriteriaQuery.where(idPath.equalTo(UUID.fromString("eea8c177-fb46-446c-aafd-90bc4977dd8c")));
        TypedQuery<Account> query = em.createQuery(deviceCriteriaQuery)
                .setHint(HibernateHints.HINT_READ_ONLY, true)
                .setHint(SpecHints.HINT_SPEC_FETCH_GRAPH, createFetchGraph());
        List<Account> resultList = query.getResultList();
        assertEquals(1, resultList.size());
    }

    @Test
    void testHibernateBugWithQuery() {
        TypedQuery<Account> query = em.createQuery("select a from Account a where a.id = :id", Account.class)
                .setParameter("id", UUID.fromString("eea8c177-fb46-446c-aafd-90bc4977dd8c"))
                .setHint(HibernateHints.HINT_READ_ONLY, true)
                .setHint(SpecHints.HINT_SPEC_FETCH_GRAPH, createFetchGraph());
        Account a = query.getSingleResultOrNull();
        assertNotNull(a);
    }

    @Test
    void testHibernateBugWithFind() {
        Map<String, Object> properties = Map.of(HibernateHints.HINT_READ_ONLY, true, SpecHints.HINT_SPEC_FETCH_GRAPH, createFetchGraph());
        Account a = em.find(Account.class, UUID.fromString("eea8c177-fb46-446c-aafd-90bc4977dd8c"), properties);
        assertNotNull(a);
    }



    protected EntityGraph<Account> createFetchGraph() {
        EntityGraph<Account> fetchGraph = em.createEntityGraph(Account.class);
        fetchGraph.addSubgraph(Account_.userName);
        Subgraph<AddressAssignment> addressAssignmentSubgraph = fetchGraph.addElementSubgraph(Account_.addressAssignments);
        addressAssignmentSubgraph.addSubgraph(AddressAssignment_.userName);
        addressAssignmentSubgraph.addSubgraph(AddressAssignment_.address).addSubgraph(Address_.store);
        addressAssignmentSubgraph.addSubgraph(AddressAssignment_.booking);

        return fetchGraph;
    }
}