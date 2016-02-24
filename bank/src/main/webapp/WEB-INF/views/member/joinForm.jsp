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
			<form action="/member/Join" method="get" name="JoinForm">
				<fieldset class="JoinField">
					<div class="input_row">
						<span>아이디 : </span>
						<span class="input_box">
							<input type="text" id="userid" placeholder="아이디" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>비밀번호 : </span>
						<span class="input_box">
							<input type="password" id="password" placeholder="비밀번호" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>이름 : </span>
						<span class="input_box">
							<input type="name" id="name" placeholder="이름" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>주소 : </span>
						<span class="input_box">
							<input type="addr" id="addr" placeholder="주소" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span>생년월일 : </span>
						<span class="input_box">
							<input type="birth" id="bitrh" placeholder="생년월일" maxlength="20"/>
						</span>
					</div>
					<div class="input_button">
						<a href="${context}/member/loginForm">
							<span class="input_box">
								<input type="button" id="JoinButton" value="회원가입" />
							</span>
						</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>