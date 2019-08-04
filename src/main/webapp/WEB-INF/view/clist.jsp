
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List - Contact Application </title>
        <s:url var="url_css" value="static/css/style.css" />
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
        
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg" />
    
    <body background="${url_bg}">
        <table  border="1" width="50%" align="center">
            <tr>
                <td height="80px">
                    <!-- Header ---> 
                    <jsp:include page="include/header.jsp" />  
                      
                </td>
            </tr>
            
             <tr>
                <td height="25px">
                    <!-- Menu---> 
                     <jsp:include page="include/menu.jsp" /> 
                    
                </td>
            </tr>
            
            
             <tr>
                <td height="350px" valign="top">
                    <!--Page content Area --->  
                    
                    <h3>Contact List </h3>
                    
                     <!--Message after data get saved into contact list --->
                     
                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">Contact Saved Successfully..!</p>
                    </c:if>
                        
                           
                    <c:if test="${param.act eq 'del'}">
                        <p class="success">Contact Deleted Successfully..!</p>
                    </c:if>
                  
                        
                        <%-- search action--%>
                        <table width="100%">
                        <tr>
                        <td align="right">
                        <form action="<s:url value ="/user/contact_search"/>" >
                        <input type="text" name="freeText" value="${param.freeText}" placeholder="search your contact">
                        <button>Find</button>                               
                        </form>
                        </td>
                        </tr>
                        </table>
                        
                        
           
                        <form action="<s:url value="/user/bulk_cdelete"/>">
                            <button>Delete Selected Records</button><br/>
                        <table border="1" cellpadding="3" width="100%">
                        <%--  Page content area --%>
                        
                        <tr>
                            <th>SELECT</th>
                            <th>CID</th>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
                            <th>ADDRESS</th>
                            <th>REMARK</th>
                            <th>ACTION</th>
                         </tr>
                        
                          <!--message when there is no data in contact list --->
                          
                          <c:if test="${empty contactList }">
                              <tr>
                                  <td  align="center" colspan="8" class="error">No Records Present</td>
                              </tr>
                          </c:if>
                         
                         <c:forEach  var="c" items="${contactList}" varStatus="st">          
                        <tr>
                            <td align="center"><input type="checkbox" name="cid" value="${c.contactId}"/></td>
                            <td>${c.contactId}</td>
                            <td>${c.name}</td>
                            <td>${c.phone}</td>
                            <td>${c.email}</td>   
                            <td>${c.address}</td>
                            <td>${c.remark}</td>
                            
                            <s:url var="url_del" value="/user/del_contact">
                                <s:param name="cid" value="${c.contactId}" />
                            </s:url>
                            
                             <s:url var="url_edit" value="/user/edit_contact">
                                <s:param name="cid" value="${c.contactId}" />
                            </s:url>
                            
                            <td> <a href="${url_edit}"> EDIT</a> |  <a href="${url_del}">DELETE</a> </td>
                         </tr>        
                         </c:forEach>
                        </table>
                      </form>
                    
                </td>
            </tr>
            
            
              <tr>
                <td height="25px">
                    <!-- Footer ---> 
                    <jsp:include page="include/footer.jsp" /> 
                    
                </td>
            </tr>
          
        </table>
    </body>
</html>

