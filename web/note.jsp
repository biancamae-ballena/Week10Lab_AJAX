<%-- 
    Document   : note
    Created on : Mar 28, 2020, 9:58:24 PM
    Author     : 785284
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><b>Notes!</b></h1>
        <table>
            <th>Date Created</th>
            <th>Title</th>
            <th></th>
        </table>
        <h2><b>Add Note</b></h2>
        <input type="text" name="title" placeholder="Title"/><br>
        <textarea rows="10" cols="30" placeholder="Type a note.."></textarea>
        <button type="submit" name="add">Add</button>
    </body>
</html>