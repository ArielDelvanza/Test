/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TblPelanggan;
import pojo.TokoJasaUtil;

/**
 *
 * @author Ariel
 */
public class DAOPelanggan {
    public void addPelanggan (TblPelanggan plg){
        Transaction trans = null;
        Session session = TokoJasaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(plg);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deletePelanggan(String idP) {
        Transaction trans = null;
        Session session = TokoJasaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblPelanggan  plg = (TblPelanggan) session.load(TblPelanggan.class, new String(idP));
            session.delete(plg);
            trans.commit();           
        } catch (Exception e){
            e.printStackTrace();
        } 
    }
    
    public List<TblPelanggan> getbyID(String idP) {
        TblPelanggan plg = new TblPelanggan();
        List<TblPelanggan> cst = new ArrayList();
        
        Transaction trans = null;
        Session session = TokoJasaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblPelanggan where id_pelanggan= :id");
            query.setString("id", idP);
            plg = (TblPelanggan) query.uniqueResult();
            cst = query.list();
            trans.commit();
        } catch (Exception e) {
            
        }
        return cst;
    }
    
    public List<TblPelanggan> retrieveTblPelanggan() {
        List stud = new ArrayList();
        TblPelanggan stud1 = new TblPelanggan();
        Transaction trans = null;
        Session session = TokoJasaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblPelanggan");
            stud = query.list();
            stud.add(stud1.getNama());
            stud.add(stud1.getAlamat());
            stud.add(stud1.getEmail());
            stud.add(stud1.getNoTelp());
            stud.add(stud1.getJasa());
            stud.add(stud1.getHarga());
            trans.commit();
        } catch (Exception e) {
        }
        return stud;
    }
    
        public void updatePelanggan(TblPelanggan plg) {

        Transaction trans = null;
        Session session = TokoJasaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(plg);
            trans.commit();
        } catch (Exception e) {
        }
        }
    
}
