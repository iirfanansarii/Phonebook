
package com.mycompany.contact.service;



import com.mycompany.capp.dao.BaseDAO;
import com.mycompany.capp.dao.ContactDAO;
import com.mycompany.capp.rm.ContactRowMapper;
import com.mycompany.contact.domain.Contact;
import com.mycompany.contact.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 55ans
 */

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void save(Contact c) {
        System.out.println("--------- contact in contact service impl " + c);
        contactDAO.save(c);
       }

    @Override
    public void update(Contact c) {
      contactDAO.update(c); 
    }

    @Override
    public void delete(Integer contactId) {
       contactDAO.delete(contactId);
    }

    @Override
    public void delete(Integer[] contactIds) {
        String ids = StringUtil.toCommaSeparatedString(contactIds);
       String sql = "DELETE FROM contact WHERE contactId IN ("+ids+")";
       getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
     return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContactList( String txt) {
        System.out.println("search text " + txt);
    String sql = "SELECT * FROM contact WHERE name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%' ";
        return getJdbcTemplate().query(sql, new ContactRowMapper() );
     
    
    }

    @Override
    public Contact findById(Integer contactId) {
    return   contactDAO.findById(contactId);
    }

}
