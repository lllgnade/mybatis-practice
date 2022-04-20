<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
    <style>
        table {
            padding: 10px;
        }

        tr {
            padding: 3px;
        }

        td {
            padding: 3px;
        }

        [type=submit] {
            width: 120%;
            margin-top: 7px;
        }

        [type=submit]:hover {
            color: skyblue;
        }
    </style>
</head>

<body>
    <fieldset style="max-width: 300px;">
        <legend>Sign In</legend>
        <form method="post" action="signup">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <table>
                <tr>
                    <td><label for="email">이메일</label></td>
                    <td><input type="email" id="email" name="email" maxlength="320" required /></td>
                </tr>
                <tr>
                    <td><label for="password">비밀번호</label></td>
                    <td><input type="password" id="password" name="password" maxlength="64" required /></td>
                </tr>
                <tr>
                    <td><label for="name">이름</label></td>
                    <td><input type="text" id="name" name="name" maxlength="100" required /></td>
                </tr>
                <tr>
                    <td><label for="username">유저네임 </label></td>
                    <td><input type="text" id="username" name="username" maxlength="100" /></td>
                </tr>
                <tr>
                    <td><label for="phone">전화번호 </label></td>
                    <td><input type="text" id="phone" name="phone" maxlength="32" /></td>
                </tr>
                <tr>
                    <td><label for="address">주소 </label></td>
                    <td><input type="text" id="address" name="address" maxlength="256" /></td>
                </tr>
                <tr>
                    <td><label for="website">웹사이트 </label></td>
                    <td><input type="text" id="website" name="website" maxlength="300" /></td>
                </tr>
                <tr>
                    <td><label for="company">회사명 </label></td>
                    <td><input type="text" id="company" name="company" maxlength="256" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="JOIN!" /></td>
                </tr>
            </table>
        </form>
    </fieldset>
    <br/>
    <a href="/"><button>홈</button></a>
    <a href="userlist"><button>회원 목록</button></a>
</body>

</html>