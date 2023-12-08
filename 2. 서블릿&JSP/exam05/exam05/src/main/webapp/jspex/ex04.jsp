<%@ page contentType="text/html; charset=UTF-8" %>

<h1>ex04.jsp 상단</h1>
// 버퍼를 사용하여 실행됨
// 버퍼에 jsp가 담김 -> 버퍼 출력시 이만 담김 -> 페이지 이동 안된상태에서 버퍼에 담긴 내용만 출력
// jsp:forward : 다른 요소들 무시하고 해당 태그만 버퍼에 담김
// jsp:include : 다른요소들까지 포함하여 버퍼에 담김

<jsp:forward page="ex05.jsp" />
<h1>ex04.jsp 하단</h1>