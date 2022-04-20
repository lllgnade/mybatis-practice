<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log In</title>
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

        #loginFailMsg{
            display : none;
            color: red;
        }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(function(){
            if("${requestScope.loginFailMsg}" !== "") {
                const loginFailMsg = "${requestScope.loginFailMsg}"
                $("#loginFailMsg").css("display","block");
                $("#loginFailMsg").text(loginFailMsg);
            }
        });

    </script>

</head>

<body>
    <fieldset style="max-width: 300px;">
        <legend>Sign In</legend>
        <form method="POST" action="/loginProc">
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
                    <td><input type="submit" value="LOGIN!" /></td>
                </tr>
            </table>
        </form>
    </fieldset>
    <p id="loginFailMsg">Fail 메세지</p>
    <br/>
    <a href="/"><button>홈</button></a>
    <a href="signup"><button>회원 가입</button></a>
    <a href="userlist"><button>회원 목록</button></a>
</body>

</html>