
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign In</title>
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
        #logoutForm{
            padding-top : 10px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
    <fieldset style="max-width: 300px;">
        <legend>User Information</legend>
        <form>
            <table>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="email" id="email" name="email" value="${userInfo.email}" maxlength="320" readonly/></td>
                </tr>
                <!--
                <tr>
                    <td><label for="password">Password</label></td>
                    <td><input type="password" id="password" name="password" value="${userInfo.password}" maxlength="64" readonly /></td>
                </tr>
                -->
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input type="text" id="name" name="name" value="${userInfo.name}" maxlength="100" readonly /></td>
                </tr>
                <tr>
                    <td><label for="username">Username </label></td>
                    <td><input type="text" id="username" name="username" value="${userInfo.username}" maxlength="100" readonly /></td>
                </tr>
                <tr>
                    <td><label for="phone">Phone </label></td>
                    <td><input type="text" id="phone" name="phone" value="${userInfo.phone}" maxlength="32" readonly /></td>
                </tr>
                <tr>
                    <td><label for="address">Address </label></td>
                    <td><input type="text" id="address" name="address" value="${userInfo.address}" maxlength="256" readonly /></td>
                </tr>
                <tr>
                    <td><label for="website">Website </label></td>
                    <td><input type="text" id="website" name="website" value="${userInfo.website}" maxlength="300" readonly/></td>
                </tr>
                <tr>
                    <td><label for="company">Company </label></td>
                    <td><input type="text" id="company" name="company" value="${userInfo.company}" maxlength="256" readonly /></td>
                </tr>
            </table>
        </form>
    </fieldset>
    <br/>
    <a href="/"><button>???</button></a>
    <a href="signup"><button>?????? ??????</button></a>
    <a href="userlist"><button>?????? ??????</button></a>
    <form id="logoutForm" action="logout" method="POST">
        <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
        <button type="submit" id="logout" style="color: red" >????????????</button>
    </form>
</body>

</html>