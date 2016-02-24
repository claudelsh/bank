<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>회원가입</title>
</head>
<body>
	<div id="Join">
		<div class="JoinTop">
			<h2>
				<p>JOIN</p>
				<span>회원가입</span>
			</h2>
		</div>
		<div class="JoinCenter">
			<form action="/member/join" method="get" name="joinForm">
				<fieldset class="joinField">
					<div class="input_row">
						<span>아이디 : </span>
						<span class="input_box">
							<input type="text" id="userid" name="userid" placeholder="아이디" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>비밀번호 : </span>
						<span class="input_box">
							<input type="password" id="password" name="password" placeholder="비밀번호" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>이름 : </span>
						<span class="input_box">
							<input type="text" id="name" name="name" placeholder="이름" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>주소 : </span>
						<span class="input_box">
							<input type="text" id="addr" name="addr" placeholder="주소" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>생년월일 : </span>
						<span class="input_box">
							<input type="text" id="bitrh" name="birth" placeholder="생년월일" maxlength="20"/>
						</span>
					</div>
					<div class="input_button">
						<a href="${context}/member/loginForm">
							<span class="input_box">
								<input type="button" id="joinButton" value="회원가입" onclick="joinMember()"/>
							</span>
						</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function joinMember() {
			if (document.joinForm.userid.value=='') {
				alert('아이디를 입력해 주세요');
				document.joinForm.userid.focus();
			} else if (document.joinForm.password.value=='') {
				alert('비밀번호를 입력해 주세요');
				document.joinForm.password.focus();
			} else if (document.joinForm.name.value=='') {
				alert('이름을 입력해 주세요');
				document.joinForm.name.focus();
			} else if (document.joinForm.addr.value=='') {
				alert('주소를 입력해 주세요');
				document.joinForm.addr.focus();
			} else if (document.joinForm.addr.value=='') {
				alert('생년월일을 입력해 주세요');
				document.joinForm.birth.focus();
			} else {
				document.joinForm.submit();
				return true;
			}
		}
	</script>
</body>
</html>