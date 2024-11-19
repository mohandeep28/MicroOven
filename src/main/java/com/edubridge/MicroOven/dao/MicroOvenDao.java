package com.edubridge.MicroOven.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.MicroOven.model.MicroOven;  // Use MicroOven instead of Contact
import com.edubridge.MicroOven.utils.HibernateUtils;

public class MicroOvenDao implements MicroOvenDaoI {  // Renaming to MicroOvenDao

    @Override
    public void addMicroOven(MicroOven microOven) {  // Use MicroOven instead of Contact
        Transaction tx = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.persist(microOven);  // Persist MicroOven object
            tx = session.beginTransaction();
            tx.commit();
            System.out.println("New MicroOven added!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<MicroOven> getAllMicroOvens() {  // Use MicroOven instead of Contact
        List<MicroOven> microOvens = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "from MicroOven";  // Query for MicroOven class
            Query query = session.createQuery(hql, MicroOven.class);
            microOvens = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return microOvens;
    }

    @Override
    public MicroOven getMicroOvenById(Integer id) {  // Use MicroOven instead of Contact
        MicroOven microOven = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            microOven = session.get(MicroOven.class, id);  // Get MicroOven by ID
        } catch (Exception e) {
            e.printStackTrace();
        }
        return microOven;
    }

    @Override
    public void updateMicroOven(MicroOven microOven) {  // Use MicroOven instead of Contact
        Transaction tx = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.merge(microOven);  // Merge MicroOven object (update)
            tx = session.beginTransaction();
            tx.commit();
            System.out.println("MicroOven is updated!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMicroOven(Integer id) {  // Use MicroOven instead of Contact
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            MicroOven microOven = session.get(MicroOven.class, id);  // Get MicroOven by ID

            if (microOven != null) {
                session.remove(microOven);  // Remove MicroOven
                tx.commit();
                System.out.println("MicroOven is deleted!");
            } else {
                System.out.println("No MicroOven found!");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllMicroOvens() {  // Use MicroOven instead of Contact
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            String hql = "delete from MicroOven";  // Query to delete all MicroOvens
            Query query = session.createQuery(hql);
            query.executeUpdate();
            System.out.println("All MicroOvens are deleted");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
