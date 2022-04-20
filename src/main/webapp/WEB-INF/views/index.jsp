<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
            function info(){
                alert(document.referrer);
            }

            // $(function(){}); 내부에 작성하면 자동으로
            // $(document).ready(function(){}); 와 같아진다.
            // 로드된 후에 버튼을 선택자로 선택, 클릭하면 info 함수가 실행되게 함.
            $(()=>{
            $("#button").click(function(){
                info();
            });
            $(function(){
                $("#logout").click(function(){
                    alert("로그아웃");
                });
            });

            /*
            $("p").mouseenter(function(){
                 $(this).css("background-color","skyblue");
                 $(this).css("color","white");
            });
            */


            /*
            한 번에 여러 개의 이벤트를 등록할 때.
            */
            $("p").on({
              mouseenter: function(){
                $(this).css("background-color", "lightgray");
              },
              mouseleave: function(){
            	$(this).css("background-color", "lightblue");
              },
              click: function(){
            	$(this).css("background-color", "yellow");
              }
            });



            });

    </script>
    <style>
        h1:hover {
            color: yellow;
        }
    </style>

</head>
<body>
    <h1>Hello Spring Boot!</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rutrum sit amet nibh et placerat. Duis hendrerit turpis nunc, sit amet cursus purus ornare id. Pellentesque ullamcorper magna at nulla iaculis, id accumsan dui molestie. Nunc nec lorem ullamcorper, pretium tellus non, volutpat metus. Sed accumsan massa eget viverra ullamcorper. Pellentesque vestibulum risus dolor, vitae feugiat lectus efficitur ut. In ullamcorper nibh at enim ultrices mollis. Praesent malesuada sapien nec feugiat tincidunt. Etiam quis enim orci.</p>
    <button id="button">hi</button>
    <br/>

    <ul>
        <li><a href="signup">회원 가입</a></li>
        <li><a href="userlist">회원 목록</a></li>
        <li><a href="posts">게시글 목록</a></li>
        <li><a href="myinfo">내 정보</a></li>
    </ul>
    <form id="logoutForm" action="logout" method="POST">
        <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
        <button type="submit" id="logout" style="color: red" >로그아웃</button>
    </form>


</body>
</html>