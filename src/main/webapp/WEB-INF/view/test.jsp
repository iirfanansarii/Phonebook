<%-- 
    Document   : test
    Created on : Aug 2, 2019, 1:32:07 AM
    Author     : 55ans
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js" />
        <script src="${url_jqlib}"> </script>
        <script>
         $(document).ready(function(){
         
      //alert('Jquery is Ready and integrated');
      
      $("#id_get_time").click(function(){
          // alert('Button Clicked...');
          $.ajax({
             url: 'get_time',
             success : function(data){
                 $("#id_time").html(data);
             }
          });
      });
     });
        </script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajax Test Page </h1>
        
        <button id="id_get_time">Get Server TIme </button><br/>
        <p id="id_time"></p>
        
    </body>
</html>
