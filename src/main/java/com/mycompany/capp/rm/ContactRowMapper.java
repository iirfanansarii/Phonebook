
package com.mycompany.capp.rm;

import com.mycompany.contact.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 55ans
 */
public class ContactRowMapper implements RowMapper<Contact>  {

    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
       Contact  u= new Contact();
       u.setContactId(rs.getInt("contactId"));
       u.setUserId(rs.getInt("userId"));
       u.setName(rs.getString("name"));
       u.setPhone(rs.getString("phone"));
       u.setEmail(rs.getString("email"));
       u.setAddress(rs.getString("address"));
       u.setRemark(rs.getString("remark"));
       
      return u;
    }
    
    
}
