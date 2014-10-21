<%--
  Created by IntelliJ IDEA.
  User: mitch
  Date: 10/17/14
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>privoto</title>
</head>
<body>
    <h1>privoto API</h1>
    <div>
        <ul>
            <li>
                <code><b>GET</b></code> : <code><a href="/api/messages">/api/messages</a></code>
            </li>
            <li>
                <code><b>GET</b></code> : <code>/api/images/{id}</code>
                <ul>
                    <li><code>id</code> - required image id</li>
                </ul>
            </li>
            <li>
                <code><b>POST</b></code> : <code><a href="/api/messages">/api/messages</a></code>
                <ul>
                    <li><code>image</code> - optional file</li>
                    <li><code>text</code> - optional text</li>
                    <li><code>delay</code> - optional length of time for message</li>
                </ul>
            </li>
        </ul>
    </div>
    <br />
    <br />
    <a href="/about">about.</a> | <a href="https://github.com/mitch-b/privoto">source.</a>
</body>
</html>