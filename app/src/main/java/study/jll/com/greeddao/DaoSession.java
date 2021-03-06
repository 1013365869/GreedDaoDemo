package study.jll.com.greeddao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import study.jll.com.greeddaodemo.Sutdent;

import study.jll.com.greeddao.SutdentDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig sutdentDaoConfig;

    private final SutdentDao sutdentDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        sutdentDaoConfig = daoConfigMap.get(SutdentDao.class).clone();
        sutdentDaoConfig.initIdentityScope(type);

        sutdentDao = new SutdentDao(sutdentDaoConfig, this);

        registerDao(Sutdent.class, sutdentDao);
    }
    
    public void clear() {
        sutdentDaoConfig.clearIdentityScope();
    }

    public SutdentDao getSutdentDao() {
        return sutdentDao;
    }

}
