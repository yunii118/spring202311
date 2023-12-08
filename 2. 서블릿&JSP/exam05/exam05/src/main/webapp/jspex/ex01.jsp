<%@ page contentType="text/html; charset=UTF-8" %>
<h1>안녕하세요!</h1>

<%
    // 지역변수에 저장
    int num1 = 100;
    int num2 = 200;

     // jsp는 번역기술, 멤버변수는 변역시 제일 위쪽에 선언되기 때문에
     // 순서가 아래에 있어도 사용가능함
    int result = num1 + num2 + num3;


%>
<%=result %>

<%!
   // 멤버변수에 저장

    int num3 = 300;
     int add(int num1, int num2){
            return num1 + num2;
        }
%>