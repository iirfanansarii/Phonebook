
package com.mycompany.capp.dao;

import com.mycompany.capp.rm.ContactRowMapper;
import com.mycompany.contact.domain.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 55ans
 */
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

    @Override
    public void save(Contact c) {
        System.out.println("contact details : " + c);
        String sql = "INSERT INTO contact(userId,name,email,phone,address,remark)VALUES(:userId,:name,:email,:phone,:address,:remark)";
      
        //map to bind value
        
        Map m = new HashMap();
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        
         SqlParameterSource ps = new MapSqlParameterSource(m);
         KeyHolder kh = new GeneratedKeyHolder();
         getNamedParameterJdbcTemplate().update(sql, ps,kh);
         c.setContactId(kh.getKey().intValue());
        
    }

    @Override
    public void update(Contact c) {
         String sql = "UPDATE contact SET name=:name,email=:email,phone=:phone,address=:address,remark=:remark WHERE contactId=:contactId";
      
        //map to bind value
        
        Map m = new HashMap();
        m.put("contactId", c.getContactId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        
        getNamedParameterJdbcTemplate().update(sql, m);
        
    }

    @Override
    public void delete(Contact c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer ContactId) {
        String sql = "DELETE FROM contact WHERE contactId=?";
        
       getJdbcTemplate().update(sql,ContactId);
    }

    @Override
    public Contact findById(Integer ContactId) {
        String sql = "SELECT * FROM contact WHERE contactId=?";
        return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(),ContactId);
        
    }
    
    @Override
    public List<Contact> findAll() {
        String sql = "SELECT contactId ,name,phone,email,address,remark FROM contact";
        return getJdbcTemplate().query(sql, new ContactRowMapper());
    }

    @Override
    public List<Contact> findByProperty(String propname, Object propValue) {
        System.out.println("user id : " + propname + " val : " + propValue);
        String sql = "SELECT * FROM contact WHERE "+propname+"=?";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),propValue);
    }
    
    
}
