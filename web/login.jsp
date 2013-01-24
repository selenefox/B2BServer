<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>index.jsp</title>
    </head>
    <body>
        <s:form action="login">
            <s:textfield name="loginname"/>
            <s:password name="password"/>
            <s:submit/>
        </s:form>
        <div><s:fielderror/><s:actionerror/></div>
    </body>
</html>