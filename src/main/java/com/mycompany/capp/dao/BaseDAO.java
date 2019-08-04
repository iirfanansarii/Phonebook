
package com.mycompany.capp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author 55ans
 */
//do not use @Repository or @Service or @Component annotation

public class BaseDAO extends NamedParameterJdbcDaoSupport{
    
    @Autowired
    public void setDataSource2 (DataSource ds){
        super.setDataSource(ds);
    }
    
}
