<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <style>
            .alert{
                color : red;
            }
            #logoutForm{
                padding-top : 10px;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(function(){
                $("#logout").click(function(){
                    alert("로그아웃");
                });
            });
        </script>
    </head>
    <body>
        <h2>회원 목록</h2>
            <table border="1">
                <tr>
                    <th>id</th>
                    <th>이메일</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                    <th>유저네임</th>
                    <th>전화번호</th>
                    <th>주소</th>
                    <th>웹사이트</th>
                    <th>회사명</th>
                    <th class="alert">삭제</th>
                </tr>
                <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                    <td>${user.username}</td>
                    <td>${user.phone}</td>
                    <td>${user.address}</td>
                    <td>${user.website}</td>
                    <td>${user.company}</td>
                    <td><a href="delete?id=${user.id}">삭제</a></td>
                </tr>
                </c:forEach>
            </table>
            <br/>
            <a href="/"><button>홈</button></a>
            <a href="signup"><button>회원 가입</button></a>
            <form id="logoutForm" action="logout" method="POST">
                <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
                <button type="submit" id="logout" style="color: red" >로그아웃</button>
            </form>
    </body>
</html>