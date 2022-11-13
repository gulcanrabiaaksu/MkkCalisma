package com.mkk.ugd.oracle.mkk.musteri_yonetim.dal;

import com.mkk.ugd.oracle.mkk.musteri_yonetim.utility.HibernateUtil;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.utility.Sorgu;
import com.mkk.ugd.oracle.mkk.musteri_yonetim.utility.TabloAd;
import com.mkk.ugd.utility.Util;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class VarlikDAL<V, I extends Serializable>
{
    private Session session;
    private Transaction transaction;

    private Class<V> varlikSinifi;
    private TabloAd tabloAd;

    public VarlikDAL(Class<V> varlikSinifi, TabloAd tabloAd)
    {
        this.varlikSinifi = varlikSinifi;
        this.tabloAd = tabloAd;
    }

    public boolean sil(I id)
    {
        try
        {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction();

            V bulunanVarlik = (V) session.get(varlikSinifi, id);
            session.delete(bulunanVarlik);
            transaction.commit();

            return true;
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);

            transaction.rollback();

            return false;
        }
    }

    public List<V> tumVarlilariCek()
    {
        try
        {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction();

            SQLQuery sqlQuery = session.createSQLQuery(Sorgu.TUM_VARLIKLARI_CEK + tabloAd);

            return sqlQuery != null ? sqlQuery.addEntity(varlikSinifi).list() : null;
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);

            return null;
        }
    }

    public boolean ekle(V varlik)
    {
        try
        {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction();

            session.save(varlik);
            transaction.commit();

            return true;
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);

            transaction.rollback();

            return false;
        }
    }
}
